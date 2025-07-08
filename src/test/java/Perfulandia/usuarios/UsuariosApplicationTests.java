package Perfulandia.usuarios;

import Perfulandia.usuarios.model.Usuario;
import Perfulandia.usuarios.repository.UsuarioRepository;
import Perfulandia.usuarios.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuariosApplicationTests {

	@Autowired
	private UsuarioService usuarioService;

	@MockBean
	private UsuarioRepository usuarioRepository;

	@Test
	void testFindAll() {
		// Preparar datos simulados
		Usuario usuario = new Usuario(1L, "Pedro", "pedro@example.com", true);

		when(usuarioRepository.findAll()).thenReturn(List.of(usuario));

		List<Usuario> resultado = usuarioService.findAll();

		assertNotNull(resultado);
		assertEquals(1, resultado.size());
		assertEquals("Pedro", resultado.get(0).getNombre());
	}

	@Test
	void testBuscarPorNombre() {
		Usuario usuario = new Usuario(2L, "Lucía", "lucia@example.com", true);

		when(usuarioRepository.findByNombre("Lucía")).thenReturn(List.of(usuario));

		List<Usuario> resultado = usuarioService.buscarPorNombre("Lucía");

		assertEquals(1, resultado.size());
		assertEquals("Lucía", resultado.get(0).getNombre());
	}

	@Test
	void testUsuariosInactivos() {
		Usuario inactivo = new Usuario(3L, "Ana", "ana@example.com", false);

		when(usuarioRepository.findByActivoFalse()).thenReturn(List.of(inactivo));

		List<Usuario> resultado = usuarioService.getUsuariosInactivos();

		assertEquals(1, resultado.size());
		assertFalse(resultado.get(0).getActivo());
	}
}
