package br.com.hmiranda.easyway.controllers;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "mainBean")
public class MainBean {
	private String teste = "Teste malandro";

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

}
