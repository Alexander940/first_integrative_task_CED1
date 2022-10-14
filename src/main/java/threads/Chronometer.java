package threads;

import javafx.application.Platform;

/**
 * This class counts how long the game lasts
 */
public class Chronometer extends Thread{

    private boolean flag;
    private int seconds;

    public Chronometer(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while(flag){
            //Platform.runLater(() -> );
            try{
                seconds++;
                Thread.sleep(1000);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getSeconds() {
        return seconds;
    }
}
