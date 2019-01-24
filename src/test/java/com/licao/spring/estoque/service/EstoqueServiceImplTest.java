package com.licao.spring.estoque.service;

import static org.mockito.Mockito.when;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.licao.spring.Entidades.enuns.StatusEstoque;
import com.licao.spring.Entidades.models.Estoque;
import com.licao.spring.estoque.repository.EstoqueRepository;
import com.licao.spring.estoque.service.impl.EstoqueServiceImpl;
import com.licao.spring.estoque.util.CriadorDeModels;

@RunWith(SpringJUnit4ClassRunner.class)
public class EstoqueServiceImplTest {

	private Estoque estoque;

	@InjectMocks
	private EstoqueServiceImpl estoqueService;

	@Mock
	private EstoqueRepository estoqueRepository;

	@Before
	public void before() {

		estoque = CriadorDeModels.getEstoque();

		when(estoqueRepository.existsById(anyInt())).thenReturn(true);

		when(estoqueRepository.save(estoque)).thenReturn(estoque);
	}

	@Test
	public void atualizarStatus() {
		atualizarStatusEsperandoStatusOK();
		atualizarStatusEsperandoStatusAlto();
		atualizarStatusEsperandoStatusBaixo();
	}
	
	public void atualizarStatusEsperandoStatusOK() {
		Estoque estoqueAtualizado = estoqueService.atualizarStatus(estoque);
		assertEquals(StatusEstoque.OK, estoqueAtualizado.getStatus());
	}

	public void atualizarStatusEsperandoStatusAlto() {
		estoque.setQuantidade(15);
		Estoque estoqueAtualizado = estoqueService.atualizarStatus(estoque);
		assertEquals(StatusEstoque.ALTO, estoqueAtualizado.getStatus());
	}

	public void atualizarStatusEsperandoStatusBaixo() {
		estoque.setQuantidade(5);
		Estoque estoqueAtualizado = estoqueService.atualizarStatus(estoque);
		assertEquals(StatusEstoque.BAIXO, estoqueAtualizado.getStatus());
	}
		
	@Test
	public void atualizarQuantidade() {
		estoque.setQuantidade(10);
		Estoque estoqueAtualizado = estoqueService.atualizarQuantidade(estoque, 5);
		assertNotNull(estoqueAtualizado);
		assertEquals(5, estoqueAtualizado.getQuantidade());
	}
	
	@Test
	public void atualizarQuantidadeEsperandoRetornarNull() {
		when(estoqueRepository.existsById(anyInt())).thenReturn(false);
		Estoque estoqueAtualizado = estoqueService.atualizarQuantidade(estoque, 5);
		assertNull(estoqueAtualizado);
	}
}
