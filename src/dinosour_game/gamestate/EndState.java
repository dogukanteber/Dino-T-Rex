package dinosour_game.gamestate;

import dinosour_game.framework.Const;
import dinosour_game.framework.Images;
import dinosour_game.player.Game;

import java.awt.*;

public class EndState extends State{

    Game game;
    PlayState playState;

    private static final int restartButtonX = Const.WINDOW_WIDTH/2-Const.RESTART_BUTTON_WIDTH;
    private static final int restartButtonY = Const.WINDOW_HEIGHT/2-Const.RESTART_BUTTON_HEIGHT/2;

    public EndState( StateID id, Game game, PlayState playState ) {
        super(id);
        this.game = game;
        this.playState = playState;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics g) {
        playState.render(g);
        g.drawImage(Images.playerImage4,(int)playState.getPlayer().getX(),(int)playState.getPlayer().getY(),null);
        g.drawImage(Images.restartButton, restartButtonX,
                                        restartButtonY,null);
        g.drawImage(Images.gameOver,Const.WINDOW_WIDTH/2-Const.GAMEOVER_WIDTH/2,Const.WINDOW_HEIGHT/2-Const.GAMEOVER_HEIGHT/2-50,null);
    }

    public void restartGame( int x, int y ) {
        if ( restartButtonX <= x && x <= restartButtonX + Const.RESTART_BUTTON_WIDTH ) {
            if ( restartButtonY <= y && y <= restartButtonY + Const.RESTART_BUTTON_HEIGHT ) {
                System.out.println("GAME IS OVER");
            }
        }
    }



}
