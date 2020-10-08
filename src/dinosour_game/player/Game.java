package dinosour_game.player;

import dinosour_game.framework.Const;
import dinosour_game.framework.Images;
import dinosour_game.framework.Window;
import dinosour_game.gamestate.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{


    Images images;
    Window window;
    KeyManager keyManager;
    MouseManager mouseManager;

    EndState endState;
    PlayState playState;
    InitialState initialState;
    GameStateManager gameStateManager;

    Thread thread;
    private boolean running = false;


    public Game() {
        window = new Window(this);
        images = new Images();
        images.loadImages();
        keyManager = new KeyManager(this);
        mouseManager = new MouseManager(this);
        addKeyListener( keyManager );
        addMouseListener( mouseManager );

        initialState = new InitialState(StateID.InitialState);
        playState = new PlayState(StateID.PlayState,this);
        endState = new EndState(StateID.EndState,this,playState);
        gameStateManager = new GameStateManager(this);

    }

    public void start() {
        if ( !running ) {
            thread = new Thread(this);
            thread.start();
            running = true;
        }
    }

    public void stop() {
        try {
            if ( running ) {
                thread.join();
                running = false;
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while ( running ) {
            long now = System.nanoTime();
            delta += ( now - lastTime ) / ns;
            lastTime = now;

            while ( delta >= 1 ) {
                update();
                delta--;
            }
            if ( running ) {
                render();
            }
            frames++;

            if ( System.currentTimeMillis() - timer > 1000 ) {
                timer += 1000;
                System.out.println("FPS : " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void update() {

        gameStateManager.update();
    }

    public void render()  {
        BufferStrategy bs = getBufferStrategy();
        if ( bs == null ) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.clearRect(0,0,Const.WINDOW_WIDTH,Const.WINDOW_HEIGHT);
        g.setColor(Color.decode("#f7f7f7"));
        g.fillRect(0,0,Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);

        gameStateManager.render(g);

        g.dispose();
        bs.show();
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public EndState getEndState() {
        return endState;
    }

    public PlayState getPlayState() {
        return playState;
    }

    public InitialState getInitialState() {
        return initialState;
    }
}
