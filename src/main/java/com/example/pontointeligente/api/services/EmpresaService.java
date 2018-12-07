package com.example.pontointeligente.api.services;

import java.util.Optional;

import com.example.pontointeligente.api.entities.Empresa;

public interface EmpresaService {
	
	
	/*
	 * Retorna uma empresa dado um CNPJ
	 * 
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	Optional<Empresa> buscarPorCnpj(String cnpj);

	/*
	 * Persiste um empresa na base de dados
	 * 
	 * @param empresa
	 * @return Empresa
	 */
	Empresa persistir(Empresa empresa);

}
