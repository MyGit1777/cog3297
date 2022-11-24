package com.dataloaderportal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
@EnableWebSecurity(debug=true)
public class DataLoaderSecurityConfig  extends WebSecurityConfigurerAdapter{

	/*
	 * @Autowired UserDetailsServiceImpl userDetailsService;
	 * 
	 * 
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.userDetailsService(userDetailsService); }
	 * 
	 * @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	 * 
	 * @Override public AuthenticationManager authenticationManagerBean() throws
	 * Exception { return super.authenticationManagerBean(); }
	 * 
	 * 
	 * // @Override // protected void configure(HttpSecurity http) throws Exception
	 * { // // http. // cors().and().csrf(). //
	 * disable().authorizeRequests().antMatchers("/authenticate") // .permitAll() //
	 * .anyRequest() // .authenticated(); // // }
	 * 
	 * 
	 * @Override protected void configure(HttpSecurity httpSecurity) throws
	 * Exception {
	 * 
	 * httpSecurity.csrf().disable()
	 * 
	 * .authorizeRequests().antMatchers("/login", "/register","/hello").permitAll().
	 * anyRequest().authenticated().and(); // make sure we use stateless session;
	 * session won't be used to // store user's state. //
	 * exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and
	 * ().sessionManagement() //
	 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 * 
	 * // Add a filter to validate the tokens with every request //
	 * httpSecurity.addFilterBefore(jwtRequestFilter,
	 * UsernamePasswordAuthenticationFilter.class); }
	 */
	
	@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private JWTRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers("/dataloader/authenticate").permitAll().
						anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
}
