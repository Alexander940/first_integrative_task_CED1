package threads;

import javafx.application.Platform;
import model.MedicalCenter;
import model.Patient;

/**
 * This class counts how long the game lasts
 */
public class Chronometer extends Thread{

    private int seconds;
    private Patient patient;
    private MedicalCenter.Area area;

    public Chronometer(Patient patient, MedicalCenter.Area area) {
        this.patient = patient;
        this.area = area;
    }

    @Override
    public void run() {
        while(seconds < 120){
            try{
                seconds++;
                Thread.sleep(1000);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
        Platform.runLater(() -> MedicalCenter.getInstance().geyOutPatientQueue(this));
    }

    public int getSeconds() {
        return seconds;
    }

    public Patient getPatient() {
        return patient;
    }

    public MedicalCenter.Area getArea() {
        return area;
    }
}
