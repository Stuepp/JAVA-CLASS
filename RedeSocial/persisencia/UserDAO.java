package persisencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.User;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class UserDAO {
	private static UserDAO instance = null;
	private static PostDAO postDAO = null;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement deletePost;
	private PreparedStatement selectAll;
	private PreparedStatement select;
	private PreparedStatement update;
	
	public UserDAO() throws ClassNotFoundException, SQLException, SelectException{
		Connection conexao = Conexao.getConexao();
		
		selectNewId = conexao.prepareStatement("select nextval('id_user')");
		insert = conexao.prepareStatement("insert into usuario values(?,?,?,?,?)");
		delete = conexao.prepareStatement("delete from usuario where id = ?");
		deletePost = conexao.prepareStatement("delete from post where id_user = ?");
		selectAll = conexao.prepareStatement("select * from usuario");
		select = conexao.prepareStatement("select * from usuario where id = ?");
		update = conexao.prepareStatement("update usuario set nome = ?, nickname = ?, bio = ?, senha = ?");
		
		postDAO = PostDAO.getInstance();
	}
	
	public static UserDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
		if(instance == null) {
			instance = new UserDAO();
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
			throw new SelectException("Erro ao buscar novo id da tabela user");
		}
		return 0;
	}
	public void insert(User user) throws InsertException, SelectException {
		try {
			user.setId(selectNewId());
			insert.setInt(1, user.getId());
			insert.setString(2, user.getName());
			insert.setString(3, user.getNickname());
			insert.setString(4, user.getBio());
			insert.setString(5, user.getPassword());
			insert.executeUpdate();
			/*
			 * insert followers
			 * insert following
			*/
		}catch(SQLException e) {
			throw new InsertException("Erro ao inserir user");
		}
	}
	public void delete(User user) throws DeleteException, SelectException {
		/*
		 * delete followers
		 * delete following
		 */
		try {
			deletePost.setInt(1, user.getId());
			deletePost.executeUpdate();
			delete.setInt(1, user.getId());
			delete.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace(System.out);
			throw new DeleteException("Erro ao deletar user");
		}
	}
	public ArrayList<User> selectAll() throws SelectException {
		ArrayList<User> users = new ArrayList<User>();
		try{
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				int uniqueCode = rs.getInt(1);
				String name = rs.getString(2);
				String nickname = rs.getString(3);
				String bio = rs.getString(4);
				String password = rs.getString(5);
				/*
				 * get posts
				 * get followers
				 * get following
				 */
				users.add(new User(uniqueCode,name,nickname,bio,password));
			}
		}catch(SQLException e) {
			throw new SelectException("Erro ao buscar user");
		}
		return users;
	}
	public User select(int uniqueCode) throws SelectException {
		try {
			select.setInt(1, uniqueCode);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				/*
				 * get posts
				 * get followers
				 * get following
				 */
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String nick = rs.getString(3);
				String bio = rs.getString(4);
				String password = rs.getString(5);
				return (new User(id,name,nick,bio,password));
			}

		}catch(SQLException e) {
			throw new SelectException("Erro ao buscar user");
		}
		return null;
	}
	public void update(User user) throws UpdateException {
		try {
			/* 
			 * update followers
			 * update following
			 */
			/*for(int i = 0; i < user.getPosts().size(); i++) {
				postDAO.update(user.getPosts().get(i));
			}*/
			update.setString(1, user.getName());
			update.setString(2, user.getNickname());
			update.setString(3, user.getBio());
			update.setString(4, user.getPassword());
			update.executeUpdate();
		}catch(SQLException e) {
			throw new UpdateException("Erro ao atualizar user");
		}
	}
}
