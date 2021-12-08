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


import com.Donation.charity.service.NGOService;

@Configuration
@EnableWebSecurity
@Order(3)
public class NGOSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private NGOService ngoservice;

    

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/","/donorsignin**","/admin**","/donornewlogin","/ngosignin","/DAlogin","/dasignin","/donorsignin","/markDAVerified/{id}","/markNGOVerified/{id}",
                "/registration**","redirect:/verifyNGO","redirect:/verifyDA","/","/viewDonation","/AdminHome","/verifyNGO","/DAhome","/viewOrders",
                "/js/**","/DisplayNoOrders","/verifyDA","/DisplayNoDAs","/About","/NoNGOAvailable","/feedbackform","/viewFeedback","/markNGORejected/{id}","/markDARejected/{id}",
                "/css/**",
                "/images/**").permitAll()
//                "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/ngologin")
            .defaultSuccessUrl("/NGOHome",true)
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
    public BCryptPasswordEncoder passwordEncoderNGO() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProviderNgo() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(ngoservice);
        auth.setPasswordEncoder(passwordEncoderNGO());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProviderNgo());
    }
}
