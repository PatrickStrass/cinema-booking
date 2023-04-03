package classes;

public class Assento {
	private String id;
	private boolean estaOcupado;

	public Assento(String id) {
		this.id = id;
		this.estaOcupado = false;
	}
	
	@Override
	public String toString() {
		return "Assento [id= " + id + ", estaOcupado=" + estaOcupado + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean estaOcupado() {
		return estaOcupado;
	}

	public void setEstaOcupado(boolean estaOcupado) {
		this.estaOcupado = estaOcupado;
	}
}