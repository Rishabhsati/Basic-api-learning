package com.rishabh.basicapilearning;

import java.util.HashMap;

public class PatientService {

    PatientRepository patientRepository = new PatientRepository();

    public String addPatientToDb(int patientId, String name, int age, String disease) {
        String response = patientRepository.addPatientToDb(patientId,name,age,disease);
        return response;
    }

    public Patient maxAge(){
        HashMap<Integer,Patient> patientDb = patientRepository.getPatientInfo();
        int patientId = -1;
        int max = 0;
        for(Patient patient1 : patientDb.values()){
            if(patient1.getAge()>max) {
                patientId = patient1.getPatientId();
                max = patient1.getAge();
            }
        }
        return patientDb.get(patientId);
    }

    public Patient getPatientInfo(int key) {
        HashMap<Integer,Patient> patientDb = patientRepository.getPatientInfo();
        Patient patient = patientDb.get(key);
        return patient;
    }

    public String updatePatientPut(int PatientId, String name, Integer age, String disease) {
        String response = patientRepository.updatePatientPut(PatientId, name, age, disease);
        return response;
    }

    public String updatePatientPatch(int PatientId, String name, Integer age, String disease){
        String response = patientRepository.updatePatientPatch(PatientId,name,age,disease);
        return response;
    }


    public String deletePatient(int patientId) {
        String response = patientRepository.deletePatient(patientId);
        return response;
    }
}
