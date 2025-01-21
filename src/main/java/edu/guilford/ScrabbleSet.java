package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class ScrabbleSet {
    private ArrayList<TileInfo> tileInfos = new ArrayList<>();
    private Random random = new Random();
    
    // constructor
    public ScrabbleSet(String language) {
        if (language.equals("English")) {
            // English Scrabble set
            tileInfos.add(new TileInfo(new Tile('A', 1), 9));
            tileInfos.add(new TileInfo(new Tile('B', 3), 2));
            tileInfos.add(new TileInfo(new Tile('C', 3), 2));
            tileInfos.add(new TileInfo(new Tile('D', 2), 4));
            tileInfos.add(new TileInfo(new Tile('E', 1), 12));
            tileInfos.add(new TileInfo(new Tile('F', 4), 2));
            tileInfos.add(new TileInfo(new Tile('G', 2), 3));
            tileInfos.add(new TileInfo(new Tile('H', 4), 2));
            tileInfos.add(new TileInfo(new Tile('I', 1), 9));
            tileInfos.add(new TileInfo(new Tile('J', 8), 1));
            tileInfos.add(new TileInfo(new Tile('K', 5), 1));
            tileInfos.add(new TileInfo(new Tile('L', 1), 4));
            tileInfos.add(new TileInfo(new Tile('M', 3), 2));
            tileInfos.add(new TileInfo(new Tile('N', 1), 6));
            tileInfos.add(new TileInfo(new Tile('O', 1), 8));
            tileInfos.add(new TileInfo(new Tile('P', 3), 2));
            tileInfos.add(new TileInfo(new Tile('Q', 10), 1));
            tileInfos.add(new TileInfo(new Tile('R', 1), 6));
            tileInfos.add(new TileInfo(new Tile('S', 1), 4));
            tileInfos.add(new TileInfo(new Tile('T', 1), 6));
            tileInfos.add(new TileInfo(new Tile('U', 1), 4));
            tileInfos.add(new TileInfo(new Tile('V', 4), 2));
            tileInfos.add(new TileInfo(new Tile('W', 4), 2));
            tileInfos.add(new TileInfo(new Tile('X', 8), 1));
            tileInfos.add(new TileInfo(new Tile('Y', 4), 2));
            tileInfos.add(new TileInfo(new Tile('Z', 10), 1));
            tileInfos.add(new TileInfo(new Tile(' ', 0), 2));
        }
    }

    public ScrabbleSet() {
        int toalCount = 100-27;
        int countLimit = 12;
        // add all 27 tiles with standard scrabble values but each with a random count
        for (char c = 'A'; c <= 'Z'; c++) {
            int value = 1;
            if (c == 'Q' || c == 'Z') {
                value = 10;
            } else if (c == 'J' || c == 'X') {
                value = 8;
            } else if (c == 'K') {
                value = 5;
            } else if (c == 'F' || c == 'H' || c == 'V' || c == 'W' || c == 'Y') {
                value = 4;
            } else if (c == 'B' || c == 'C' || c == 'M' || c == 'P') {
                value = 3;
            } else if (c == 'D' || c == 'G') {
                value = 2;
            }

            tileInfos.add(new TileInfo(new Tile(c, value), 1));
        }
        tileInfos.add(new TileInfo(new Tile(' ', 0), 1));

        while (toalCount > 0) {
            int index = random.nextInt(27);
            TileInfo tileInfo = tileInfos.get(index);
            if (tileInfo.getTileCount() >= countLimit) {
                break;
            }
            else {
                tileInfo.setTileCount(tileInfo.getTileCount() + 1);
                toalCount--;
            }
        }

        
    }

    public int evaluateWord(String word) {
        // create a copy of tileInfos
        ArrayList<TileInfo> tempTileInfos = new ArrayList<>();
        for (TileInfo tileInfo : tileInfos) {
            tempTileInfos.add(new TileInfo(tileInfo.getTile(), tileInfo.getTileCount()));
        }

        int score = 0;
        for (int i = 0; i < word.length(); i++) {

            char c = Character.toUpperCase(word.charAt(i));
            if ((c < 'A' || c > 'Z') && c!= ' ') {
                return -1;
            }

            for (TileInfo tileInfo : tempTileInfos) {
                if (tileInfo.getTile().getLetter() == c) {
                    if (tileInfo.getTileCount() == 0) {
                        return -1;
                    } else {
                        score += tileInfo.getTile().getValue();
                        tileInfo.setTileCount(tileInfo.getTileCount() - 1);}
                    break;
                }
            }
        }
        return score;
    }

    // toString
    @Override
    public String toString() {
        String str = "";
        for (TileInfo tileInfo : tileInfos) {
            str += tileInfo + "\n";
        }
        return str;
    }

}
