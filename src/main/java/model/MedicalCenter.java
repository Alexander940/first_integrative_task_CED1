package model;

import exceptions.PatientNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import threads.Chronometer;

import java.util.ArrayList;

public class MedicalCenter {

    public enum Area{
        HEMATOLOGY, GENERAL
    }

    private static MedicalCenter instance;
    private Queue<Patient> normalPatientsHematology;
    private Queue<Patient> priorityPatientsHematology;
    private Queue<Patient> normalPatientsGeneralPurpose;
    private Queue<Patient> priorityPatientsGeneralPurpose;
    private PatientInventory inventory;
    private ArrayList<Chronometer> arrayListChronometer;

    /**
     * This method is about architecture singleton
     * @return the instance of the class
     */
    public static MedicalCenter getInstance() {
        if(instance == null){
            instance = new MedicalCenter();
        }
        return instance;
    }

    private MedicalCenter(){
        inventory = new PatientInventory();
        this.normalPatientsHematology = new Queue<>();
        this.priorityPatientsHematology = new Queue<>();
        this.normalPatientsGeneralPurpose = new Queue<>();
        this.priorityPatientsGeneralPurpose = new Queue<>();
        this.arrayListChronometer = new ArrayList<>();
    }

    public void getPatientInning(Patient patient, Area areaToEnter){
        if(areaToEnter == Area.HEMATOLOGY){
            getPatientInningHematology(patient, areaToEnter);
        } else {
            getPatientInningGeneral(patient, areaToEnter);
        }
    }

    private void getPatientInningHematology(Patient patient, MedicalCenter.Area area){
        if(patient.isPriority()){
            priorityPatientsHematology.enqueue(patient);
            startChronometer(patient, area);
        } else {
            normalPatientsHematology.enqueue(patient);
            startChronometer(patient, area);
        }
    }

    private void getPatientInningGeneral(Patient patient, MedicalCenter.Area area){
        if(patient.isPriority()){
            priorityPatientsGeneralPurpose.enqueue(patient);
            startChronometer(patient, area);
        } else {
            normalPatientsGeneralPurpose.enqueue(patient);
            startChronometer(patient, area);
        }

    }

    private void startChronometer(Patient patient, MedicalCenter.Area area){
        Chronometer chronometer = new Chronometer(patient, area);
        chronometer.start();
        arrayListChronometer.add(chronometer);
    }

    public Patient findPatient(String name) throws PatientNotFoundException {
        Patient patient = inventory.findPatient(name);

        if(patient == null){
            throw new PatientNotFoundException();
        } else {
            return patient;
        }
    }

    public void geyOutPatientQueue(Chronometer chronometer) {
        if(chronometer.getArea() == Area.HEMATOLOGY){
            if(chronometer.getPatient().isPriority()){
                getOutPatientQueuePriorityHematology(chronometer);
            } else {
                getOutPatientQueueNormalHematology(chronometer);
            }
        } else {
            if(chronometer.getPatient().isPriority()){
                getOutPatientQueuePriorityGeneral(chronometer);
            } else {
                getOutPatientQueueNormalGeneral(chronometer);
            }
        }
    }

    public void getOutPatientQueuePriorityHematology(Chronometer chronometer) {
        Queue<Patient> queue = new Queue<>();

        for (int i = 0; i < priorityPatientsHematology.size(); i++) {
            Patient patient = priorityPatientsHematology.dequeue();
            if(chronometer.getPatient() != patient){
                queue.enqueue(patient);
            }
        }

        for (int i = 0; i < queue.size(); i++) {
            priorityPatientsHematology.enqueue(queue.dequeue());
        }

        finishChronometer(chronometer);
    }

    public void getOutPatientQueueNormalHematology(Chronometer chronometer) {
        Queue<Patient> queue = new Queue<>();

        for (int i = 0; i < normalPatientsHematology.size(); i++) {
            Patient patient = normalPatientsHematology.dequeue();
            if(chronometer.getPatient() != patient){
                queue.enqueue(patient);
            }
        }

        for (int i = 0; i < queue.size(); i++) {
            normalPatientsHematology.enqueue(queue.dequeue());
        }

        finishChronometer(chronometer);
    }

    public void getOutPatientQueuePriorityGeneral(Chronometer chronometer) {
        Queue<Patient> queue = new Queue<>();

        for (int i = 0; i < priorityPatientsGeneralPurpose.size(); i++) {
            Patient patient = priorityPatientsGeneralPurpose.dequeue();
            if(chronometer.getPatient() != patient){
                queue.enqueue(patient);
            }
        }

        for (int i = 0; i < queue.size(); i++) {
            priorityPatientsGeneralPurpose.enqueue(queue.dequeue());
        }

        finishChronometer(chronometer);
    }

    public void getOutPatientQueueNormalGeneral(Chronometer chronometer) {
        Queue<Patient> queue = new Queue<>();

        for (int i = 0; i < normalPatientsGeneralPurpose.size(); i++) {
            Patient patient = normalPatientsGeneralPurpose.dequeue();
            if(chronometer.getPatient() != patient){
                queue.enqueue(patient);
            }
        }

        for (int i = 0; i < queue.size(); i++) {
            normalPatientsGeneralPurpose.enqueue(queue.dequeue());
        }

        finishChronometer(chronometer);
    }

    private void finishChronometer(Chronometer chronometer) {
        for (int i = 0; i < arrayListChronometer.size(); i++) {
            if(arrayListChronometer.get(i) == chronometer){
                arrayListChronometer.remove(i);
                break;
            }
        }
    }

    public Patient enterPatientToAttention(Area area){
        if (area == Area.HEMATOLOGY){
            return dequeueNextPatientHematology();
        } else {
            return dequeueNextPatientGeneral();
        }
    }

    public Patient dequeueNextPatientHematology(){
        if(priorityPatientsHematology.isEmpty()){
            return normalPatientsHematology.dequeue();
        } else {
            return priorityPatientsHematology.dequeue();
        }
    }

    public Patient dequeueNextPatientGeneral(){
        if(priorityPatientsGeneralPurpose.isEmpty()){
            return normalPatientsGeneralPurpose.dequeue();
        } else {
            return priorityPatientsGeneralPurpose.dequeue();
        }
    }

    public Patient seeNextPatient(Area area){
        if (area == Area.HEMATOLOGY){
            return assessListHematology();
        } else {
            return assessListGeneral();
        }
    }

    public Patient assessListHematology(){
        if(priorityPatientsHematology.isEmpty()){
            return normalPatientsHematology.front();
        } else {
            return priorityPatientsHematology.front();
        }
    }

    public Patient assessListGeneral(){
        if(priorityPatientsGeneralPurpose.isEmpty()){
            return normalPatientsGeneralPurpose.front();
        } else {
            return priorityPatientsGeneralPurpose.front();
        }
    }

    public ObservableList<Patient> getListNormalPatientsHematology(){
        ArrayList<Patient> arrayList = new ArrayList<>();
        Queue<Patient> auxQueue = new Queue<>();

        for (int i = 0; i < normalPatientsHematology.size(); i++) {
            Patient patient = normalPatientsHematology.dequeue();
            arrayList.add(patient);
            auxQueue.enqueue(patient);
        }

        for (int i = 0; i < auxQueue.size(); i++) {
            normalPatientsHematology.enqueue(auxQueue.dequeue());
        }

        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Patient> getListPriorityPatientsHematology(){
        ArrayList<Patient> arrayList = new ArrayList<>();
        Queue<Patient> auxQueue = new Queue<>();

        for (int i = 0; i < priorityPatientsHematology.size(); i++) {
            Patient patient = priorityPatientsHematology.dequeue();
            arrayList.add(patient);
            auxQueue.enqueue(patient);
        }

        for (int i = 0; i < auxQueue.size(); i++) {
            priorityPatientsHematology.enqueue(auxQueue.dequeue());
        }

        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Patient> getListNormalPatientsGeneral(){
        ArrayList<Patient> arrayList = new ArrayList<>();
        Queue<Patient> auxQueue = new Queue<>();

        for (int i = 0; i < normalPatientsGeneralPurpose.size(); i++) {
            Patient patient = normalPatientsGeneralPurpose.dequeue();
            arrayList.add(patient);
            auxQueue.enqueue(patient);
        }

        for (int i = 0; i < auxQueue.size(); i++) {
            normalPatientsGeneralPurpose.enqueue(auxQueue.dequeue());
        }

        return FXCollections.observableArrayList(arrayList);
    }

    public ObservableList<Patient> getListPriorityPatientsGeneral(){
        ArrayList<Patient> arrayList = new ArrayList<>();
        Queue<Patient> auxQueue = new Queue<>();

        for (int i = 0; i < priorityPatientsGeneralPurpose.size(); i++) {
            Patient patient = priorityPatientsGeneralPurpose.dequeue();
            arrayList.add(patient);
            auxQueue.enqueue(patient);
        }

        for (int i = 0; i < auxQueue.size(); i++) {
            priorityPatientsGeneralPurpose.enqueue(auxQueue.dequeue());
        }

        return FXCollections.observableArrayList(arrayList);
    }

    public Queue<Patient> getNormalPatientsHematology() {
        return normalPatientsHematology;
    }

    public Queue<Patient> getPriorityPatientsHematology() {
        return priorityPatientsHematology;
    }

    public Queue<Patient> getNormalPatientsGeneralPurpose() {
        return normalPatientsGeneralPurpose;
    }

    public Queue<Patient> getPriorityPatientsGeneralPurpose() {
        return priorityPatientsGeneralPurpose;
    }

    public PatientInventory getInventory() {
        return inventory;
    }
}
