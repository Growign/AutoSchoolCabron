package co.suo.autoschool.config;

import co.suo.autoschool.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true
)
public class SecurityConfiguration {

	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	private final LogoutHandler logoutHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf()
				.disable()
				.cors().and()
				.authorizeHttpRequests()
				.antMatchers("/", "/index.html", "/static/**", "/*.ico", "/*.json", "/*.png","/*.jpg","/static/quizPhotos/**").permitAll()
				.antMatchers("/api/v1/register", "/api/v1/authenticate", "/api/v1/activate", "/api/v1/refreshToken",
							"/login", "/sign-up","/about","/courses","/mistake","/activate", "/quiz/**","/teachers")
					.permitAll()
				.antMatchers(HttpMethod.GET,"/TheoryTeacher","/practicalTeachers").permitAll()
				.antMatchers("/TheoryTeacher","/practicalTeachers","/car", "/category").permitAll()
				.antMatchers("/api/v1/user/**", "/profile").hasAnyAuthority(Role.USER.name(), Role.ADMIN.name())
            	.antMatchers(HttpMethod.GET, "/api/v1/check-auth").authenticated()
            	.antMatchers(HttpMethod.POST, "/api/v1/logout").authenticated()
				.antMatchers("/allUser/**","/TheoryTeacher","/practicalTeachers").hasAuthority(Role.ADMIN.name())
				.anyRequest()
					.authenticated()
					.and()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.logoutUrl("/api/v1/auth/logout")
					.addLogoutHandler(logoutHandler)
					.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());

		return http.build();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
