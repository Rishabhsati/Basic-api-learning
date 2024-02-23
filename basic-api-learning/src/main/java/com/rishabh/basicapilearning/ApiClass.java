package com.rishabh.basicapilearning;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ApiClass {
    HashMap<Integer,Patient> patientDb = new HashMap<>();

    @GetMapping("test")
    public String test(){
        return "hello rishabh";
    }

    @PostMapping("/addPatient")
    public String addPatientToDb(@RequestParam("patientId")int patientId,
                                 @RequestParam("name")String name,
                                 @RequestParam("age")int age,
                                 @RequestParam("disease")String disease){
        Patient patient = new Patient(patientId,name,age,disease);
        int key = patientId;
        patientDb.put(key,patient);
        return "patient details has been added to Patient database";
    }

    @GetMapping("/maxPatientAge")
    public Patient maxAge(){
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

    @GetMapping("/getPatientInfo")
    public Patient getPatientInfo(@RequestParam("patientId")int patientId){
        int key = patientId;
        Patient patient = patientDb.get(key);
        System.out.println(patient);
        return patient;
    }

    @PutMapping("/UpdatePatientPut")
    public String updatePatientPut(@RequestParam(value = "patientId")int patientId,
                                   @RequestParam(value = "name")String name,
                                   @RequestParam(value = "age")Integer age,
                                   @RequestParam(value = "disease")String disease){
        Patient patient = patientDb.get(patientId);
        patient.setName(name);
        patient.setAge(age);
        patient.setDisease(disease);
        return "patient data has been updated successfully";
    }

    @PatchMapping("/updatePatientPatch")
    public String updatePatient(@RequestParam(value = "patientId")int patientId,
                                @RequestParam(value = "name" ,required = false)String name,
                                @RequestParam(value = "age",required = false)Integer age,
                                @RequestParam(value = "disease" , required = false)String disease){
        Patient patient = patientDb.get(patientId);
        if(name!=null) patient.setName(name);
        if(age!=null) patient.setAge((Integer)age);
        if(disease!=null) patient.setDisease(disease);
        return "patient data has been updated successfully";
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam(value = "patientId",required = false)int patientId){
        if(patientDb.containsKey(patientId)){
            patientDb.remove(patientId);
            return "patient details has been deleted successfully from the database";
        }
        else{
            return "patient data does not exist in the database";
        }
    }
}