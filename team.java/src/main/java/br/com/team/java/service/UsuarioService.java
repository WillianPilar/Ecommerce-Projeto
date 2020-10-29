package br.com.team.java.service;

import java.util.List;
import java.util.function.Function;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.team.java.dto.UsuarioDto;
import br.com.team.java.model.Usuario;

import br.com.team.java.repository.UsuarioRepository;
import br.com.team.java.util.DtoUtil;

@Service
public class UsuarioService {

	@Autowired
	public UsuarioRepository usuarioRepository;

	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;

	public Usuario salvarUsuario(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		return this.usuarioRepository.save(usuario);
	}

	public Usuario consultarUsuarioId(int id) {

		return this.usuarioRepository.findById(id).orElse(null);
	}

	public List<Usuario> consultarTodosUsuarios() {
		return this.usuarioRepository.findAll();
	}

	public void delete(int id) {
		this.usuarioRepository.deleteById(id);
	}

	public Usuario atualizarUsuario(int id, Usuario usuario) {
		Optional<Usuario> obj = this.usuarioRepository.findById(id);

		Usuario update = null;

		if (obj.isPresent()) {
			update = obj.get();
			update.setEmail(usuario.getEmail());
			update.setNome(usuario.getNome());
			if (usuario.getSenha() != null) {
				update.setSenha(usuario.getSenha());
				update.setPerfis(usuario.getPerfis());
			}
			update = this.usuarioRepository.save(update);
		}

		return update;
	}

	public Page<UsuarioDto> paginacaoLike(int pagina, int linhas, String nome) {
		PageRequest pageRequest = PageRequest.of(pagina, linhas);
		Page<Usuario> entities = this.usuarioRepository.findByNomeContainsIgnoreCase(nome, pageRequest);
		Page<UsuarioDto> dtoPage = entities.map(new Function<Usuario, UsuarioDto>() {
			@Override
			public UsuarioDto apply(Usuario entity) {
				UsuarioDto dto = new UsuarioDto(entity);
				// Conversion logic
				return dto;
			}
		});

		return dtoPage;
	}

}
