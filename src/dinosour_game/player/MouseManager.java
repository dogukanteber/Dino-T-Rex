package dinosour_game.player;

import dinosour_game.gamestate.StateID;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseManager extends MouseAdapter {

    Game game;

    public MouseManager( Game game ) {
        this.game = game;
    }

    @Override
    public void mousePressed( MouseEvent e ) {
        if ( game.getGameStateManager().getCurrentState() == StateID.EndState ) {
            int x = e.getX();
            int y = e.getY();
            game.getEndState().restartGame(x,y);
        }
    }

    @Override
    public void mouseReleased( MouseEvent e ) {
        game.render();
    }
}
