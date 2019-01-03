package com.licao.spring.estoque.service;

import com.licao.spring.Entidades.models.Estoque;

public interface EstoqueService extends Service<Estoque>{
	
	public void atualizarStatus(Estoque estoque)throws Exception;
}
