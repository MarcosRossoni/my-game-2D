package tile;

import entity.Screen;
import enumeration.Maps;
import enumeration.TileImages;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tiles;
    int[][] mapTileNum;

    public TileManager(GamePanel gamePanel, Screen screen) {
        this.gamePanel = gamePanel;

        tiles = new Tile[10];
        mapTileNum = new int[screen.getMaxWorldCol()][screen.getMaxWorldRow()];
        getTileImage();
        loadMap(screen);
    }

    public void draw(Graphics2D graphics2D, Screen screen) {

        int worldCol = 0;
        int worldRow = 0;

        while ((worldCol < screen.getMaxWorldCol()) && (worldRow < screen.getMaxWorldRow())) {

            int titleNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * screen.getTitleSize();
            int worldY = worldRow * screen.getTitleSize();
            int screenX = worldX - gamePanel.player.getWorldX() + screen.getScreenX();
            int screenY = worldY - gamePanel.player.getWorldY() + screen.getScreenY();

            if (worldX + screen.getTitleSize() > gamePanel.player.getWorldX() - screen.getScreenX() &&
                    worldX - screen.getTitleSize() < gamePanel.player.getWorldX() + screen.getScreenX() &&
                    worldY + screen.getTitleSize() > gamePanel.player.getWorldY() - screen.getScreenY() &&
                    worldY -screen.getTitleSize() < gamePanel.player.getWorldY() + screen.getScreenY()) {
                graphics2D.drawImage(tiles[titleNum].getImage(), screenX, screenY, screen.getTitleSize(), screen.getTitleSize(), null);
            }
            worldCol++;

            if (worldCol == screen.getMaxWorldCol()) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    //--

    private void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.GRASS.getDsPathImage()))));

            tiles[1] = new Tile();
            tiles[1].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.WALL.getDsPathImage()))));
            tiles[1].setCollision(true);

            tiles[2] = new Tile();
            tiles[2].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.WATER.getDsPathImage()))));
            tiles[2].setCollision(true);

            tiles[3] = new Tile();
            tiles[3].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.EARTH.getDsPathImage()))));

            tiles[4] = new Tile();
            tiles[4].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.TREE.getDsPathImage()))));
            tiles[4].setCollision(true);

            tiles[5] = new Tile();
            tiles[5].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.SAND.getDsPathImage()))));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMap(Screen screen) {
        try {
            InputStream inputStream = Objects.requireNonNull(getClass().getResourceAsStream(Maps.MAP_02.getDsPathMap()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            while (col < screen.getMaxWorldCol() && row < screen.getMaxWorldRow()) {
                String line = bufferedReader.readLine();

                while (col < screen.getMaxWorldCol()) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == screen.getMaxWorldCol()) {
                    col = 0;
                    row++;
                }
            }
            bufferedReader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
