package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;

import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;

public class JobTest {

    @Before
    public void createJobObjects() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
        assertFalse(emptyJob1.equals(emptyJob2));
        assertTrue((emptyJob2.getId() - 1) == emptyJob1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getName() == "Product tester");
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getEmployer().getValue() == "ACME");
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getLocation().getValue() == "Desert");
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getPositionType().getValue() == "Quality control");
        assertTrue(testJob.getCoreCompetancy() instanceof CoreCompetency);
        assertTrue(testJob.getCoreCompetancy().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(Job1.equals(Job2));
    }

    @Test
    public void testToStringNewLines() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        int lastIndex = (testJob.toString().length() - 1);
        assertTrue(testJob.toString().charAt(0) == '\n');
        assertTrue(testJob.toString().charAt(lastIndex) == '\n');
    }

    @Test
    public void testToStringPrintLabels() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] lines = testJob.toString().trim().split("\n");
        System.out.println(testJob.toString());

        assertTrue(lines.length == 6);

        assertTrue(lines[0].startsWith("ID:"));
        assertTrue(lines[1].startsWith("Name:"));
        assertTrue(lines[2].startsWith("Employer:"));
        assertTrue(lines[3].startsWith("Location:"));
        assertTrue(lines[4].startsWith("Position Type:"));
        assertTrue(lines[5].startsWith("Core Competency:"));

        assertTrue(lines[0].endsWith(Integer.toString(testJob.getId())));
        assertTrue(lines[1].endsWith(testJob.getName()));
        assertTrue(lines[2].endsWith(testJob.getEmployer().toString()));
        assertTrue(lines[3].endsWith(testJob.getLocation().toString()));
        assertTrue(lines[4].endsWith(testJob.getPositionType().toString()));
        assertTrue(lines[5].endsWith(testJob.getCoreCompetancy().toString()));
    }

    @Test
    public void testToStringDataUnavailable() {
        Job testJob = new Job();
        String[] lines = testJob.toString().trim().split("\n");
        System.out.println(testJob.toString());
        List<String> list = new ArrayList<String>(Arrays.asList(lines));
        list.remove(0);
        lines = list.toArray(new String[0]);
        String unavailable = "Data not available";
        for (String line : lines) {
            assertTrue(line.endsWith(unavailable));
        }
    }
}