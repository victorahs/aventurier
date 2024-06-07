package com.heroAdventure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Classe utilitaire pour charger la carte à partir d'un fichier.
 */
public class MapLoader {

    /**
     * Lit la carte à partir d'un fichier texte.
     *
     * @param mapFilePath Le chemin du fichier de la carte.
     * @return La carte sous forme de tableau 2D de caractères.
     * @throws IOException Si une erreur d'E/S se produit.
     */
    public static char[][] readMap(String mapFilePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(mapFilePath));
        return lines.stream()
                    .map(String::toCharArray)
                    .toArray(char[][]::new);
    }
}

