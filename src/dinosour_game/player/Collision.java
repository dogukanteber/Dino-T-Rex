package dinosour_game.player;

import dinosour_game.enemy.Obstacle;
import dinosour_game.enemy.ObstacleManager;
import dinosour_game.framework.Sound;
import dinosour_game.gamestate.StateID;

public class Collision {

    ObstacleManager obstacleManager;
    Player player;
    Game game;

    public Collision(ObstacleManager obstacleManager, Player player, Game game) {
        this.obstacleManager = obstacleManager;
        this.player = player;
        this.game = game;
    }

    public void update() {
        for ( Obstacle obstacle : obstacleManager.getObstacles() ) {
            if ( obstacle.getBounds().intersects(player.getBounds()) ) {
                Sound.playSound("src/dinosour_game/res/dead.wav");
                player.setAlive(false);
                game.getGameStateManager().setCurrentState(StateID.EndState);
            }
        }
    }
}
