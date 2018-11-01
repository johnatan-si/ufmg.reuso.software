package br.ufmg.reuso.negocio.mesa;

/**
 * 
 * Enum para encapsular qualidade dos artefatos da mesa.
 * 
 * @author Aline Brito, Igor Muzetti (2018-02)
 *
 */
public enum ArtefatoQualidade {
	
	BOM (0),
	RUIM (1);
	
	public int codigo;
	
	private ArtefatoQualidade(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

}
