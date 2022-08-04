package jdbc.DaoProdutos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.interfaces.ICrud;
import jdbc.produtos.Produtos;
import jdbc.utilidades.Conexao;

public class DaoProdutos implements ICrud<Produtos> {

	@Override
	public boolean salvar(Produtos obj) {

		String sql = "insert into produtos (nome, preco, estoque) values(?,?,?)";
		Connection con = Conexao.conectar();

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setDouble(2, obj.getPreco());
			stm.setDouble(3, obj.getEstoque());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.fechar();
		}

		return true;
	}

	@Override
	public List<Produtos> consultar() {
		List<Produtos> listaDeProdutos = new ArrayList<>();
		String sql = "select * from produtos";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Produtos produto = new Produtos();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setEstoque(rs.getDouble("estoque"));
				listaDeProdutos.add(produto);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		finally {
			Conexao.fechar();
		}
		return listaDeProdutos;
	}

	@Override
	public Produtos consultar(int id) {
		Produtos produto = new Produtos();
		String sql = "select * from produtos where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			if (rs.next()) {
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setEstoque(rs.getDouble("estoque"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexao.fechar();
		}

		return produto;
	}

	@Override
	public boolean alterar(Produtos obj) {
		String sql = "update produtos set  nome = ?, preco = ?, estoque = ? where id = ?";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setDouble(2, obj.getPreco());
			stm.setDouble(3, obj.getEstoque());
			stm.setInt(4, obj.getId());
			stm.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		
		return true;
	}

	@Override
	public void excluir(int id) {

		String sql = "delete from produtos where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
