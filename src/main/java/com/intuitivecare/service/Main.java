package com.intuitivecare.service;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.sikuli.script.FindFailed;

import com.intuitivecare.model.AprendendoSikuli;
import com.intuitivecare.sikuli.SikuliImage;

public class Main {

	public static final Logger LOG = LogManager.getLogger(SikuliImage.class);

	static Path path = Paths.get("../", "/resources").toAbsolutePath();

	public static void main(String[] args) throws FindFailed, InterruptedException {

		AprendendoSikuli aprendendoSikuli = new AprendendoSikuli(
				path.resolve("barra-de-pesquisa.png").normalize().toString(),
				path.resolve("anexo.png").normalize().toString(),
				"https://www.gov.br/ans/pt-br/assuntos/consumidor/o-que-o-seu-plano-de-saude-deve-cobrir-1/o-que-e-o-rol-de-procedimentos-e-evento-em-saude\r");

		aprendendoSikuli.abreNavegador("C:/Program Files/Mozilla Firefox/firefox.exe");

		aprendendoSikuli.verificaBarraDePesquisa(aprendendoSikuli.getBarraPesquisa());
		
		aprendendoSikuli.entraNoSite(aprendendoSikuli.getSite());

		aprendendoSikuli.encontraAnexo(aprendendoSikuli.getAnexo());

		aprendendoSikuli.entraNoAnexo(aprendendoSikuli.getAnexo());
	}

}