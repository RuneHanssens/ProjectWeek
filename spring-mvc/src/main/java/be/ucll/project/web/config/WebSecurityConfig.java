package be.ucll.project.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user")
                .password("1234").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("t").roles("ADMIN").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/","/index.htm").permitAll()
                .antMatchers("css").permitAll()
                .antMatchers("/activity.htm").hasAnyRole("USER","ADMIN")
                .antMatchers("/activity/**").hasRole("ADMIN")
                .and().formLogin().and().httpBasic().and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        //logout uileg stackoverflow (https://stackoverflow.com/questions/30487576/error-404-on-spring-logout?rq=1)
        //If you really want to use HTTP GET with logout you can do so, but remember this is generally not recommended. For example, the following Java Configuration will perform logout with the URL /logout is requested with any HTTP method:
    }
}
