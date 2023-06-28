package com.cursojava.projetospring.config;

import com.cursojava.projetospring.entities.Category;
import com.cursojava.projetospring.entities.Order;
import com.cursojava.projetospring.entities.Product;
import com.cursojava.projetospring.entities.User;
import com.cursojava.projetospring.entities.enums.OrderStatus;
import com.cursojava.projetospring.repositories.CategoryRepository;
import com.cursojava.projetospring.repositories.OrderRepository;
import com.cursojava.projetospring.repositories.ProductRepository;
import com.cursojava.projetospring.repositories.UserRepository;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 * Classe de configuração feita para instânciar objetos na base de dados assim que a aplicação é iniciada,
 * já que o H2 é um banco em memória
 * */

@Configuration
@Profile("test") // nome no arquivo application.properties
public class TestConfig implements CommandLineRunner {

  // injeção automática de dependência que irá instância um objeto da classe
  @Autowired private UserRepository userRepository;

  @Autowired private OrderRepository orderRepository;

  @Autowired private CategoryRepository categoryRepository;

  @Autowired private ProductRepository productRepository;

  @Override
  public void run(String... args) throws Exception {
    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");

    Product p1 =
        new Product(
            null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    Product p2 =
        new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
    Product p3 =
        new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
    Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
    Product p5 =
        new Product(
            null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    p1.getCategories().add(cat2);
    p2.getCategories().add(cat1);
    p2.getCategories().add(cat3);
    p3.getCategories().add(cat3);
    p4.getCategories().add(cat3);
    p5.getCategories().add(cat2);

    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

    userRepository.saveAll(Arrays.asList(u1, u2));

    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
    Order o2 =
        new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
    Order o3 =
        new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
  }
}
