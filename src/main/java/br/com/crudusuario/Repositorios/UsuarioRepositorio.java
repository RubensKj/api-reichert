package br.com.crudusuario.Repositorios;

import br.com.crudusuario.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    boolean existsById(Long id);
}
