package nl.rutger.snoek.backendcakenner.Configuration;

import io.jsonwebtoken.Jwt;
import nl.rutger.snoek.backendcakenner.Filter.JwtRequestFilter;
import nl.rutger.snoek.backendcakenner.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtService jwtService;

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return super.userDetailsService();
    }

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth

                .jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from account where username=?")
                .authoritiesByUsernameQuery("select user_id,role_id from user_role where user_id =?");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers( "/auth","/register", "/showAllRated","/recipe/{id}",
                        "/showbyIdRecipe/{id}", "/showAllRecipes", "/imageUpload",
                        "/CakennerImages/**", "/images/**" , "/IsAdmin/{username}").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/postRecipe","/addComment" ).hasAnyAuthority("USER", "ADMIN")
                .and()

                .authorizeRequests()
               .antMatchers("/saverated", "/getRoles", "/newrole").hasAuthority("ADMIN")


                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()

                .addFilterBefore(new JwtRequestFilter(jwtService, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
        ;


    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
