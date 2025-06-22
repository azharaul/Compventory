package service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

interface Audio {
    void playSound();
    void stopSound();
    void info();
    
    public interface InnerAudio {
        void playSound();
        void stopSound();
        void info();
    }
}

/**
 *
 * @author Zildjian XTO
 */
public class AudioService implements Audio {
    private static AudioService currentAudio = null;
    private static boolean isMusicOn = true;

    /**
     *
     */
    protected Clip clip;

    /**
     *
     */
    protected String path;

    /**
     *
     */
    public AudioService() {}

    /**
     *
     * @param path
     */
    public AudioService(String path) {
        this.path = path;
    }

    /**
     *
     */
    @Override
    public void playSound() {
        try {
            File audioFile = new File(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
            
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                }
            });

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (UnsupportedAudioFileException e) {
            System.err.println("Audio format not supported: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Failed to read audio file: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Audio line is not available: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Failed to play the audio: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    /**
     *
     */
    @Override
    public void stopSound() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    /**
     *
     */
    @Override
    public void info() {
        System.out.println("Generic Audio");
    }

    /**
     *
     * @return
     */
    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @return
     */
    public Clip getClip() {
        return clip;
    }

    /**
     *
     * @param role
     */
    public static void play(String role) {
        if (!isMusicOn) return;

        if (currentAudio != null && currentAudio.isPlaying()) {
            return;
        }

        if (currentAudio != null) {
            currentAudio.stopSound();
        }

        if ("Admin".equalsIgnoreCase(role)) {
            currentAudio = new AudioAdmin();
        } else if ("User".equalsIgnoreCase(role)) {
            currentAudio = new AudioUser();
        } else {
            return;
        }

        currentAudio.info();
        new Thread(currentAudio::playSound).start(); 
    }

    /**
     *
     */
    public static void stop() {
        if (currentAudio != null) {
            currentAudio.stopSound();
            currentAudio = null;
        }
    }

    /**
     *
     * @param role
     */
    public static void toggleMusic(String role) {
        isMusicOn = !isMusicOn;

        if (!isMusicOn) {
            stop();
            System.out.println("Music OFF");
        } else {
            System.out.println("Music ON");
            play(role);
        }
    }

    /**
     *
     * @return
     */
    public static boolean isMusicOn() {
        return isMusicOn;
    }
    
    class InnerUser extends AudioService {
        public InnerUser() {
            super("src/resource/audio/Music-System.wav");
        }

        @Override
        public void info() {
            System.out.println("Audio for User");
        }
    }

    class InnerAdmin extends AudioService {
        public InnerAdmin() {
            super("src/resource/audio/Music-System.wav");
        }

        @Override
        public void info() {
            System.out.println("Audio for Admin");
        }
    }
}

class AudioUser extends AudioService {
    public AudioUser() {
        super("src/resource/audio/Music-System.wav");
    }

    @Override
    public void info() {
        System.out.println("Audio for User");
    }
}

class AudioAdmin extends AudioService {
    public AudioAdmin() {
        super("src/resource/audio/Music-System.wav");
    }

    @Override
    public void info() {
        System.out.println("Audio for Admin");
    }
}