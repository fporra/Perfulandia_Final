package Perfulandia.usuarios.service;

import java.util.List;

import Perfulandia.usuarios.model.Usuario;
import Perfulandia.usuarios.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

public UsuarioService(UsuarioRepository usuarioRepository) {
   this.usuarioRepository = usuarioRepository;
}

public List<Usuario> findAll() {
   return usuarioRepository.findAll();
}

public Usuario findById(long id) {
   return usuarioRepository.findById(id).orElse(null);
}

public Usuario save(Usuario usuario) {
   return usuarioRepository.save(usuario);
}

public void delete(Long id) {
  usuarioRepository.deleteById(id);
}

public List<Usuario> buscarPorNombre(String nombre) {
  return usuarioRepository.findByNombre(nombre);
}

public List<Usuario> getUsuariosInactivos() {
  return usuarioRepository.findByActivoFalse();
}
}

