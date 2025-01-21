package edu.guilford;

public class Tile {
    private char letter;
    private int value;

    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    // Getters and setters
    public char getLetter() {
        return letter;
    }
    public int getValue() {
        return value;
    }  
    public void setLetter(char letter) {
        this.letter = letter;
    }
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tile [letter=" + letter + ", value=" + value + "]";
    }
}
