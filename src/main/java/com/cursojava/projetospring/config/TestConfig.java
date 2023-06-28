package com.cursojava.projetospring.config;

import com.cursojava.projetospring.entities.Order;
import com.cursojava.projetospring.entities.User;
import com.cursojava.projetospring.repositories.OrderRepository;
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

  @Autowired // injeção automática de dependência que irá instância um objeto da classe
  private UserRepository userRepository;

  @Autowired private OrderRepository orderRepository;

  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

    userRepository.saveAll(Arrays.asList(u1, u2));

    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
    Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
    Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
  }
}
