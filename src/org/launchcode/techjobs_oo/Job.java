package org.launchcode.techjobs_oo;

import java.lang.reflect.Field;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    //TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    @Override
    public String toString() {
        String[] labels = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
        Field[] fields = Job.class.getDeclaredFields();
        String unavailable = "Data not available";
        String message = "\n";
        int index = 0;

        for (Field f : fields) {
            if (f.getName() == "nextId") {
                // don't do anything
            } else {
                try {
                    // if this is a job field complete this task
                    if (f.get(this) instanceof JobField) {
                        // if this job field is not completed then do this
                        if (((JobField) f.get(this)).getValue() == "") {

                            message = message + labels[index] + unavailable + "\n";
                        } else {
                            message = message + labels[index] + f.get(this) + "\n";
                        }
                    } else if (f.get(this) == null || f.get(this) == "") {
                        message = message + labels[index] + unavailable + "\n";
                    } else {
                        message = message + labels[index] + f.get(this) + "\n";
                    }
                    index++;
                } catch (Exception e) {
                    message = message + labels[index] + unavailable + "\n";
                    index++;
                }
            }
        }

        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer value) {
        this.employer = value;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location value) {
        this.location = value;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType value) {
        this.positionType = value;
    }

    public CoreCompetency getCoreCompetancy() {
        return coreCompetency;
    }

    public void setCoreCompetancy(CoreCompetency value) {
        this.coreCompetency = value;
    }

}