package edu.guilford;

import java.io.*;
import java.util.Scanner;

public class ScrabbleProjectDriver {
    public static void main(String[] args) {
        ScrabbleSet ScrabbleSetEN = new ScrabbleSet("English");
        ScrabbleSet ScrabbleSetRandom = new ScrabbleSet();

        System.out.println(ScrabbleSetEN);
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

        try {
            File file = new File("frankenstein.txt");
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
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        System.out.println("Highest Scoring Word: " + highScoreWordEN + " Score: " + highScoreEN);

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