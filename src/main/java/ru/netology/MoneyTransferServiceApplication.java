package ru.netology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoneyTransferServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(MoneyTransferServiceApplication.class, args);
    }
}


// {"amount":{"currency":"RUB", "value":520}, "cardFromCVV": "123", "cardFromNumber":"1234123412341234", "cardFromValidTill":"12/23","cardToNumber":"5678567856785678"}
// http://localhost:8080/transfer

// http://localhost:8080/confirmOperation
// {"code":"200", "operationId": "1"}


/*

@Configuration
@EnableWebMvc
class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("https://serp-ya.github.io/card-transfer/")
                .allowedMethods("*");
    }
}
 */