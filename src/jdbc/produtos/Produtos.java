package jdbc.produtos;

public class Produtos {

	private int id;
	private String nome;
	private double preco;
	private double estoque;
		
	public Produtos() {
		
	}

	public Produtos(String nome, double preco, double estoque) {
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getEstoque() {
		return estoque;
	}

	public void setEstoque(double estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "\nProdutos [id=" + id + "\n, nome=" + nome + "\n, preco=" + preco + "\n, estoque=" + estoque + "]\n";
	}
	
	
	
}
