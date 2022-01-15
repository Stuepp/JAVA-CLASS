package persisencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Post;
import dados.User;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;

public class PostDAO {
	private static PostDAO instance = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement selectAll;
	
	public PostDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao = Conexao.getConexao();
		
		selectNewId = conexao.prepareStatement("select nextval('id_post')");
		insert = conexao.prepareStatement("insert into post values(?,?,?,?,?)");
		delete = conexao.prepareStatement("delete from post where id = ?");
		selectAll = conexao.prepareStatement("select * from post");
	}
	public static PostDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
		if(instance == null) {
			instance = new PostDAO();
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
			throw new SelectException("Erro ao buscar novo post");
		}
		return 0;
	}
	public void insert(Post post,User user) throws InsertException, SelectException {
		try {
			post.setId(selectNewId());
			insert.setInt(1, post.getId());
			insert.setInt(2, user.getId());
			insert.setString(3, post.getSubtitle());
			insert.setString(4, post.getDescription());
			insert.setString(5, post.getImagem());
			/*
			 * inserir reações
			 * inserrir comentários
			 */
			insert.executeUpdate();
		}catch(SQLException e) {
			throw new InsertException("Erro ao inserir post");
		}
	}
	public void delete(Post post) throws DeleteException {
		try {
			delete.setInt(1, post.getId());
			delete.executeUpdate();
		}catch(SQLException e) {
			throw new DeleteException("Erro ao deletar post");
		}
	}
	public ArrayList<Post> selectAll() throws SelectException{
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				int user_id = rs.getInt(2);
				String title = rs.getString(3);
				String description = rs.getString(4);
				String img = rs.getString(5);
				/*Pegar
				 * reações
				 * comentários
				 */
				posts.add(new Post(id,user_id,title,description,img));
			}
		}catch(SQLException e) {
			throw new SelectException("Erro ao selecionar post");
		}
		return posts;
	}
}
