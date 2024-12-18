package com.nikita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikita.entity.Family;
import com.nikita.service.NikitaService;

@RestController
@RequestMapping("api/v1/")
public class NikitaController {

	@Autowired
	NikitaService niki;
	
	
	@GetMapping("/details")
	public List<Family> showDetails(){
		return niki.showDetails();
	}
	@PostMapping("/add")
	public void add(@RequestBody Family family) {
		niki.addMember(family);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		niki.deleteMember(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateDetails(@PathVariable int id, @RequestBody Family fam) {
//		Family family = niki.findMember(id);
		niki.updateMember(id, fam);
	}
}
