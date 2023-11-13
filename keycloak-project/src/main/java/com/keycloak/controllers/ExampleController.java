package com.keycloak.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/hello")
public class ExampleController {


	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
//	@PreAuthorize("hasAnyAuthority('DEMO_ROLE')")
	public ResponseEntity<?> getVRE() {


		 return ResponseEntity.ok("hola");
 
	}

//	@Autowired
//	com.datalake.services.Vre vre;
//	
//	@ResponseBody
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<?> getVRE() {
//		String hola ="2HOLA";
//		try {
//			// metodo;
//		} catch (Exception e) {
//				throw new NotFoundException();
//		}
//		// resultado
//		 return ResponseEntity.ok(vre.getVREName());
// 
//	}
}