package hr.algebra.travelplanner.authentication.config;

import hr.algebra.travelplanner.authentication.jwt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  public static final List<String> UNAUTHENTICATED_ENDPOINTS =
      List.of("/auth/register", "/auth/login");

  private final JwtFilter jwtFilter;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(
            auth -> {
              auth.requestMatchers("/auth/login").permitAll();
              auth.requestMatchers("/auth/register").permitAll();
              auth.anyRequest().authenticated();
            })
        .csrf(csrf -> csrf.disable())
        .formLogin(
            login -> login
                    .defaultSuccessUrl("/web", true)
                    .failureUrl("/login.html?error=true"))
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }

//  @Bean
//  public UserDetailsService users() {
//    UserDetails user =
//        User.builder()
//            .username("user")
//            .password("$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
//            .roles("USER")
//            .build();
//    UserDetails admin =
//        User.builder()
//            .username("admin")
//            .password("$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
//            .roles("USER", "ADMIN")
//            .build();
//    return new InMemoryUserDetailsManager(user, admin);
//  }
}
