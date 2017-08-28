package com.ufcg.si1.controller.prefeitura;

public class SituacaoExtra implements SituacaoPrefeitura{

	private static final int BOM = 0;
	private static final int REGULAR = 1;
	private static final int RUIM = 2;
	
	@Override
	public int getSituacaoQueixa(double porcetagemQueixas) {
		if (porcetagemQueixas < 0.05) {
			return BOM;
		} else if (porcetagemQueixas < 0.1) {
			return REGULAR;
		} else {
			return RUIM;
		}
	}
	
	public String toString() {
		return "Extra";
	}

	@Override
	public int getTipo() {
		return 1;
	}
}
