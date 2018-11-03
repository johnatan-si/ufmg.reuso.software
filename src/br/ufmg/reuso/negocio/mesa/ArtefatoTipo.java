package br.ufmg.reuso.negocio.mesa;

/**
 * 
 * Enum para encapsular tipo dos artefatos da mesa.
 * 
 * @author Aline Brito, Igor Muzetti (2018-02)
 *
 */
public enum ArtefatoTipo {
	
	AJUDA (0),
	CODIGO (1),
	DESENHO (2),
	RASTRO (3),
	REQUISITO (4),
	TOTAL (5);
	
	public int codigo;
	
	private ArtefatoTipo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

}
