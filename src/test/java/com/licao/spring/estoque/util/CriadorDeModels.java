package com.licao.spring.estoque.util;

import java.math.BigDecimal;

import com.licao.spring.Entidades.models.Estoque;
import com.licao.spring.Entidades.models.Produto;

public class CriadorDeModels {

	public static Produto getProduto() {
		Produto produto = new Produto();
		produto.setId(1);
		produto.setName("Smart phone galaxy J7 pro");
		produto.setDescricao("64 gb 3gb RAM processador samsung exinos 8 núcleos");
		produto.setValor(new BigDecimal("1200.00"));
		produto.setDisponivel(true);
		
		return produto;
	}
	
	public static Estoque getEstoque() {
		
		Estoque estoque = new Estoque();
		estoque.setId(1);
		estoque.setQuantidade(10);
		estoque.setQuantidadeStatusAlto(15);
		estoque.setQuantidadeStatusBaixo(5);
		estoque.setProduto(getProduto());
		
		return estoque;
	}
	
}
