package qishi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qishi.factory.RepositoryFactoryBean;

//@SpringBootApplication
//@RestController
//public class Application {
//    @RequestMapping("/")
//    String home() {
//        return "hello111";
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//}
@EnableJpaRepositories(repositoryFactoryBeanClass = RepositoryFactoryBean.class)
@SpringBootApplication
public  class Application{

   public static void main(String[] args){

       SpringApplication.run(Application.class,args);

   }


}