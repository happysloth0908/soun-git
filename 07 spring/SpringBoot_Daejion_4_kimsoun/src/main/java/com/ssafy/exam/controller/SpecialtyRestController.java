package com.ssafy.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

@RestController
@RequestMapping("/api/specialty")
public class SpecialtyRestController {
	
	public final SpecialtyService specialtyService;
	public SpecialtyRestController(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}
	
	@PostMapping
	// 
    public ResponseEntity<String> addSpecialty(@RequestBody Specialty specialty) {
		System.out.println(specialty);
		boolean flag = specialtyService.addSpecialty(specialty);
		if(flag) {
			return ResponseEntity.status(HttpStatus.CREATED).body("specialty added successfully");
		}else {
//    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to add specialty");
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to add specialty");
		}
	}

    @GetMapping("/{no}")
    public ResponseEntity<Specialty> getSpecialty(@PathVariable int no) {
    	System.out.println("no : " + no);
    	Specialty specialty = specialtyService.getSpecialtyByCode(no);
    	if(specialty != null) {
    		return ResponseEntity.ok(specialty);
    	}
    		return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable int no) {
    	System.out.println("no : " + no);
    	boolean flag = specialtyService.deleteSpecialty(no);
    	if(flag) {
    		return ResponseEntity.ok("specialty deleted successfully");
    	}else {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to delete specialty");
    	}
    }
}