package dinosour_game.enemy;

import dinosour_game.framework.Const;
import dinosour_game.framework.Images;

import java.awt.*;

public class WideCactus extends Obstacle {

    public WideCactus(float x, float y) {
        super(x, y);
    }

    @Override
    public void update() {
        setX(getX()- Const.GAME_SPEED);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.wideCactus,(int)x,(int)y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,Const.WIDE_CACTUS_WIDTH,Const.WIDE_CACTUS_HEIGHT);
    }

    @Override
    public boolean isInFrame() {
        return getX() + Const.WIDE_CACTUS_WIDTH > 0;
    }

}
