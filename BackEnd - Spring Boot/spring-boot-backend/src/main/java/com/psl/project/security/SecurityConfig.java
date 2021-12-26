package com.psl.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//	@Autowired
	//	private UserDetailsService userDetailsService;

	//	@Bean
	//	public BCryptPasswordEncoder encodePWD() {
	//		return new BCryptPasswordEncoder();
	//	}
	//
	//	@Bean
	//	public UserDetailsService userDetailsService() {
	//		return new CustomUserDetailsService();
	//	}
	//
	//	@Bean
	//	public DaoAuthenticationProvider authenticationProvider() {
	//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	//		authProvider.setUserDetailsService(userDetailsService());
	//		authProvider.setPasswordEncoder(encoder());
	//
	//		return authProvider;
	//	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
		//auth.authenticationProvider(authenticationProvider());
		auth.inMemoryAuthentication().withUser("user1").password("user").roles("USER")
		.and().withUser("user2").password("user").roles("USER")
		.and().withUser("admin").password("admin").roles("ADMIN", "USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/api/v1/employees/**").permitAll()
		.and().formLogin().permitAll();
	}

	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}


}
