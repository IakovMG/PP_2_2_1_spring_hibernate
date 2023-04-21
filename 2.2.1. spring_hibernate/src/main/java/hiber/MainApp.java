package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("James", "Bond", "bond@gmail.com",new Car("Aston Martin",007)));
      userService.add(new User("Henry", "Ford", "ford2@gmail.com",new Car("Ford", 1863)));
      userService.add(new User("Enzo", "Ferrari", "enzo@gmail.com", new Car("Ferrari", 1898)));
      userService.add(new User("Nicola", "Romero", "rom@gmail.com", new Car("Alfa Romeo", 1910)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      System.out.println("Used method: getUserByCar");
      System.out.println(userService.getUserByCar("Ford",1863));

      context.close();
   }
}
