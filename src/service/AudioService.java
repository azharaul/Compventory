package service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

interface Audio {
    void playSound();
    void stopSound();
}

public class AudioService implements Audio {
    protected Clip clip;
    protected String path;
    public AudioService(){
        
    }
    public AudioService (String path) {
        this.path = path;
    }

    @Override
    public void playSound() {
        try {
            File audioFile = new File(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Format audio tidak didukung: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Gagal membaca file audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Line audio tidak tersedia: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat memutar audio: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    @Override
    public void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }
    
    
    public void play(String role){
        AudioService audio = null;
        if("Admin".equalsIgnoreCase(role)){
            audio = new AudioAdmin();
        }else if("User".equalsIgnoreCase(role)){
            audio = new AudioUser();
        }else{
            
        }
        
        if(audio instanceof AudioAdmin){
            AudioAdmin admin = (AudioAdmin)audio;
            admin.info();
        }else if(audio instanceof AudioUser){
            AudioUser user  = (AudioUser)audio;
            user.info();
        }else{
            
        }
        
        audio.playSound();
        
         try {
            Thread.sleep(28000);
        } catch (InterruptedException e) {
            System.err.println("Thread terganggu: " + e.getMessage());
        }
         
         audio.stopSound();
    }
}

class AudioUser extends AudioService {
    public AudioUser() {
        super("src/resource/audio/Music-System.mp3");
    }
    public void info(){
        System.out.println("Audio untuk User");
    }
}

class AudioAdmin extends AudioService {
    public AudioAdmin() {
        super("src/resource/audio/Music-System.mp3");
    }
    public void info(){
        System.out.println("Audio untuk User");
    }
}

//public class AudioService {
//   
//        AudioImpl audio = new AudioUser();//up casting
//        if (audio instanceof AudioAdmin) {
//            System.out.println("Audio ini untuk ADMIN.");
//            AudioAdmin audioAdmin = (AudioAdmin)audio;//down casting
//            audioAdmin.info();
//        } else if (audio instanceof AudioUser) {
//            System.out.println("Audio ini untuk USER.");
//            AudioUser audioUser = (AudioUser)audio;//down casting
//            audioUser.info();
//        } else {
//            System.out.println("Audio ini adalah DEFAULT.");
//        }
//
//        System.out.println("Path file audio: " + audio.getPath());
//
//        audio.playSound();
//
//        try {
//            Thread.sleep(28000);
//        } catch (InterruptedException e) {
//            System.err.println("Thread terganggu: " + e.getMessage());
//        }
//
//        audio.stopSound();
//    
//}

