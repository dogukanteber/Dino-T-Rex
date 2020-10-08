package dinosour_game.map;

import dinosour_game.framework.Const;
import dinosour_game.framework.Images;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Land {

    public List<LandImage> landImages;
    public List<LandImage> land;

    public Land() {
        landImages = new ArrayList<>();
        land = new ArrayList<>();
        initPath();
    }

    private void initPath() {
        initList();
        initLand();
    }

    private void initList() {
        landImages.add(new LandImage(Images.land1,0));
        landImages.add(new LandImage(Images.land2,0));
        landImages.add(new LandImage(Images.land3,0));
    }

    private void initLand() {
        int lengthOfLands = Const.WINDOW_WIDTH / Const.LAND_IMAGE_WIDTH + 2;
        for (int i = 0; i < lengthOfLands; i++) {
            int randomIndex = generateRandomInt();
            LandImage landImage = new LandImage(landImages.get(randomIndex).getImage(),i*Const.LAND_IMAGE_WIDTH);
            land.add(landImage);
        }
    }

    private int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(landImages.size());
    }

    public void update() {
        for (LandImage landImage : land) {
            landImage.posX -= Const.GAME_SPEED;
        }
        LandImage firstElement = land.get(0);
        LandImage lastElement = land.get(land.size()-1);
        int landImageWidth = firstElement.getImage().getWidth();
        if ( firstElement.getPosX() + landImageWidth < 0 ) {
            firstElement.setPosX(lastElement.posX + landImageWidth);
            land.add(firstElement);
            land.remove(land.get(0));
        }
    }


    public void render( Graphics g ) {
        for (int i = 0; i < land.size(); i++) {
            g.drawImage(land.get(i).getImage(), land.get(i).getPosX(), Const.INITIAL_PLAYER_POS_Y + Const.LAND_IMAGE_HEIGHT, null);
        }
    }

}
