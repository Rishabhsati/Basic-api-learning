package com.rishabh.basicapilearning;

import java.util.HashMap;

public class PatientRepository {
    HashMap<Integer,Patient> patientDb = new HashMap<>();

    public String addPatientToDb(int patientId, String name, int age, String disease) {
        Patient patient = new Patient(patientId,name,age,disease);
        patientDb.put(patientId,patient);
        return "patient details has been added to Patient database";
    }

    public HashMap<Integer, Patient> getPatientInfo() {
        return patientDb;
    }

    public String updatePatientPut(int PatientId, String name, Integer age, String disease) {
        Patient patient = patientDb.get(PatientId);
        patient.setName(name);
        patient.setAge(age);
        patient.setDisease(disease);
        return "patient data has been updated successfully";
    }

    public String updatePatientPatch(int PatientId, String name, Integer age, String disease) {
        Patient patient = patientDb.get(PatientId);
        if(name!=null) patient.setName(name);
        if(age!=null) patient.setAge((Integer)age);
        if(disease!=null) patient.setDisease(disease);
        return "patient data has been updated successfully";
    }

    public String deletePatient(int patientId) {
        if(patientDb.containsKey(patientId)){
            patientDb.remove(patientId);
            return "patient details has been deleted successfully from the database";
        }
        else{
            return "patient data does not exist in the database";
        }
    }
}
