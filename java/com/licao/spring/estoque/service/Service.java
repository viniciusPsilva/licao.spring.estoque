package com.licao.spring.estoque.service;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

public interface Service<T> {

	/**
	 * Lista todas as entidades
	 * @return Iterable<T>
	 */
	public Iterable<T> listar();
	
	/**
	 * Busca uma entidade pelo id
	 * @param Integer id
	 * @return Optional<T>
	 */
	public Optional<T> buscar(Integer id);
	
	/**
	 * Persiste uma entidade
	 * @param Entidade <T>
	 * @return <T>
	 * @throws Exception
	 */
	public <S extends T> S persistir(@RequestBody S entity) throws Exception;
	
	/**
	 * Deleta uma entidade pelo id
	 * @param Integer id
	 */
	public void deletar(Integer id);
	
	/**
	 * Verifica se existe a entidade baseando no seu id
	 * @param Integer id
	 * @return boolean
	 */
	public boolean existe(Integer id);
}
