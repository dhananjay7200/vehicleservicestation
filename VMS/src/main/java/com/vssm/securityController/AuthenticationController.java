package com.vssm.securityController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vssm.securityConfigration.ServiceCenterDetailsService;
import com.vssm.securityModel.AuthenticationResponse;


@CrossOrigin
@RestController
public class AuthenticationController {

	@Autowired
	private  AuthenticationManager authenticationManager;

	@Autowired
	private com.vssm.securityConfigration.CustomUserDetailsService userDetailsService;
	@Autowired
	private  com.vssm.securityConfigration.ServiceCenterDetailsService serviceCenterService;
	@Autowired
	private  com.vssm.securityConfigration.AdminDetailsService adminCenterService;
	
	//@Autowired
/* public AuthenticationController(ServiceCenterDetailsService serviceCenterService)
 {
		this.serviceCenterService=serviceCenterService;
	 
 }*/

	@Autowired
	private com.vssm.securityConfigration.JwtUtil jwtUtil;

	//auth user by request
	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody com.vssm.securityModel.AuthenticationRequest authenticationRequest)
			throws Exception {
		String token=null;;
		
		try {
			
			System.out.println("request comes here"+" object is "+authenticationRequest.getUsername()+" password"+ authenticationRequest.getPassword());
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		token = jwtUtil.generateToken(userdetails);
		
		
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
	
	//Auth service centre by commming rrequest
	@RequestMapping(value = "/authenticatecenter", method = RequestMethod.POST)
	public ResponseEntity<?> createCenterAuthenticationToken(@RequestBody com.vssm.securityModel.AuthenticationRequest authenticationRequest)
			throws Exception {
		String token=null;;
		
	
		{
			 System.out.println("control coming in center part in controller");
		try {
			
			System.out.println("request comes here"+" object is "+authenticationRequest.getUsername()+" password"+ authenticationRequest.getPassword());
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userdetails = serviceCenterService.loadUserByUsername(authenticationRequest.getUsername());
		token = jwtUtil.generateToken(userdetails);
		}
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
	
	///auth admin by extract deatiils
	@RequestMapping(value = "/authenticateadmin", method = RequestMethod.POST)
	public ResponseEntity<?> createAdminrAuthenticationToken(@RequestBody com.vssm.securityModel.AuthenticationRequest authenticationRequest)
			throws Exception {
		String token=null;;
		
	
		{
			 System.out.println("control coming in center part in controller");
		try {
			
			System.out.println("request comes here"+" object is "+authenticationRequest.getUsername()+" password"+ authenticationRequest.getPassword());
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userdetails = adminCenterService.loadUserByUsername(authenticationRequest.getUsername());
		token = jwtUtil.generateToken(userdetails);
		}
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
	
}
	
	/*@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody com.bssb.securityModel.UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}  */

