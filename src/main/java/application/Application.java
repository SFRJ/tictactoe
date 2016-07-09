package application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(scanBasePackages = "application")
@EnableRedisHttpSession
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        //To run use:
        //./gradlew build && java -jar build/libs/shopfinder-1.0.0-SNAPSHOT.jar
    }
}

//Please find the pdf under test/resources