package dinosour_game.gamestate;

import dinosour_game.player.Collision;
import dinosour_game.enemy.ObstacleManager;
import dinosour_game.framework.Const;
import dinosour_game.map.Clouds;
import dinosour_game.map.Land;
import dinosour_game.player.Game;
import dinosour_game.player.Player;
import dinosour_game.player.Score;

import java.awt.*;

public class PlayState extends State {

    Land land;
    Game game;
    Score score;
    Clouds clouds;
    Player player;
    Collision collision;
    ObstacleManager obstacleManager;

    public Player getPlayer() {
        return player;
    }

    public PlayState(StateID id, Game game ) {
        super(id);
        this.game = game;
        land = new Land();
        score = new Score();
        clouds = new Clouds();
        obstacleManager = new ObstacleManager();
        player = new Player(Const.INITIAL_PLAYER_POS_X,Const.INITIAL_PLAYER_POS_Y);
        collision = new Collision(obstacleManager,player,game);
    }

    public void update() {
        player.update();
        clouds.update();
        land.update();
        obstacleManager.update();
        collision.update();
        score.update();
        if ( !player.isAlive() ) {
            game.getGameStateManager().setCurrentState(StateID.EndState);
        }
    }

    public void render( Graphics g ) {
        clouds.render(g);
        land.render(g);
        player.render(g);
        obstacleManager.render(g);
        score.render(g);
    }
}
