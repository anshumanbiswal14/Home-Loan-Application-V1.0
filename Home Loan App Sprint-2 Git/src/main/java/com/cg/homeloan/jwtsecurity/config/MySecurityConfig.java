package com.cg.homeloan.jwtsecurity.config;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.cg.homeloan.jwtsecurity.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

		private final Logger log = LoggerFactory.getLogger(MySecurityConfig.class);

		@Autowired
		private MyUserDetailsService myUserDetailsService;
		

		@Autowired
		private JwtAuthenticationFilter userRequestFilter;

		@Bean
	    public JwtAuthenticationFilter authenticationJwtTokenFilter() {
	        return new JwtAuthenticationFilter();
	    }
	 
	    @Override
	    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	        authenticationManagerBuilder
	                .userDetailsService(myUserDetailsService)
	                .passwordEncoder(passwordEncoder());
	    }
	 
	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	 
	    @SuppressWarnings("deprecation")
		@Bean
		public PasswordEncoder passwordEncoder() {
				return NoOpPasswordEncoder.getInstance();
		}

	    
	    @Override
		protected void configure(HttpSecurity httpSecurity) throws Exception { // 2
			httpSecurity.cors();
			log.info("configure");
			httpSecurity.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//		        .antMatchers("/").permitAll()
					.antMatchers("/homeloan/customer/login").permitAll().antMatchers("/homeloan/admin/login").permitAll()
					.antMatchers("/homeloan/financeOfficer/login").permitAll().antMatchers("/homeloan/landOfficer/login")
					.permitAll().antMatchers("/homeloan/customer/addCustomer").permitAll().antMatchers("/homeloan/customer/EMICalculator/**").permitAll().anyRequest().authenticated()
					.and().exceptionHandling().and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			// .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			httpSecurity.addFilterBefore(userRequestFilter, UsernamePasswordAuthenticationFilter.class);
		}
}
		
		
		
