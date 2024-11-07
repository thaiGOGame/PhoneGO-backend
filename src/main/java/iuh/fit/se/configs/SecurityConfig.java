package iuh.fit.se.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure to allow all requests without authentication
        http
            .authorizeRequests(authorize -> authorize
                .anyRequest().permitAll() // Allow all requests
            )
            .csrf(csrf -> csrf.disable()); // Optional: Disable CSRF protection

        return http.build();
    }
}
