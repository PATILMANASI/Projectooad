package com.Donation.charity.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.Donation.charity.service.DAService;

@Configuration
@EnableWebSecurity
@Order(3)
public class DASecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private DAService daservice;

    

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/","/donorsignin**","/admin**","/donornewlogin","/dasignin","/ngologin","/ngosignin","/donorsignin","/markNGOVerified/{id}","/markDAVerified/{id}",
                "/registration**","redirect:/verifyDA","redirect:/verifyNGO","/",
                "/js/**",
                "/css/**",
                "/images/**").permitAll()
//                "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/DAlogin")
            .defaultSuccessUrl("/donorhome",true)
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/?logout")
            .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoderDA() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProviderDA() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(daservice);
        auth.setPasswordEncoder(passwordEncoderDA());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProviderDA());
    }

}
