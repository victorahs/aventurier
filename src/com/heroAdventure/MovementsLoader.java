package com.heroAdventure;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Classe utilitaire pour charger les mouvements du personnage à partir d'un fichier.
 */
public class MovementsLoader {

    /**
     * Lit les mouvements du personnage à partir d'un fichier texte.
     *
     * @param movementsFilePath Le chemin du fichier des mouvements.
     * @return Les données de mouvements sous forme de tableau de chaînes.
     * @throws IOException Si une erreur d'E/S se produit.
     */
    public static String[] readMovements(String movementsFilePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(movementsFilePath));
        return lines.stream().toArray(String[]::new);
    }
}

