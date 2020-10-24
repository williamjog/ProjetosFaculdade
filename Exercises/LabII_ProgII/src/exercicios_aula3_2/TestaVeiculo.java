package exercicios_aula3_2;

public class TestaVeiculo {

	public static void main(String[] args) {
		
		Veiculo v = new Carro(220, 495000, 2020);
		
		System.out.println(v);
		
		((Carro)v).setAnoDeFabricacao(2018);
		
		System.out.println(((Carro)v).getAnoDeFabricacao());

		Veiculo v2 = new Onibus(125, 200000, 60);
		
		System.out.println("");
		System.out.println(v2);
		
		((Onibus) v2).setCapacidadeDePassageiros(40);
		System.out.println(((Onibus) v2).getCapacidadeDePassageiros());
	}
}

