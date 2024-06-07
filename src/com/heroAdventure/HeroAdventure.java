package com.heroAdventure;
import java.io.IOException;


/**
 * Classe principale pour l'aventure du héros.
 */
public class HeroAdventure {

    public static void main(String[] args) {
        try {
            // Charger la carte à partir du fichier
            char[][] map = MapLoader.readMap("resources/carte.txt");

            // Charger les données de mouvements à partir du fichier
            String[] movementsData = MovementsLoader.readMovements("resources/movements2.txt");

            // Calculer la position finale du personnage
            int[] finalPosition = moveCharacter(map, movementsData);

            // Afficher la position finale du personnage
            System.out.println("Position finale : (" + finalPosition[0] + ", " + finalPosition[1] + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Simule les déplacements du personnage sur la carte.
     *
     * @param map La carte sous forme de tableau 2D de caractères.
     * @param movementsData Les données de déplacements sous forme de tableau de chaînes.
     * @return Un tableau contenant les coordonnées finales (x, y) du personnage.
     */
    public static int[] moveCharacter(char[][] map, String[] movementsData) {
        // Lire la position initiale
        String[] initialPosition = movementsData[0].split(",");
        int x = Integer.parseInt(initialPosition[0]);
        int y = Integer.parseInt(initialPosition[1]);

        // Lire les mouvements
        String movements = movementsData[1];

        // Appliquer les mouvements
        for (char move : movements.toCharArray()) {
            switch (move) {
                case 'N':
                    y = (y > 0 && map[y - 1][x] == ' ') ? y - 1 : y;
                    break;
                case 'S':
                    y = (y < map.length - 1 && map[y + 1][x] == ' ') ? y + 1 : y;
                    break;
                case 'E':
                    x = (x < map[0].length - 1 && map[y][x + 1] == ' ') ? x + 1 : x;
                    break;
                case 'O':
                    x = (x > 0 && map[y][x - 1] == ' ') ? x - 1 : x;
                    break;
            }
        }
        return new int[]{x, y};
    }
}
