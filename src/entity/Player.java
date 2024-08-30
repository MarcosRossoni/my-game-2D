package entity;

import enumeration.PlayerImages;
import main.GamePanel;
import main.KeyHundler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHundler keyHundler;

    public Player(GamePanel gamePanel, KeyHundler keyHundler, Screen screen) {

        this.gamePanel = gamePanel;
        this.keyHundler = keyHundler;

        setSolidArea(new Rectangle());
        getSolidArea().x = 8;
        getSolidArea().y = 16;
        getSolidArea().width = 32;
        getSolidArea().height = 32;
        setDefaltValues(screen);
        getPlayerImage();
    }

    public void update(int originalTitle, int scale) {

        if (keyHundler.upPressed || keyHundler.downPressed ||
                keyHundler.leftPressed || keyHundler.rightPressed) {
            int y = getWorldY();
            int x = getWorldX();
            String direction = getDirection();
            if (keyHundler.upPressed) {
                direction = "up";
                y = getWorldY() - getSpeed();
            } else if (keyHundler.downPressed) {
                direction = "down";
                y = getWorldY() + getSpeed();
            } else if (keyHundler.leftPressed) {
                direction = "left";
                x = getWorldX() - getSpeed();
            } else if (keyHundler.rightPressed) {
                direction = "right";
                x = getWorldX() + getSpeed();
            }

            setColisionOn(false);
            gamePanel.collisionChecker.checkTile(this, originalTitle, scale);
            setWorldY(y);
            setWorldX(x);
            setDirection(direction);
            setSpriteCounter(getSpriteCounter() + 1);
            if (getSpriteCounter() > 12) {
                if (getSpritNumber() == 1) {
                    setSpritNumber(2);
                } else if (getSpritNumber() == 2) {
                    setSpritNumber(1);
                }
                setSpriteCounter(0);
            }
        }
    }

    public void draw(Graphics2D g2, Screen screen) {
        BufferedImage image = switch (getDirection()) {
            case "up" -> getSpritNumber() == 1 ? getUp1() : getUp2();
            case "down" -> getSpritNumber() == 1 ? getDown1() : getDown2();
            case "left" -> getSpritNumber() == 1 ? getLeft1() : getLeft2();
            case "right" -> getSpritNumber() == 1 ? getRight1() : getRight2();
            default -> null;
        };

        g2.drawImage(image, screen.getScreenX(), screen.getScreenY(), screen.getTitleSize(), screen.getTitleSize(), null);
    }

    //--

    private void setDefaltValues(Screen screen) {
        setWorldX(screen.getTitleSize() * 23);
        setWorldY(screen.getTitleSize() * 21);
        setSpeed(4);
        setDirection("down");
    }

    private void getPlayerImage() {

        try {
            setUp1(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(PlayerImages.BOY_UP_1.getDsPathFile()))));
            setUp2(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(PlayerImages.BOY_UP_2.getDsPathFile()))));
            setDown1(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(PlayerImages.BOY_DOWN_1.getDsPathFile()))));
            setDown2(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(PlayerImages.BOY_DOWN_2.getDsPathFile()))));
            setLeft1(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(PlayerImages.BOY_LEFT_1.getDsPathFile()))));
            setLeft2(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(PlayerImages.BOY_LEFT_2.getDsPathFile()))));
            setRight1(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(PlayerImages.BOY_RIGHT_1.getDsPathFile()))));
            setRight2(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(PlayerImages.BOY_RIGHT_2.getDsPathFile()))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
