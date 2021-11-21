/*package com.Donation.charity.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.Donation.charity.service.AdminService;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 
	@Autowired
	private UserDetailsService userdetailsservice;
	   @Bean
	   public UserDetailsService getUserDetailsService() {
		   return new AdminService();
	   }
	   
	   @Bean
	    AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider provider
	                 = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(userdetailsservice);
	   //     provider.setPasswordEncoder(new BCryptPasswordEncoder());
	        return  provider;
	    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
		
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				 "/registration**",
	                "/js/**",
	                "/css/**",
	                "/img/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout();
	}

	   @Bean
	    AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider provider
	                 = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(userDetailsService);
	   //     provider.setPasswordEncoder(new BCryptPasswordEncoder());
	        return  provider;
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	                .antMatchers("/")
	                .permitAll()
	                .anyRequest()
	                .authenticated()
	                .and()
	                .httpBasic();
	    }
	}
	/*@Autowired
	private UserDetailsService userdeatilservice;
	@Bean
	public UserDetailsService userdeatilservice() {
		return super.userDetailsService();
	}

	@Bean
	AuthenticationProvider authprovider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userdeatilservice);
		return provider;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/")
		.permitAll()
		.anyRequest();
		//.httpBasic();
	}
}
*/