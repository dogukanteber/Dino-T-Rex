package dinosour_game.enemy;

import java.awt.*;

public abstract class Obstacle {

    float x,y;

    public Obstacle( float x, float y ) {
        this.x = x;
        this.y = y;
    }

    public abstract void update();
    public abstract void render( Graphics g );
    public abstract Rectangle getBounds();
    public abstract boolean isInFrame();

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
