package dynamic_beat_3;

import com.sun.jdi.event.ExceptionEvent;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Music extends Thread{

    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Music(String name, boolean  isLoop){
        try{
            this.isLoop = isLoop;
            // for mac
            //file = new File("/home/lhs/java/JavaExam/Dynamic_Beat/src/music/"+name);
            // for windows10
            //file = new File(Main.class.getResource("C:\\Users\\lhs\\Desktop\\java\\JavaExam\\Dynamic_Beat\\src\\music\\dizzy.mp3").toURI());
            file = new File("C:\\Users\\lhs\\Desktop\\java\\JavaExam\\Dynamic_Beat\\src\\music\\dizzy.mp3");
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getTime(){
        if(player == null){
            return 0;
        }
        return player.getPosition();
    }

    public void close(){
        isLoop = false;
        player.close();
        this.interrupt();
    }

    @Override
    public void run(){
        try{
            do{
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
                player.play();
            }while(isLoop);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
