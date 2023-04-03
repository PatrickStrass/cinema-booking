package classes;

import java.util.Scanner;

public class Menu implements Opcoes {
	private Scanner sc;
	private Mapa mapa;

	public Menu() {
		sc = new Scanner(System.in);
		mapa = new Mapa();
	}

	public void mostrarMenu() {
		int opcao;

	    do {
	        System.out.println("Bem-vindo ao Cinema!\n(1) Reservar\n(2) Quantidade\n(3) Mostrar mapa\n(4) Cancelar\n(5) Sair\nOpção: ");
	        opcao = sc.nextInt();
	        System.out.println();

	        switch (opcao) {
	        case 1:
	            if (reservar())
	                System.out.println("Assento reservado!\n");
	            else
	                System.out.println("Não foi possível reservar o assento especificado!\n");
	            break;
	        case 2:
	            quantidadeAssentos();
	            break;
	        case 3:
	            mostrarMapa();
	            break;
	        case 4:
	            if (cancelar())
	                System.out.println("Assento cancelado!\n");
	            else
	                System.out.println("Não foi possível cancelar o assento especificado!\n");
	            break;
	        case 5:
	            break;
	        default:
	            System.out.println("Opção inválida!\n");
	            break;
	        }
	    } while (opcao != 5);
	}

	@Override
	public boolean reservar() {
		String idAssentoParaReservar;
		mapa.mostrar();
		System.out.println("Digite o ID do assento que deseja reservar: ");
		idAssentoParaReservar = sc.next().toUpperCase();

		for (Assento el : mapa.getAssentos()) {
			if (el.getId().equals(idAssentoParaReservar) && !el.estaOcupado()) {
				el.setEstaOcupado(true);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean cancelar() {
		String idAssentoParaCancelar;
		mapa.mostrar();
		System.out.println("Digite o ID do assento que deseja cancelar: ");
		idAssentoParaCancelar = sc.next().toUpperCase();

		for (Assento el : mapa.getAssentos()) {
			if (el.getId().equals(idAssentoParaCancelar) && el.estaOcupado()) {
				el.setEstaOcupado(false);
				return true;
			}
		}
		return false;
	}

	@Override
	public void mostrarMapa() {
		mapa.mostrar();
	}

	@Override
	public void quantidadeAssentos() {
		System.out.println("Total de assentos: " + mapa.getAssentos().length);
		System.out.println("Quantidade disponível: " + mapa.qtdeDisponivel());
		System.out.println("Quantidade ocupada: " + mapa.qtdeOcupada());
		System.out.println();
	}
}