package br.com.team.java.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.team.java.dto.CategoriaDto;
import br.com.team.java.dto.EnderecoDto;
import br.com.team.java.dto.ImagemDto;
import br.com.team.java.dto.UsuarioDto;
import br.com.team.java.dto.UsuarioNewDto;
import br.com.team.java.model.Categoria;
import br.com.team.java.model.Endereco;
import br.com.team.java.model.Imagem;
import br.com.team.java.model.Usuario;

public class DtoUtil {
	@Autowired
	private static ModelMapper modelMapper;

//	public static Produto produtoFromDto(ProdutoDto prodDto) {
//
//		Produto obj = Produto
//				.builder()
//				
//				.nome(prodDto.getNome())
//				.preco(prodDto.getPreco())
//				.descricao(prodDto.getDescricao())
//				.categoria( categoriaFromDto( prodDto.getCategoria() ) )
//				.imagens(prodDto.getImagens().stream().map(dto -> imagemFromDto(dto) ).collect(Collectors.toList()))
//				
//				.build();
//		
//		return obj;
//
//	}
//	




//	public static ItemVenda itemVendaFromDto(ItemVendaDto objDto) {
//		
//		ItemVenda obj = ItemVenda
//			.builder()
//			.id(objDto.getId())
//			.produto(produtoFromDto ( objDto.getProduto() ))
//			.quantidade(objDto.getQuantidade())
//			.build();
//		
//		return obj;
//	}

	public static Usuario usuarioFromDto(UsuarioDto objDto) {

		Usuario obj = Usuario.builder().id(objDto.getId()).nome(objDto.getNome()).email(objDto.getEmail()).build();
		return obj;
	}

//	public static Venda vendaFromDto(VendaDto objDto) {
//		
//		Venda obj = Venda
//				.builder()
//				.id(objDto.getId())
//				.valor(objDto.getValor())
//				.usuario( usuarioFromDto ( objDto.getUsuario() ) )
//				.dataVenda(objDto.getDataVenda())
//				.statusVenda(objDto.getStatusVenda())
//				.totalItens(objDto.getTotalItens())
//				.item(objDto.getItem().stream().map(objDtoLambda -> itemVendaFromDto ( objDtoLambda ) ).collect(Collectors.toList()))
//				.pagamento(objDto.getPagamento())
//				.build();
//				
//		return obj;		
//	}

	public static Imagem ImagemProdFromDto(ImagemDto obj) {
		
		return new Imagem(
				obj.getId(), 
				obj.getUrl(), 				
				obj.getNome(), 
				obj.getProduto()
				);
	}

	public static Usuario usuarioNewFromDto(UsuarioNewDto objDto) {

		Usuario obj = Usuario.builder().id(objDto.getId()).email(objDto.getEmail()).senha(objDto.getSenha())
				.nome(objDto.getNome()).build();

		return obj;
	}

	public static Endereco enderecoUsuarioFromDto(EnderecoDto objDto) {

		Endereco obj = Endereco.builder().id(objDto.getId()).cep(objDto.getCep()).bairro(objDto.getBairro())
				.cidade(objDto.getCidade()).estado(objDto.getEstado()).logradouro(objDto.getLogradouro())
				.numero(objDto.getNumero()).build();

		return obj;

	}

	public static Categoria categoriaFromDto(CategoriaDto obj) {
		return new Categoria(obj.getId(), obj.getNome(), obj.getDescricao(), null);
	}
	
	public static Imagem imagemFromDto(ImagemDto obj) {
		return new Imagem(obj.getId() , obj.getUrl(), obj.getNome(), null);
	}

	public static <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {

		return entities.map(objectEntity -> modelMapper.map(objectEntity, dtoClass));
	}
	
	private DtoUtil() {}
}
