package dinosour_game.player;

import dinosour_game.framework.Const;
import dinosour_game.framework.Sound;
import java.awt.*;

public class Score {

    private float score = 0;


    public void update() {
        score += Const.INCREMENT_VALUE;
        if ( score % 100 == 0 ) {
            Sound.playSound("src/dinosour_game/res/scoreup.wav");
        }
    }

    public void render( Graphics g ) {
        g.setColor(Color.black);
        g.drawString("SCORE : " + (int)score,Const.WINDOW_WIDTH/2+175,20);
    }

}
