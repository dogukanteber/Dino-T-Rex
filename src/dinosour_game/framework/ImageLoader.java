package dinosour_game.framework;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageLoader {

    public static BufferedImage loadImage( String path ) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read( new File(path) );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

}
