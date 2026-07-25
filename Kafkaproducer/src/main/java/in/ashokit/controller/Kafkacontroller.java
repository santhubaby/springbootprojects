package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.model.Course;
import in.ashokit.service.Kafkaservice;

@RestController
@RequestMapping("/kafka")
public class Kafkacontroller {
	
		@Autowired
		private Kafkaservice service;
		
		@PostMapping("/add-course")
		public ResponseEntity<String> addCourse(@RequestBody Course course)
		{
			String response=service.sendMessage(course);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}

	}
	
	

