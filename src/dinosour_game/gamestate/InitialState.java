package dinosour_game.gamestate;

import dinosour_game.framework.Const;
import dinosour_game.framework.Images;

import java.awt.*;

public class InitialState extends State{

    public InitialState( StateID id ) {
        super(id);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.playerImage3, Const.INITIAL_PLAYER_POS_X,Const.INITIAL_PLAYER_POS_Y,null);
    }

}
