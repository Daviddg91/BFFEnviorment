package com.bussinessproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/bussines-project")
public class ExampleController {


	
	@ResponseBody
	@GetMapping("/hello")
//	@PreAuthorize("hasAnyAuthority('DEMO_ROLE')")
	public ResponseEntity<?> getVRE() {


		 return ResponseEntity.ok("hola");
 
	}


}