package classes;

import java.util.Arrays;

public class Mapa {
	private Assento[] assentos = new Assento[168];

	public Mapa() {
		int i = 0;
		for (char linha = 'A'; linha <= 'L'; linha++) {
			for (int coluna = 1; coluna <= 14; coluna++) {
				assentos[i++] = new Assento("" + linha + coluna);
			}
		}
	}

	@Override
	public String toString() {
		return "Mapa [assentos= " + Arrays.toString(assentos) + "]";
	}

	public void mostrar() {
		for (int coluna = 1; coluna <= 14; coluna++)
			System.out.print("     " + coluna);

		System.out.println();

		int i = 0;
		for (char linha = 'A'; linha <= 'L'; linha++) {
			System.out.print(linha + "  ");

			for (int j = 0; j < 14; j++) {
				if (i < assentos.length) {
					if (assentos[i].estaOcupado())
						System.out.print("\u001B[31m[" + assentos[i].getId() + "]  \u001B[0m"); // Define a cor verde
					else
						System.out.print("\u001B[32m[" + assentos[i].getId() + "]  \u001B[0m"); // Define a cor vermelha
					i++;
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public Assento[] getAssentos() {
		return assentos;
	}

	public void setAssentos(Assento[] assentos) {
		this.assentos = assentos;
	}
	
	public int qtdeDisponivel() {
		int cont = 0;
		
		for(Assento el : assentos) {
			if(!el.estaOcupado())
				cont++;
		}
		return cont;
	}
	
	public int qtdeOcupada() {
		int cont = 0;
		
		for(Assento el : assentos) {
			if(el.estaOcupado())
				cont++;
		}
		return cont;
	}
}