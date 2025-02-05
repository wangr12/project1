package edu.guilford;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScrabbleProjectDriver {
    public static void main(String[] args) {
        ScrabbleSet ScrabbleSetEN = new ScrabbleSet("English");
        ScrabbleSet ScrabbleSetRandom = new ScrabbleSet();

        System.out.println("Standard Scrabble Set: ");
        System.out.println(ScrabbleSetEN);
        System.out.println("Random Scrabble Set: ");
        System.out.println(ScrabbleSetRandom);

        String[] words = {
            "harmony", "glacier", "Nebula", "Whisker", "LANTERN", "PONDER", "Fiddle", "Orbit", 
            "Canvas", "Melody", "Rustic", "Whisper", "Zephyr", "Fractal", "Blossom", "Quantum", 
            "Lush", "Euphoria", "Wander", "Twilight", "Phoenix", "Echo", "Harbor", "w93840", "$$$"
        };
        // evaluate each word and print the score
        for (String word : words) {
            System.out.println("Word: " + word + " Score: " + ScrabbleSetEN.evaluateWord(word));
        }

        // frankenstein text
        String highScoreWordEN = "";
        int highScoreEN = 0;
        String highScoreWordRandom = "";
        int highScoreRandom = 0;

        String invalidWordEN = "";
        String invalidWordRandom = "";

        try {
            File file = new File("src/main/resources/frankenstein.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (ScrabbleSetEN.evaluateWord(word) > highScoreEN) {
                    highScoreEN = ScrabbleSetEN.evaluateWord(word);
                    highScoreWordEN = word;
                }
                if (ScrabbleSetRandom.evaluateWord(word) > highScoreRandom) {
                    highScoreRandom = ScrabbleSetRandom.evaluateWord(word);
                    highScoreWordRandom = word;
                }

                if (ScrabbleSetEN.evaluateWord(word) == -1) {
                    if (word.matches(".*\\d.*") == false && word.matches(".*[^a-zA-Z0-9].*") == false) {
                        if (invalidWordEN == "") {
                            invalidWordEN = word;
                        }
                        else if (word.length() < invalidWordEN.length()) {
                            invalidWordEN = word;
                        }
                    }
                }

                if (ScrabbleSetRandom.evaluateWord(word) == -1) {
                    if (word.matches(".*\\d.*") == false && word.matches(".*[^a-zA-Z0-9].*") == false) {
                        if (invalidWordRandom == "") {
                            invalidWordRandom = word;
                        }
                        else if (word.length() < invalidWordRandom.length()) {
                            invalidWordRandom = word;
                        }
                    }
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        System.out.println("Highest Scoring Word: " + highScoreWordEN + " Score: " + highScoreEN);
        System.out.println("Highest Scoring Word: " + highScoreWordRandom + " Score: " + highScoreRandom);
        System.out.println("Invalid Word: " + invalidWordEN);
        System.out.println("Invalid Word: " + invalidWordRandom);

        Scanner scanner = new Scanner(System.in);
        String userWord = "";
        while (true) {
            System.out.print("Enter a word. Type 'exit' to exit: ");
            userWord = scanner.next();
            if (userWord.equals("exit")) {
                break;
            }
            System.out.println("Standard Scrabble Set: " + ScrabbleSetEN.evaluateWord(userWord));
            System.out.println("Random Scrabble Set: " + ScrabbleSetRandom.evaluateWord(userWord));
        }
    }
}