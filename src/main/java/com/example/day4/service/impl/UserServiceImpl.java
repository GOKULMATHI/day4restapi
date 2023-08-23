package com.example.day4.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day4.model.UserModel;
import com.example.day4.repository.UserRepository;
import com.example.day4.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
   private UserRepository rep;
	@Override
	public boolean addUser(UserModel user) {
		// TODO Auto-generated method stub
		boolean userExists=rep.existsByMailid(user.getMailid());
		if(!userExists) {
			rep.save(user);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public List<UserModel> getUser() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}
	@Override
	public boolean updateUser(Long id,UserModel user) {
//		userRepository.saveAndFlush(user);
		Optional<UserModel> existingUserOptional = rep.findById(id);
		if(existingUserOptional.isPresent()) {
			UserModel userExists = existingUserOptional.get();
			userExists.setStudentName(user.getStudentName());
			userExists.setDepartmentName(user.getDepartmentName());
			userExists.setMailid(user.getMailid());
			
			rep.save(userExists);
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean deleteUser(Long id) {
		System.out.println("Inside");
		Optional<UserModel> existingUserOptional = rep.findById(id);
		if(existingUserOptional.isPresent()) {
			rep.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	


}
