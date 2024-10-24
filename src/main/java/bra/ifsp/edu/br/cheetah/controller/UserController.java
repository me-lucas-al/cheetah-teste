package bra.ifsp.edu.br.cheetah.controller;

import bra.ifsp.edu.br.cheetah.model.User;
import bra.ifsp.edu.br.cheetah.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users") // Rota base
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint para obter todos os usuários
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // Endpoint para criar um novo usuário
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    // Endpoint para obter um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok) // Retorna 200 OK se o usuário existir
                   .orElse(ResponseEntity.notFound().build()); // Retorna 404 Not Found se não existir
    }

    // Endpoint para deletar um usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content após a exclusão
    }
}
