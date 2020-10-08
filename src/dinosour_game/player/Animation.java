package dinosour_game.player;


import dinosour_game.framework.Images;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {

    List<BufferedImage> runningAnimation;
    int currentIndex;

    private int deltaTime;
    private long previousTime;


    public Animation( int deltaTime ) {
        this.deltaTime = deltaTime;
        runningAnimation = new ArrayList<>();
        currentIndex = 0;
    }

    public void update() {
        if ( System.currentTimeMillis() - previousTime > deltaTime ) {
            currentIndex++;
            if ( currentIndex >= runningAnimation.size() ) {
                currentIndex = 0;
            }
            previousTime = System.currentTimeMillis();
        }
    }

    public BufferedImage getCurrentImage() {
        return runningAnimation.size() > 0 ? runningAnimation.get(currentIndex) : null;
    }

    public BufferedImage getJumpingImage() {
        return Images.playerImage3;
    }

    public void addImage( BufferedImage image ) {
        runningAnimation.add(image);
    }

}
