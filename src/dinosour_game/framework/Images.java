package dinosour_game.framework;


import java.awt.image.BufferedImage;

public class Images {

    public static BufferedImage playerImage1, playerImage2, playerImage3, playerImage4,
            land1, land2, land3, cloud,cactus,wideCactus,restartButton, gameOver;

    public void loadImages() {
        playerImage1 = ImageLoader.loadImage("src/dinosour_game/res/main-character1.png");
        playerImage2 = ImageLoader.loadImage("src/dinosour_game/res/main-character2.png");
        playerImage3 = ImageLoader.loadImage("src/dinosour_game/res/main-character3.png");
        playerImage4 = ImageLoader.loadImage("src/dinosour_game/res/main-character4.png");
        land1 = ImageLoader.loadImage("src/dinosour_game/res/land1.png");
        land2 = ImageLoader.loadImage("src/dinosour_game/res/land2.png");
        land3 = ImageLoader.loadImage("src/dinosour_game/res/land3.png");
        cloud = ImageLoader.loadImage("src/dinosour_game/res/cloud.PNG");
        cactus = ImageLoader.loadImage("src/dinosour_game/res/cactus1.png");
        wideCactus = ImageLoader.loadImage("src/dinosour_game/res/cactus2.png");
        restartButton = ImageLoader.loadImage("src/dinosour_game/res/replay_button.png");
        gameOver = ImageLoader.loadImage("src/dinosour_game/res/gameover_text.png");
    }
}
