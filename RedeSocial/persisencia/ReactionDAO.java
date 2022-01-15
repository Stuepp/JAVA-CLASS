package persisencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Post;
import dados.Reaction;
import dados.User;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;

public class ReactionDAO {
	private static ReactionDAO instance = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement selectAll;
	
	public ReactionDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao = Conexao.getConexao();
		
		selectNewId = conexao.prepareStatement("select nextval('id_react')");
		insert = conexao.prepareStatement("insert into react values(?,?,?,?)");
		delete = conexao.prepareStatement("delete from react where id_user = ? and id_post = ?");
		selectAll = conexao.prepareStatement("select * from react where id_post = ?");
	}
	public static ReactionDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
		if(instance == null) {
			instance = new ReactionDAO();
		}
		return instance;
	}
	private int selectNewId() throws SelectException {
		try {
			ResultSet rs = selectNewId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			throw new SelectException("Erro ao buscar nova reacao");
		}
		return 0;
	}
	public void insert(Reaction react,Post post,User user) throws InsertException, SelectException {
		try {
			react.setId(selectNewId());
			insert.setInt(1, react.getId());
			insert.setInt(2, user.getId());
			insert.setInt(3, post.getId());
			insert.setString(4, react.getImg());
			insert.executeUpdate();
		}catch(SQLException e) {
			throw new InsertException("Erro ao inserir post");
		}
	}
	public void delete(Post post, User user) throws DeleteException {
		try {
			delete.setInt(1, user.getId());
			delete.setInt(2, post.getId());
			delete.executeUpdate();
		}catch(SQLException e) {
			throw new DeleteException("Erro ao deletar reacao");
		}
	}
	public ArrayList<Reaction> selectAll(Post post) throws SelectException{
		ArrayList<Reaction> posts = new ArrayList<Reaction>();
		try {
			selectAll.setInt(1, post.getId());
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				int id_user = rs.getInt(2);
				int id_post = rs.getInt(3);
				String img = rs.getString(4);
				posts.add(new Reaction(id,id_user,id_post,img));
			}
		}catch(SQLException e) {
			throw new SelectException("Erro ao selecionar reacao");
		}
		return posts;
	}
}
