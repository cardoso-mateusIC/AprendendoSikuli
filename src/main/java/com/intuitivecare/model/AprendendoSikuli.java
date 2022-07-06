package com.intuitivecare.model;

import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.intuitivecare.sikuli.SikuliApp;
import com.intuitivecare.sikuli.SikuliImage;
import com.intuitivecare.sikuli.SikuliKeyboard;
import com.intuitivecare.sikuli.SikuliMouse;

public class AprendendoSikuli {

	private Screen s = new Screen();

	private String barraPesquisa;
	private String anexo;
	private String site;

	public AprendendoSikuli(String barraPesquisa, String anexo, String site) {
		this.barraPesquisa = barraPesquisa;
		this.anexo = anexo;
		this.site = site;
	}

	public void abreNavegador(String aplicacaoPath) {
		SikuliApp.openApp(aplicacaoPath);
	}

	public boolean verificaBarraDePesquisa(String imgPath) {
		if (SikuliMouse.click(imgPath) != true) {
			return false;
		}
		return true;
	}

	public void entraNoSite(String site) {
		SikuliKeyboard.writeText(site);
	}

	public void encontraAnexo(String anexo) {
		while (SikuliImage.checkImage(anexo) != true) {
			s.type(Key.PAGE_DOWN);
		}
	}

	public void entraNoAnexo(String anexo) {
		SikuliMouse.click(anexo);
	}

	public String getBarraPesquisa() {
		return barraPesquisa;
	}

	public String getAnexo() {
		return anexo;
	}

	public String getSite() {
		return site;
	}

}
