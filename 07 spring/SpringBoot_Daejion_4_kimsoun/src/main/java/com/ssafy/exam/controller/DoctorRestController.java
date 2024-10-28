package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {

	public final DoctorService doctorService;
	public DoctorRestController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@PostMapping
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
		System.out.println(doctor);
		try {
		boolean flag = doctorService.addDoctor(doctor);
		if(flag) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Doctor added successfully");
		}else {
//    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to add specialty");
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to add Doctor");
		}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to add Doctor");
			
		}
	}

    @GetMapping("/{no}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int no) {
    	System.out.println("id : " + no);
    	Doctor doctor = doctorService.getDoctorById(no);
    	if(doctor != null) {
    		return ResponseEntity.ok(doctor);
    	}
    		return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int no) {
    	System.out.println("no : " + no);
    	boolean flag = doctorService.deleteDoctor(no);
    	if(flag) {
    		return ResponseEntity.ok("Doctor deleted successfully");
    	}else {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to delete Doctor");
    	}
    }

    @GetMapping
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> list = doctorService.getAllDoctors();
		if(list.size() > 0) {
			return ResponseEntity.ok(list);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

    @PutMapping("/{no}")
	public ResponseEntity<String> updateDoctor(@PathVariable Doctor doctor , @PathVariable int no) {
		boolean flag = doctorService.updateDoctor(no, doctor);
		if (flag) {
			return ResponseEntity.ok("Doctor updated successfully");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to update Doctor");
		}
	}

}
