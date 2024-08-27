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

        mapTileNum = new int[screen.getMaxScreenCol()][screen.getMaxScreenRow()];
        tiles = new Tile[10];
        getTileImage();
        loadMap(screen);
    }

    public void draw(Graphics2D graphics2D, Screen screen) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while ((col < screen.getMaxScreenCol()) && (row < screen.getMaxScreenRow())) {

            int titleNum = mapTileNum[col][row];

            graphics2D.drawImage(tiles[titleNum].getImage(), x, y, screen.getTitleSize(), screen.getTitleSize(), null);
            col++;
            x += screen.getTitleSize();

            if (col == screen.getMaxScreenCol()) {
                col = 0;
                x = 0;
                row++;
                y += screen.getTitleSize();
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

            tiles[2] = new Tile();
            tiles[2].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.WATER.getDsPathImage()))));

            tiles[3] = new Tile();
            tiles[3].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.EARTH.getDsPathImage()))));

            tiles[4] = new Tile();
            tiles[4].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.TREE.getDsPathImage()))));

            tiles[5] = new Tile();
            tiles[5].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TileImages.SAND.getDsPathImage()))));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMap(Screen screen) {
        try {
            InputStream inputStream = Objects.requireNonNull(getClass().getResourceAsStream(Maps.MAP_01.getDsPathMap()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            while (col < screen.getMaxScreenCol() && row < screen.getMaxScreenRow()) {
                String line = bufferedReader.readLine();

                while (col < screen.getMaxScreenCol()) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == screen.getMaxScreenCol()) {
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
