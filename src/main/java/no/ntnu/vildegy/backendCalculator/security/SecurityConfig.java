package no.ntnu.vildegy.backendCalculator.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .cors().and().authorizeRequests().antMatchers("/loginSuccess", "/loginFailed", "/register", "/calculator", "/feedback").permitAll().and().authorizeRequests().antMatchers(HttpMethod.GET,"/calculate").permitAll().and().
                authorizeRequests().antMatchers(HttpMethod.POST,"/calculate").permitAll().and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
        http.headers().frameOptions().disable(); //so the H2 databse shows up
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {

        /**
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}password")
                .roles("USER");
         */

        auth.authenticationProvider(authProvider);
    }
}
