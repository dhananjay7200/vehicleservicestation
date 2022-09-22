//package com.app.config;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.app.entities.User;
//
//public class CustomUserDetails implements UserDetails {
//	
//	private User user;
//	
//	
//
//	public CustomUserDetails(User user) {
//		super();
//		this.user = user;
//	}
//	
	

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		SimpleGrantedAuthority simplegrantedAuth =	new SimpleGrantedAuthority(user.getRole());
//		return List.of(simplegrantedAuth);
//	}
//
//	@Override
//	public String getPassword() {
//		
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		
//		return user.getEmail_id();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
