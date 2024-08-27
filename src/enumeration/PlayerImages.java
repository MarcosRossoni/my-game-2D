package enumeration;

import java.util.Arrays;

public enum PlayerImages {

    BOY_UP_1(1, "/player/boy_up_1.png"),

    BOY_UP_2(2, "/player/boy_up_2.png"),

    BOY_DOWN_1(3, "/player/boy_down_1.png"),

    BOY_DOWN_2(4, "/player/boy_down_2.png"),

    BOY_LEFT_1(5, "/player/boy_left_1.png"),

    BOY_LEFT_2(6, "/player/boy_left_2.png"),

    BOY_RIGHT_1(7, "/player/boy_right_1.png"),

    BOY_RIGHT_2(8, "/player/boy_right_2.png");

    private final Integer idImage;
    private final String dsPathFile;

    PlayerImages(Integer idImage, String dsPathFile) {
        this.idImage = idImage;
        this.dsPathFile = dsPathFile;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public String getDsPathFile() {
        return dsPathFile;
    }
}
