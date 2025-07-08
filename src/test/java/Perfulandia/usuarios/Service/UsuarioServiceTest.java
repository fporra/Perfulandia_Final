package Perfulandia.usuarios.Service;

import Perfulandia.usuarios.model.Usuario;
import Perfulandia.usuarios.repository.UsuarioRepository;
import Perfulandia.usuarios.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest{

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void testFindAll() {
        Usuario usuario = new Usuario(1L, "Pedro", "pedro@example.com", true);

        when(usuarioRepository.findAll()).thenReturn(List.of(usuario));

        List<Usuario> resultado = usuarioService.findAll();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Pedro", resultado.get(0).getNombre());
    }

    // Puedes dejar aquí tus otros dos tests igual
}
