package entity;

public class Screen {

    private int titleSize;

    private int screenWidth;

    private int screenHeight;

    private int screenX;

    private int screenY;

    private int maxScreenCol;

    private int maxScreenRow;

    private int maxWorldCol;

    private int maxWorldRow;

    private int worldWidth;

    private int worldHeight;

    public Screen() {
    }

    public Screen(int originalTitleSize, int scale, int maxCol, int maxRow, int maxWorldCol, int maxWorldRow) {
        this.titleSize = originalTitleSize * scale;
        this.screenWidth = this.titleSize * maxCol;
        this.screenHeight = this.titleSize * maxRow;
        this.maxScreenCol = maxCol;
        this.maxScreenRow = maxRow;
        this.screenX = this.screenWidth / 2 - (this.titleSize / 2);
        this.screenY = this.screenHeight / 2 - (this.titleSize / 2);
        this.worldWidth = this.titleSize * maxWorldCol;
        this.worldHeight = this.titleSize * maxWorldRow;
        this.maxWorldCol = maxWorldCol;
        this.maxWorldRow = maxWorldRow;
    }

    public int getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(int titleSize) {
        this.titleSize = titleSize;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public void setMaxScreenCol(int maxScreenCol) {
        this.maxScreenCol = maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public void setMaxScreenRow(int maxScreenRow) {
        this.maxScreenRow = maxScreenRow;
    }

    public int getScreenX() {
        return screenX;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public void setWorldHeight(int worldHeight) {
        this.worldHeight = worldHeight;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public void setWorldWidth(int worldWidth) {
        this.worldWidth = worldWidth;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public void setMaxWorldRow(int maxWorldRow) {
        this.maxWorldRow = maxWorldRow;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public void setMaxWorldCol(int maxWorldCol) {
        this.maxWorldCol = maxWorldCol;
    }
}
