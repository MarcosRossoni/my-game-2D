package enumeration;

public enum TileImages {

    GRASS(0, "/tiles/grass.png"),

    WALL(1, "/tiles/wall.png"),

    WATER(2, "/tiles/water.png"),

    EARTH(3, "/tiles/earth.png"),

    TREE(4, "/tiles/tree.png"),

    SAND(5, "/tiles/sand.png"),
    ;

    private final int idImage;
    private final String dsPathImage;

    TileImages(int idImage, String dsPathImage) {
        this.idImage = idImage;
        this.dsPathImage = dsPathImage;
    }

    public int getIdImage() {
        return idImage;
    }

    public String getDsPathImage() {
        return dsPathImage;
    }
}
