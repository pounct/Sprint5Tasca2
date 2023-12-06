package cat.itacademy.Player.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        return security
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(
                        ahr->ahr.requestMatchers(
                        "/","/webjar/**","/h2-console/**"
                        ).permitAll()
                )
                .authorizeHttpRequests(
                        ahr->ahr.anyRequest()
                                .authenticated()
                )
                .oauth2Login(Customizer.withDefaults())

                .logout(l->l.logoutSuccessUrl("/")
                        .permitAll()
                        .deleteCookies("JSESSIONID"))

                .build() ;
    }
}
