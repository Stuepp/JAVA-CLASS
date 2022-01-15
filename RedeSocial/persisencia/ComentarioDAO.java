package persisencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Comment;
import dados.Post;
import dados.User;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class ComentarioDAO {
	
	private static ComentarioDAO instance = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement selectAll;
	
	public ComentarioDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao = Conexao.getConexao();
		
		selectNewId = conexao.prepareStatement("select nextval('id_comment')");
		insert = conexao.prepareStatement("insert into comentario values(?,?,?,?)");
		delete = conexao.prepareStatement("delete from comentario where id_user = ?");
		selectAll = conexao.prepareStatement("select * from comentario where id_post = ?");
	}
	public static ComentarioDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
		if(instance == null) {
			instance = new ComentarioDAO();
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
			throw new SelectException("Erro ao buscar novo comentario");
		}
		return 0;
	}
	public void insert(Comment comentario) throws InsertException, SelectException {
		try {
			comentario.setId(selectNewId());
			insert.setInt(1, comentario.getId());
			insert.setInt(2, comentario.getUser_id());
			insert.setInt(3, comentario.getPost_id());
			insert.setString(4, comentario.getText());
			insert.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InsertException("Erro ao inserir comentario");
		}
	}
	public ArrayList<Comment> selectAll(Post post) throws SelectException{
		ArrayList<Comment> comentarios = new ArrayList<Comment>();
		try {
			selectAll.setInt(1, post.getId());
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				int user_id = rs.getInt(2);
				int post_id = rs.getInt(3);
				String msg = rs.getString(4);
				comentarios.add(new Comment(id,user_id,post_id,msg));
			}
		}catch(SQLException e) {
			throw new SelectException("Erro ao selecionar comentario");
		}
		return comentarios;
	}
}
