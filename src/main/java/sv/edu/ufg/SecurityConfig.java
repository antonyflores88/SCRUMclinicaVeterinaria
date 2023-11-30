
package sv.edu.ufg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/diagnostico/**").hasRole("VETERINARIO")
				.requestMatchers("/views/citas/**").hasRole("SECRETARIA")
				.requestMatchers("/", "/home", "/index").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails secretaria =
			 User.withDefaultPasswordEncoder()
				.username("secretaria")
		        .password("contra")
				.roles("SECRETARIA")
				.build();
		
		UserDetails veterinario =
				 User.withDefaultPasswordEncoder()
					.username("veterinario")
			        .password("contra")
					.roles("VETERINARIO")
					.build();

		return new InMemoryUserDetailsManager(secretaria,veterinario);
	}
}