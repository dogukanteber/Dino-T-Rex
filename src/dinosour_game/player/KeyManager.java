package dinosour_game.player;

import dinosour_game.gamestate.StateID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {


    Game game;

    public KeyManager( Game game ) {
        this.game = game;
    }

    @Override
    public void keyPressed( KeyEvent e ) {
        if ( game.getGameStateManager().getCurrentState() == StateID.InitialState ) {
            if ( e.getKeyCode() == KeyEvent.VK_SPACE ) {
                game.getGameStateManager().setCurrentState(StateID.PlayState);
            }
        }
        else if ( e.getKeyCode() == KeyEvent.VK_SPACE && !game.getPlayState().getPlayer().isJumped() ) {
            game.getPlayState().getPlayer().jump();
        }
    }
}
