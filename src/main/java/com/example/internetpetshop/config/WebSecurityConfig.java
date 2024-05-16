package com.example.internetpetshop.config;

import com.example.internetpetshop.Models.Permission;
import com.example.internetpetshop.Models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/login","/home").permitAll()
                .antMatchers(HttpMethod.GET,"/cart","/about","/cart/**","/contact-us","/user","/user/edit").hasAuthority(Permission.USERS_READ.getPermission())
                .antMatchers(HttpMethod.POST,"/user").hasAuthority(Permission.USERS_READ.getPermission())
                .antMatchers(HttpMethod.GET, "/admin","/product/new","/product/delete/{id}","/product/edit/{id}").hasAuthority(Permission.USERS_WRITE.getPermission())
                .antMatchers(HttpMethod.POST,"/product/new","/product/edit/{id}").hasAuthority(Permission.USERS_WRITE.getPermission())
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");
        return http.build();
    }


}
