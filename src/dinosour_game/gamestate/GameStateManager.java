package dinosour_game.gamestate;

import dinosour_game.player.Game;

import java.awt.*;

public class GameStateManager {

    Game game;
    private StateID currentState;


    public GameStateManager(Game game) {
        this.game = game;
        currentState = StateID.InitialState;
    }

    public void update() {
        if ( currentState == StateID.InitialState ) {
            game.getInitialState().update();
        }
        else if ( currentState == StateID.PlayState ) {
            game.getPlayState().update();
        }
        else if ( currentState == StateID.TestState ) {
            game.getPlayState().update();
        }
        else {
            game.getEndState().update();
        }
    }

    public void render( Graphics g )  {
        if ( currentState == StateID.InitialState ) {
            game.getInitialState().render(g);
        }
        else if ( currentState == StateID.PlayState ) {
            game.getPlayState().render(g);
        }
        else if ( currentState == StateID.TestState ) {
            game.getPlayState().render(g);
        }
        else {
            game.getEndState().render(g);
        }
    }

    public StateID getCurrentState() {
        return currentState;
    }

    public void setCurrentState(StateID currentState) {
        this.currentState = currentState;
    }

}