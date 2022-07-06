package com.intuitivecare.model;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.intuitivecare.sikuli.SikuliApp;

class AprendendoSikuliTest {

	static Path path = Paths.get("../", "/resources").toAbsolutePath();

	AprendendoSikuli subjectUnderTest;

	@BeforeEach
	void setUp() throws Exception {
		subjectUnderTest = new AprendendoSikuli(path.resolve("barra-de-pesquisa.png").normalize().toString(),
				path.resolve("anexo.png").normalize().toString(),
				"https://www.gov.br/ans/pt-br/assuntos/consumidor/o-que-o-seu-plano-de-saude-deve-cobrir-1/o-que-e-o-rol-de-procedimentos-e-evento-em-saude\r");
	}

	@Test
	void testVerificaBarraDePesquisa() {
//		Arrange
		SikuliApp.openApp("C:/Program Files/Mozilla Firefox/firefox.exe");
		boolean expected = true;
//		Act
		boolean verificador = subjectUnderTest.verificaBarraDePesquisa(subjectUnderTest.getBarraPesquisa());
//		Assert
		Assertions.assertEquals(expected, verificador);
	}

}
