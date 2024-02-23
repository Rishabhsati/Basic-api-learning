package com.rishabh.basicapilearning;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @GetMapping("test")
    public String test(){
        return "hello rishabh";
    }
    PatientService patientService = new PatientService();

    @PostMapping("/addPatient")
    public ResponseEntity addPatientToDb(@RequestParam("patientId")int patientId,
                                 @RequestParam("name")String name,
                                 @RequestParam("age")int age,
                                 @RequestParam("disease")String disease){
        String ans = patientService.addPatientToDb(patientId,name,age,disease);

        return new ResponseEntity(ans, HttpStatus.OK);
    }

    @GetMapping("/maxPatientAge")
    public Patient maxAge(){
        Patient patient = patientService.maxAge();
        return patient;
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatientInfo(@RequestParam("patientId")int patientId){
        int key = patientId;
        Patient patient = patientService.getPatientInfo(key);
        return patient;
    }

    @PutMapping("/updatePatientPut")
    public String updatePatientPut(@RequestParam(value = "patientId")int patientId,
                                   @RequestParam(value = "name")String name,
                                   @RequestParam(value = "age")Integer age,
                                   @RequestParam(value = "disease")String disease){
        String response = patientService.updatePatientPut(patientId,name,age,disease);
        return response;
    }

    @PatchMapping("/updatePatientPatch")
    public String updatePatientPatch(@RequestParam(value = "patientId")int patientId,
                                @RequestParam(value = "name" ,required = false)String name,
                                @RequestParam(value = "age",required = false)Integer age,
                                @RequestParam(value = "disease" , required = false)String disease){
        String response = patientService.updatePatientPatch(patientId,name,age,disease);
        return response;
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam(value = "patientId",required = false)int patientId){
        String response = patientService.deletePatient(patientId);
        return response;
    }
}
