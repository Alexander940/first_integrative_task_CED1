package model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class PatientInventory {

    private Hashtable patients;

    public PatientInventory() {
        this.patients = convertPatientsToObject();
    }

    private Hashtable convertPatientsToObject() {
        String [] patientsData = readFile().split("-");
        Hashtable patients = new Hashtable();

        for (String patient: patientsData) {
            String [] onePatient = patient.split(";");
            Patient patient1 = new Patient(onePatient[0], onePatient[1], Boolean.parseBoolean(onePatient[2]), onePatient[3]);
            patients.put(onePatient[0]+onePatient[1],patient1);
        }
        
        return patients;
    }

    private String readFile(){
        try {
            File file = new File("./src/main/resources/data.txt");
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[120];
            int bytes = 0;

            while((bytes = fis.read(buffer)) != -1){
                baos.write(buffer, 0, bytes);
            }
            fis.close();
            baos.close();

            String output = baos.toString();

            return output;
        } catch(IOException ex) {
            ex.printStackTrace();

            return "";
        }
    }

    public Patient findPatient(String name){
        return (Patient) patients.get(name);
    }

    public Hashtable getPatients(){
        return this.patients;
    }
}
