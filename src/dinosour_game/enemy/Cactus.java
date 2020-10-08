package dinosour_game.enemy;

import dinosour_game.framework.Const;
import dinosour_game.framework.Images;

import java.awt.*;

public class Cactus extends Obstacle {

    public Cactus( float x, float y ) {
        super(x,y);
    }

    @Override
    public void update() {
        setX(getX()- Const.GAME_SPEED);
    }

    @Override
    public void render( Graphics g ) {
        g.drawImage(Images.cactus,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,Const.CACTUS_WIDTH,Const.CACTUS_HEIGHT);
    }

    @Override
    public boolean isInFrame() {
        return getX() + Const.CACTUS_WIDTH > 0;
    }

}
