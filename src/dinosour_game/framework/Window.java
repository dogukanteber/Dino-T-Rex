package dinosour_game.framework;


import dinosour_game.player.Game;

import javax.swing.*;
import java.awt.*;

public class Window {

    JFrame frame;


    public Window( Game game) {
        frame = new JFrame();

        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Google Chrome Dinosour Game");
        frame.setFocusable(true);

        frame.setPreferredSize( new Dimension(Const.WINDOW_WIDTH,Const.WINDOW_HEIGHT) );
        frame.setMinimumSize( new Dimension(Const.WINDOW_WIDTH,Const.WINDOW_HEIGHT) );
        frame.setMaximumSize( new Dimension(Const.WINDOW_WIDTH,Const.WINDOW_HEIGHT) );

        frame.setVisible(true);
        frame.add(game);
    }

}
