package Perfulandia.usuarios.repository;
import java.util.List;

import Perfulandia.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    List<Usuario> findByNombre(String nombre);

    List<Usuario> findByActivoFalse();

}
