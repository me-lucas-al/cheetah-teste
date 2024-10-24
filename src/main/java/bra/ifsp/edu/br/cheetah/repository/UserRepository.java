package bra.ifsp.edu.br.cheetah.repository;

import bra.ifsp.edu.br.cheetah.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
