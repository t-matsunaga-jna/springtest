package com.example.demo.service;
//各機能テスト後に有効化

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	/*
	// パスワードの暗号化
	@Bean
	PasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
	}
	
	@Bean
	InMemoryUserDetailsManager userDetailsService() {
	  // 管理者設定
	  UserDetails admin = User
	      .withUsername("admin")
	      .password(passwordEncoder().encode("admin"))
	      .roles("ADMIN")
	      .build();
	
	  // ユーザー設定
	  UserDetails user = User
	      .withUsername("user")
	      .password(passwordEncoder().encode("user"))
	      .roles("USER")
	      .build();
	  return new InMemoryUserDetailsManager(admin, user);
	}
	*/
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
            		/*
            		.requestMatchers("/edittype")
            		.hasAnyRole("admin")
            		.requestMatchers("/")
            		.hasAnyRole("user","admin")
            		*/
            		.requestMatchers("/login", "/public/**","/logout","/h2-console/**").permitAll()
            		.anyRequest().authenticated()
            )
            // CSRF保護をH2コンソール用に無効化
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
            )
            // iframeで表示するための設定を許可
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.sameOrigin()))
            /*
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error") 
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
            
            )*/
            ;
        
        
        
        return http.build();
    }
}

