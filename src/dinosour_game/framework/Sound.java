package dinosour_game.framework;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    public static void playSound(String path ) {
        Clip clip;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream( new File(path) );
            clip.open(inputStream);
            clip.start();
            }
        catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }



}
