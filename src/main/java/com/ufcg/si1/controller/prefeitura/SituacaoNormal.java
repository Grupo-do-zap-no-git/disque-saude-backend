package com.ufcg.si1.controller.prefeitura;

import org.springframework.context.annotation.Primary;

public class SituacaoNormal implements SituacaoPrefeitura {

	private static final String BOM = "Bom";
	private static final String REGULAR = "Regular";
	private static final String RUIM = "Ruim";
	
	@Override
	public String getSituacaoQueixa(double porcetagemQueixas) {
		if (porcetagemQueixas < 0.1) {
			return BOM;
		} else if (porcetagemQueixas < 0.2) {
			return REGULAR;
		} else {
			return RUIM;
		}
	}

}
