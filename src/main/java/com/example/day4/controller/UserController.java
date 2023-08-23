package com.example.day4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4.model.UserModel;
import com.example.day4.repository.UserRepository;
import com.example.day4.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService ser;
	@Autowired 
	UserRepository usrRepo;
	@GetMapping("/getUser")
	public ResponseEntity<List<UserModel>> getUser(){
		return ResponseEntity.status(200).body(ser.getUser());
	}
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserModel user){
		boolean dataSaved = ser.addUser(user);
		if(dataSaved) {
			return ResponseEntity.status(200).body("User added successfully!");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong!");
			
		}
	}
//	multiple datas
//	@PostMapping("/multiple")
//	public ResponseEntity<String> saveMultiple(@RequestBody List<UserModel> u){
//		
//		usrRepo.saveAllAndFlush(u);
//		return ResponseEntity.ok(" saved multiple data ");
//	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserModel user){
		boolean userData = ser.updateUser(id,user);
		if(userData) {
			return ResponseEntity.status(200).body("User updated successfully");
		} else{
			return ResponseEntity.status(404).body("No record found to be updated");
		}
	}
	
//
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam Long id){
		boolean userDeleted = ser.deleteUser(id);
		if(userDeleted) {
			return ResponseEntity.status(200).body("User deleted successfully");
		} else {
			return ResponseEntity.status(404).body("No record found to be updated");
		}
	}
}
