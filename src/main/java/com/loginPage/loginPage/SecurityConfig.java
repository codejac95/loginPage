package com.loginPage.loginPage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth
//         .anyRequest().authenticated()
//         );
//         return http.build();
//     }
// }

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/order").authenticated()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/product/{productId}").permitAll()
                        .requestMatchers("/register").permitAll()

                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();

    }

    public static void run(Class<SpringsecurityAplication> class1, String[] args) {
    }

}
