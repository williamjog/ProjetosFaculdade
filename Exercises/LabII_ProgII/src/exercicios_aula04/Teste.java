package exercicios_aula04;

public class Teste {

	public static void main(String[] args) {

		Carro carro = new Carro(500, 300, 12);

		try {
			carro.encherTanque(200); // acima de 200 acusa exce��o
			
			carro.andar(3604); // acima de 3603 acusa exce��o
			
			carro.encherTanque(300.25); // abaixo de 300.25 o tanque n�o recupera o trajeto gasto no andar da linha 12
						
			carro.andar(6000); // acima de 6000 acusa a exce��o
			
			
		} catch (TanqueCheioException e) {
			System.out.println(e.getMessage());
		} catch (TanqueVazioException e) {
			System.out.println(e.getMessage());
		} catch (TanqueInsuficienteException e) {
			System.out.println(e.getMessage());
		}
	}
}
