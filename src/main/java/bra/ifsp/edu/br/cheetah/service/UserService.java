package bra.ifsp.edu.br.cheetah.service;

import bra.ifsp.edu.br.cheetah.model.User;
import bra.ifsp.edu.br.cheetah.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método para obter todos os usuários
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Método para salvar um novo usuário
    public User save(User user) {
        return userRepository.save(user);
    }

    // Método para buscar um usuário por ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // Método para deletar um usuário
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
