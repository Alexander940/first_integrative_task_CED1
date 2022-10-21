package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PatientInventoryTest {

    PatientInventory inventory;

    @Before
    public void setUp() throws Exception {
        inventory = new PatientInventory();
    }

    @Test
    public void read_data() {
        assertEquals(45, inventory.getPatients().size());
    }

    @Test
    public void get_a_patient() {
        Patient patient = inventory.findPatient("IrisWarner");

        assertEquals(false, patient.isPriority());
    }
}