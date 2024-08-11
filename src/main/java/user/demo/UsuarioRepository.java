package user.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @SuppressWarnings("unchecked")
    Usuario save(Usuario usuario);

    Optional<Usuario> findById(Long id);

    void deleteById(Long id);
}
