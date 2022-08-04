package jdbc;

import jdbc.DaoProdutos.DaoProdutos;
import jdbc.produtos.Produtos;
import jdbc.utilidades.Conexao;

public class jdbc {

	public static void main(String[] args) {
		// verificarConexao();
		//inserirProduto("Pipoca", 7.50, 10);
		// listarProdutos();
		// selecionarUmProduto(4);
		//alterarUmProduto(5);
		// excluirUmProduto(3);
	}

	static void verificarConexao() {
		if (Conexao.conectar() != null) {
			System.out.println("Conectado");
		} else {
			System.out.println("Erro ao conectar");
		}
	}

	static void inserirProduto(String nome, double preco, double estoque) {
		String n = nome;
		double p = preco;
		double e = estoque;

		Produtos produto = new Produtos(n, p, e);
		DaoProdutos daoProdu = new DaoProdutos();

		if (daoProdu.salvar(produto)) {
			System.out.println("Produto cadastrado com sucesso");
		}
	}

	static void listarProdutos() {
		DaoProdutos daoProdu = new DaoProdutos();
		System.out.println(daoProdu.consultar());
	}

	static void selecionarUmProduto(int id) {

		DaoProdutos daoProdu = new DaoProdutos();
		Produtos produto = new Produtos();
		produto = daoProdu.consultar(id);
		System.out.println(produto);
		System.out.println("Fim");
	}

	static void alterarUmProduto(int id) {
		DaoProdutos daoProdu = new DaoProdutos();
		Produtos produto = new Produtos();
		produto = daoProdu.consultar(id);

		produto.setNome("abacaxi");
		produto.setPreco(3.80);
		produto.setEstoque(10);

		if (daoProdu.alterar(produto)) {
			System.out.println("Produto alterado com sucesso");
			System.out.println(produto);
		}
	}

	static void excluirUmProduto(int id) {
		DaoProdutos daoProdu = new DaoProdutos();
		daoProdu.excluir(id);
		System.out.println("produto excluido com sucesso");
	}

}
