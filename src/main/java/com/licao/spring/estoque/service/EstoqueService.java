package com.licao.spring.estoque.service;

import java.util.List;
import java.util.Optional;

import com.licao.spring.Entidades.models.Estoque;
import com.licao.spring.Entidades.models.Item;

public interface EstoqueService extends Service<Estoque>{
	
	public Estoque atualizarStatus(Estoque estoque)throws Exception;

	public Estoque atualizarQuantidade(Estoque estoque, int quantidade) throws Exception;
	
	public void atualizarQuantidade(List<Item> itens);
	
	public Optional<Estoque> buscarEstoquePorIdProduto(Integer idProduto);
	
	public void atualizarStatus(List<Item> itens);
}
