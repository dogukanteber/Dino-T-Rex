package dinosour_game.map;

import java.awt.image.BufferedImage;

public class LandImage {

    BufferedImage image;
    int posX;

    public LandImage( BufferedImage image, int posX ) {
        this.image = image;
        this.posX = posX;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}
