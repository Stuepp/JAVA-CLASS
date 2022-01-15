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

public class FollowersDAO {
	private static FollowersDAO instance = null;
	private UserDAO userDAO;
	
	private PreparedStatement selectNewId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement selectAllFollowers;
	private PreparedStatement selectAllFollowing;
	
	public FollowersDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao = Conexao.getConexao();
		
		selectNewId = conexao.prepareStatement("select nextval('id_followers')");
		insert = conexao.prepareStatement("insert into followers values(?,?,?)");
		delete = conexao.prepareStatement("delete from followers where id_user1 = ? and id_user2 = ?");
		selectAllFollowers = conexao.prepareStatement("select * from followers where id_user2 = ?");
		selectAllFollowing = conexao.prepareStatement("select * from followers where id_user1 = ?");
		
		userDAO = UserDAO.getInstance();
	}
	public static FollowersDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
		if(instance == null) {
			instance = new FollowersDAO();
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
			throw new SelectException("Erro ao buscar nova relacao follower/relacao");
		}
		return 0;
	}
	public void insert(User follower,User target) throws InsertException, SelectException {
		try {
			insert.setInt(1, selectNewId());
			insert.setInt(2, follower.getId());
			insert.setInt(3, target.getId());
			insert.executeUpdate();
		}catch(SQLException e) {
			throw new InsertException("Erro ao inserir relacao follower/target");
		}
	}
	public void delete(User follower, User target) throws DeleteException {
		try {
			delete.setInt(1, follower.getId());
			delete.setInt(2, target.getId());
			delete.executeUpdate();
		}catch(SQLException e) {
			throw new DeleteException("Erro ao deletar relacao follower/target");
		}
	}
	public ArrayList<User> selectAllFollowers(User user) throws SelectException{
		ArrayList<User> users = new ArrayList<User>();
		try {
			selectAllFollowers.setInt(1, user.getId());
			ResultSet rs = selectAllFollowers.executeQuery();
			while(rs.next()) {
				users.add(userDAO.select(user.getId()));
			}
		}catch(SQLException e) {
			throw new SelectException("Erro ao selecionar reacao");
		}
		return users;
	}
	public ArrayList<User> selectAllFollowing(User user) throws SelectException{
		ArrayList<User> users = new ArrayList<User>();
		try {
			selectAllFollowing.setInt(1, user.getId());
			ResultSet rs = selectAllFollowing.executeQuery();
			while(rs.next()) {
				users.add(userDAO.select(rs.getInt(3)));
			}
		}catch(SQLException e) {
			throw new SelectException("Erro ao selecionar reacao");
		}
		return users;
	}
}
