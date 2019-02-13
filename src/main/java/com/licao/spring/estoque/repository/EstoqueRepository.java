package com.licao.spring.estoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.licao.spring.Entidades.models.Estoque;
public interface EstoqueRepository extends CrudRepository<Estoque, Integer> {

	@Query("SELECT e FROM Estoque e WHERE e.produto.id = :idProduto")
	public Optional<Estoque> buscarPorIdProduto(@Param("idProduto") Integer idProduto);
}