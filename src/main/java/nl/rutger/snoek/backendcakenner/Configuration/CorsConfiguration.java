package nl.rutger.snoek.backendcakenner.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String DELETE = "DELETE";
    private static final String PUT = "PUT";
    private static final String OPTIONS = "OPTIONS";

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        //.allowedOrigins("*")
                        .allowedMethods(GET,POST,PUT,DELETE,OPTIONS, "HEAD", "PATCH", "CONNECT")
                        //.allowedHeaders("*")
                        .allowedOriginPatterns("*")
                        //.allowCredentials(true)
                        ;
            }
        };
    }
}
