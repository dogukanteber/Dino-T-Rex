package dinosour_game.enemy;

import dinosour_game.framework.Const;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ObstacleManager {

    Cactus cactus;
    WideCactus wideCactus;
    Random random = new Random();

    Obstacle[] obstacleTypes;
    ArrayList<Obstacle> obstacles;

    public ObstacleManager() {
        cactus = new Cactus(650, Const.INITIAL_PLAYER_POS_Y);
        wideCactus = new WideCactus(650,Const.INITIAL_PLAYER_POS_Y+12);

        obstacles = new ArrayList<>();
        obstacleTypes = new Obstacle[2];

        initObstacleList();

    }

    private void initObstacleList() {
        obstacles.add(cactus);
    }

    public void update() {
        for (Obstacle obstacle : obstacles) {
            obstacle.update();
        }
        Obstacle firstObstacle = obstacles.get(0);
        if ( !firstObstacle.isInFrame() ) {
            obstacles.remove(firstObstacle);
            obstacles.add(getRandomObstacle());
        }
    }

    private Obstacle getRandomObstacle() {
        if ( random.nextBoolean() ) {
            cactus.setX(650);
            return cactus;
        }
        else {
            wideCactus.setX(650);
            return wideCactus;
        }
    }

    public void render( Graphics g ) {
        for (Obstacle obstacle : obstacles) {
            obstacle.render(g);
        }
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

}