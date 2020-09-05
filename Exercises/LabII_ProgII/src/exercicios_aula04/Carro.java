package exercicios_aula04;

public class Carro {
		
	double tanque; // 500 litros
	double nivelDeCombustivel; // 300 litros
	double quantidadeQuilometroPorLitro; // 12 litros por KM

	public Carro(double tanque, double nivelDeCombustivel, double quantidadeQuilometroPorLitro) {
		this.tanque = tanque;
		this.nivelDeCombustivel = nivelDeCombustivel;
		this.quantidadeQuilometroPorLitro = quantidadeQuilometroPorLitro;
	}

	public void encherTanque(double quantidadeDeCombustivel) throws TanqueCheioException {
		if(nivelDeCombustivel + quantidadeDeCombustivel > tanque) {
			throw new TanqueCheioException();
		}
		nivelDeCombustivel += quantidadeDeCombustivel;
		
	}
	
	public double distanciaPossivel() {
		return tanque * quantidadeQuilometroPorLitro;
	}
	
	public double combustivelGasto(double distancia) {
		return (distancia / quantidadeQuilometroPorLitro);
	}
	
	public void andar(double distancia) throws TanqueInsuficienteException, TanqueVazioException {
		if (distancia > distanciaPossivel()) {
			throw new TanqueInsuficienteException();
		}
		if (nivelDeCombustivel < distancia / quantidadeQuilometroPorLitro) {
			throw new TanqueVazioException();
		}
		
		nivelDeCombustivel -= (combustivelGasto(distancia));
	}

	public double getTanque() {
		return tanque;
	}

	public void setTanque(double tanque) {
		this.tanque = tanque;
	}

	public double getNivelDeCombustivel() {
		return nivelDeCombustivel;
	}

	public void setNivelDeCombustivel(double nivelDeCombustivel) {
		this.nivelDeCombustivel = nivelDeCombustivel;
	}

	public double getQuantidadeQuilometroPorLitro() {
		return quantidadeQuilometroPorLitro;
	}

	public void setQuantidadeQuilometroPorLitro(double quantidadeQuilometroPorLitro) {
		this.quantidadeQuilometroPorLitro = quantidadeQuilometroPorLitro;
	}
	
	
}
