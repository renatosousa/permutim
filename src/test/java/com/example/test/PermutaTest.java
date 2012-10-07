package com.example.test;

import org.junit.Test;

import com.example.model.Cargo;
import com.example.model.Cidade;
import com.example.model.Orgao;
import com.example.model.Permuta;

public class PermutaTest {

	@Test
	public void deveIncluirPermuta(){
		Permuta permuta = new Permuta();
		Orgao orgao = new Orgao();
		orgao.setNome("MPU");
		Cargo cargo = new Cargo();
		cargo.setNome("Analista de Informática");
		Cidade cidade = new Cidade();
		cidade.setNome("Brasília");
		permuta.setOrgao(orgao);
		permuta.setCargo(cargo);
		
	}
}
