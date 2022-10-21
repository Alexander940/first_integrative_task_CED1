package model;

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

    public void enterPatient(Patient patient, Area areaToEnter){
        if(areaToEnter == Area.HEMATOLOGY){
            enterHematologyPatient(patient);
        } else {
            enterGeneralPatient(patient);
        }
    }

    private void enterHematologyPatient(Patient patient){
        if(patient.isPriority()){
            priorityPatientsHematology.enqueue(patient);
        } else {
            normalPatientsHematology.enqueue(patient);
        }
    }

    private void enterGeneralPatient(Patient patient){
        if(patient.isPriority()){
            priorityPatientsGeneralPurpose.enqueue(patient);
        } else {
            normalPatientsGeneralPurpose.enqueue(patient);
        }

    }

    public Patient findPatient(String name){
        return inventory.findPatient(name);
    }
}
