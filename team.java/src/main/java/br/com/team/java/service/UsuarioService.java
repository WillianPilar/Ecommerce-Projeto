package br.com.team.java.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import br.com.team.java.model.Usuario;

import br.com.team.java.repository.UsuarioRepository;

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
	
	public Usuario consultarUsuarioId( int id ){
 		
 		return this.usuarioRepository.findById(id).get();
 	}
	
	public List<Usuario> consultarTodosUsuarios(){
		return this.usuarioRepository.findAll();
	}
	
	public void delete (int id) {
		this.usuarioRepository.deleteById(id);
	}
	
	public Usuario atualizarUsuario(int id,Usuario usuario) {
 		Optional<Usuario> obj = this.usuarioRepository.findById(id);
 		
 		Usuario update = null;
 		
 		if (obj.isPresent()) {
 			update = obj.get();
 			update.setEmail(usuario.getEmail());
 			update.setNome(usuario.getNome());
 			update.setSenha(usuario.getSenha());
 			update.setPerfis(usuario.getPerfis());
 			
 			update = this.usuarioRepository.save(update);
 		}
 		
 		return update;
 	} 
	
	

}
