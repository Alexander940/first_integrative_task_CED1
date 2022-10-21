package model;

import exceptions.PatientNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    }

    public void getPatientInning(Patient patient, Area areaToEnter){
        if(areaToEnter == Area.HEMATOLOGY){
            getPatientInningHematology(patient);
        } else {
            getPatientInningGeneral(patient);
        }
    }

    private void getPatientInningHematology(Patient patient){
        if(patient.isPriority()){
            priorityPatientsHematology.enqueue(patient);
        } else {
            normalPatientsHematology.enqueue(patient);
        }
    }

    private void getPatientInningGeneral(Patient patient){
        if(patient.isPriority()){
            priorityPatientsGeneralPurpose.enqueue(patient);
        } else {
            normalPatientsGeneralPurpose.enqueue(patient);
        }

    }

    public Patient findPatient(String name) throws PatientNotFoundException {
        Patient patient = inventory.findPatient(name);

        if(patient == null){
            throw new PatientNotFoundException();
        } else {
            return patient;
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
        if(priorityPatientsHematology.isEmpty()){
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
