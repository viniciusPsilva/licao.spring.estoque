package com.licao.spring.estoque.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licao.spring.Entidades.enuns.StatusEstoque;
import com.licao.spring.Entidades.models.Estoque;
import com.licao.spring.estoque.repository.EstoqueRepository;
import com.licao.spring.estoque.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@Override
	public Iterable<Estoque> listar() {
		return estoqueRepository.findAll();
	}

	@Override
	public Optional<Estoque> buscar(Integer id) {
		return estoqueRepository.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Estoque persistir(Estoque estoque) throws Exception {
		return estoqueRepository.save(estoque);
	}

	@Override
	public void deletar(Integer id) {
		estoqueRepository.deleteById(id);
	}

	@Override
	public boolean existe(Integer id) {
		return estoqueRepository.existsById(id);
	}

	@Override
	public void atualizarStatus(Estoque estoque) throws Exception {

		if (existe(estoque.getId())) {

			int quantidade = estoque.getQuantidade();
			int quantidadeStatusAlto = estoque.getQuantidadeStatusAlto();
			int quantidadeStatusBaixo = estoque.getQuantidadeStatusBaixo();

			StatusEstoque status = StatusEstoque.OK;

			if (quantidade >= quantidadeStatusAlto) {
				status = StatusEstoque.ALTO;
			} else if (quantidade <= quantidadeStatusBaixo) {
				status = StatusEstoque.BAIXO;
			}

			estoque.setStatus(status);
			persistir(estoque);

		}
	}
}
