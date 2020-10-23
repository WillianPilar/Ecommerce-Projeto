package br.com.team.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.team.java.model.Imagem;

@Repository
interface ImagemRepository extends JpaRepository<Imagem, Integer> {

}
