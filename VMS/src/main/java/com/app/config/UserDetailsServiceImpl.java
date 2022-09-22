//package com.app.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.app.dao.UserRepository;
//import com.app.entities.User;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserRepository urepo;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		User user=urepo.getUserByUseName(username);
//		if(user==null) {
//			throw new UsernameNotFoundException("could not found user");
//		}
//		
//		CustomUserDetails customedetails= new CustomUserDetails(user);
//		return customedetails;
//	}
//	
//
//}
