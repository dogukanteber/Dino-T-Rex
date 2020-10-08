package dinosour_game.gamestate;

import java.awt.*;

public abstract class State {

    StateID id;

    public State( StateID id ) {
        this.id = id;
    }

    public abstract void update();
    public abstract void render( Graphics g );
}
