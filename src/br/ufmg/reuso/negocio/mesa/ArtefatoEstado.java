package br.ufmg.reuso.negocio.mesa;

/**
 * 
 * Enum para encapsular estado dos artefatos da mesa.
 * 
 * @author Aline Brito, Igor Muzetti (2018-02)
 *
 */
public enum ArtefatoEstado {
	
	SELECIONADO (0),
	NAO_SELECIONADO (1);
	
	public int codigo;
	
	private ArtefatoEstado(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

}
