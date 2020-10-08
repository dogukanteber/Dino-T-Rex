package dinosour_game.map;

import dinosour_game.framework.Const;
import dinosour_game.framework.Images;

import java.awt.*;
import java.util.ArrayList;

public class Clouds {

    ArrayList<Cloud> clouds;


    public Clouds() {
        clouds = new ArrayList<>();
        initClouds();
    }

    public void initClouds() {
        clouds.add( new Cloud(100,70) );
        clouds.add( new Cloud(250,50) );
        clouds.add( new Cloud(374, 2) );
        clouds.add( new Cloud(600,30) );
    }

    public void update() {
        for ( Cloud cloud : clouds ) {
            cloud.setX(cloud.getX()- Const.GAME_SPEED);
        }

        Cloud firstElement = clouds.get(0);
        if ( clouds.get(0).getX() + Const.CLOUD_WIDTH < 0 ) {
            firstElement.setX(Const.WINDOW_WIDTH);
            clouds.remove(clouds.get(0));
            clouds.add(firstElement);
        }
    }

    public void render( Graphics g ) {
        for (Cloud cloud : clouds) {
            g.drawImage(Images.cloud, cloud.getX(), cloud.getY(), null);
        }
    }

}