package com.ufcg.si1.controller.prefeitura;

import org.springframework.context.annotation.Primary;

public class SituacaoNormal implements SituacaoPrefeitura {

	private static final int BOM = 0;
	private static final int REGULAR = 1;
	private static final int RUIM = 2;
	
	@Override
	public int getSituacaoQueixa(double porcetagemQueixas) {
		System.out.println(porcetagemQueixas);
		if (porcetagemQueixas < 0.1) {
			return BOM;
		} else if (porcetagemQueixas < 0.2) {
			return REGULAR;
		} else {
			return RUIM;
		}
	}
	
	public String toString() {
		return "Normal";
	}

	@Override
	public int getTipo() {
		return 0;
	}
}
