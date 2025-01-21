package edu.guilford;

public class TileInfo {
    private Tile tile;
    private int tileCount;

    public TileInfo(Tile tile, int tileCount) {
        this.tile = tile;
        this.tileCount = tileCount;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int getTileCount() {
        return tileCount;
    }

    public void setTileCount(int tileCount) {
        this.tileCount = tileCount;
    }

    @Override 
    public String toString() {
        return "TileInfo [tile=" + tile + ", tileCount=" + tileCount + "]";
    }
}

