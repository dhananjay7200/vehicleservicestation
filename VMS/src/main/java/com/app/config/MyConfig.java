//package com.app.config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean ;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity ;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//@Configuration
//@EnableWebSecurity
//public class MyConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private PasswordEncoder encoder;
//   @Bean
//    public UserDetailsService getUserDetailService() {
//	   
//   
//        return new UserDetailsServiceImpl() ;
//   }
//   
//   @Bean
//   public DaoAuthenticationProvider authpro() {
//	   
//	   DaoAuthenticationProvider daoauthetictionpro=new DaoAuthenticationProvider();
//	   daoauthetictionpro.setUserDetailsService(this.getUserDetailService());
//	   daoauthetictionpro.setPasswordEncoder(encoder);
//	   return daoauthetictionpro;
//	   
//   }
//
//@Override
//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	// TODO Auto-generated method stub
//	auth.inMemoryAuthentication()
//	.withUser("Kiran").password(encoder.encode("abc1234")).roles("USER");
//	auth.authenticationProvider(authpro());
//	super.configure(auth);
//}
//
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//	http.authorizeRequests()
//	.antMatchers("/user").hasAnyRole("USER","ADMIN")		
//	.antMatchers("/admin").hasRole("ADMIN")
//	.antMatchers("/home").permitAll()
//	.and()
//	.httpBasic();
//}
//
//
//   
//   
//}