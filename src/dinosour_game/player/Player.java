package dinosour_game.player;

import dinosour_game.framework.Const;
import dinosour_game.framework.Images;
import dinosour_game.framework.Sound;

import java.awt.*;

public class Player {

    Animation animation;
    private float x, y, velY;
    private boolean isJumped = false;
    private boolean isAlive = true;

    public Player( float x, float y ) {
        this.x = x;
        this.y = y;
        animation = new Animation(Const.ANIMATION_SPEED);
        animation.addImage(Images.playerImage1);
        animation.addImage(Images.playerImage2);
        velY = 0;
    }

    public void update() {
        animation.update();
        if ( y >= Const.INITIAL_PLAYER_POS_Y ) {
            velY = 0;
            y = Const.INITIAL_PLAYER_POS_Y;
            isJumped = false;
        }
        else {
            velY += Const.GRAVITY;
            y += velY;
        }
    }


    public void jump() {
        velY = -Const.JUMP_HEIGHT;
        y += velY;
        isJumped = true;
        Sound.playSound("src/dinosour_game/res/jump.wav");
    }

    public void render(Graphics g ) {
        if ( isJumped ) {
            g.drawImage(animation.getJumpingImage(),(int)x,(int)y, null);
        }
        else {
            g.drawImage(animation.getCurrentImage(),(int)x,(int)y,null);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,Const.PLAYER_WIDTH-5,Const.PLAYER_HEIGHT-5);
    }

    public boolean isJumped() {
        return isJumped;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
