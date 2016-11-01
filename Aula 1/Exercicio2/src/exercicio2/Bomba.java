package exercicio2;

public class Bomba {
	private Combustivel combustivel;
	private float litros;

	public Bomba(){}
	
	public Bomba(Combustivel combustivel, float litros){
		this.combustivel = combustivel;
		this.litros = litros;
	}
	
	public float getLitros() {
		return litros;
	}
	
	public float calculaValorCombustivel(){
		return (float) ((litros <= 10.0f) ? (litros * combustivel.preco)
				: (litros * combustivel.precoDesconto));
	}
}