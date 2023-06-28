package com.cursojava.projetospring.services;

import com.cursojava.projetospring.entities.User;
import com.cursojava.projetospring.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = repository.findById(id);
    return obj.get();
  }

  public User insert(User obj) {
    return repository.save(obj);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  public User update(Long id, User obj) {
    // não consulta o banco, apenas prepara um obj monitorado para que após as alterações o banco de
    // dados seja acessado
    User entity = repository.getReferenceById(id);
    updateData(entity, obj);
    return repository.save(entity);
  }

  private void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }
}
