package negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import dados.User;
import exceptions.*;
import persisencia.ComentarioDAO;
import persisencia.Conexao;
import persisencia.FollowersDAO;
import persisencia.PostDAO;
import persisencia.ReactionDAO;
import persisencia.UserDAO;
import dados.Comment;
import dados.Post;
import dados.Reaction;

public class Action {
	//Atributos
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Post> posts = new ArrayList<>();
	private UserDAO userDAO;
	private PostDAO postDAO;
	private ComentarioDAO comentarioDAO;
	private ReactionDAO reactionDAO;
	private FollowersDAO followersDAO;
	//Construtos
	public Action(String senha) throws ClassNotFoundException,SQLException,SelectException {
		Conexao.setSenha(senha);
		userDAO = new UserDAO();
		postDAO = new PostDAO();
		comentarioDAO = new ComentarioDAO();
		reactionDAO = new ReactionDAO();
		followersDAO = new FollowersDAO();
	}
	//Getters and Setters
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public ArrayList<Post> getPosts() {
		return posts;
	}
	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	//Métodos
	//quando o usuário fizer login vai se ter sempre um User me, sendo esse me o usuário
	public void registerUser(User user) throws InsertException, SelectException {//ok no momento
		users.add(user);
		userDAO.insert(user);
	}
	public User login(int uniquecode, String password) throws SelectException{//ok no momento
		//usar um método de procura visto em EDA
		for(int i = 0; i < userDAO.selectAll().size();i++) {
			if(userDAO.selectAll().get(i).getId() == uniquecode && userDAO.selectAll().get(i).getPassword().equals(password)) {
				return userDAO.selectAll().get(i);
			}
		}
		return null;
	}
	public User logout() throws LogoutException{//é necessária no Action?
		return null;
	}
	public void deleteUser(int id) throws DeleteException, SelectException{//ok no momento
		for(int i = 0; i < userDAO.selectAll().size(); i++) {
			if(userDAO.selectAll().get(i).getId() == id) {
				userDAO.delete(userDAO.selectAll().get(i));
			}
		}
	}
	public ArrayList<User> searchUser(String nome) throws SelectException{//retorna lista de usuarios que contenha o texto inserido no nome/apelido
		//usar um método de procura visto em EDA
		ArrayList<User> foundedUsers = new ArrayList<User>();
		for(int i = 0; i < userDAO.selectAll().size(); i++) {
			if(userDAO.selectAll().get(i).getName().contains(nome) || userDAO.selectAll().get(i).getNickname().contains(nome)) {
				foundedUsers.add(userDAO.selectAll().get(i));
			}
		}
		return foundedUsers;
	}
	public User searchUser(int uniquecode) throws SelectException{//retorna usúario do nome e código inseridos
		return userDAO.select(uniquecode);
	}
	public void followUser(User me,User user) throws InsertException, SelectException{//ok no momento
		followersDAO.insert(me, user);
	}
	public void unfollowUser(User me,User user) throws DeleteException{//ok no momento
		/*me.unfollow_user(user);
		for(int i = 0;  i < user.getFollowers().size(); i++) {
			if(me.getId() == user.getFollowers().get(i).getId()) {
				user.getFollowers().remove(i);
			}
		}
		userDAO.update(user);
		userDAO.update(me);*/
		followersDAO.delete(me, user);
	}
	public void createPost(Post post, User user) throws InsertException, SelectException{//ok no momento
		posts.add(post);
		user.getPosts().add(post);
		postDAO.insert(post,user);
	}
	public void deletePost(User user, int post_id) throws DeleteException, SelectException{//ok no momento
		for(int i = 0; i < postDAO.selectAll().size(); i++) {
			if(postDAO.selectAll().get(i).getId() == post_id){
				postDAO.delete(postDAO.selectAll().get(i));
			}
		}
	}
	public void reactToPost(Post post, User user) throws InsertException, SelectException{//adaptar para ser uma imagem
		Reaction reaction = new Reaction();
		reaction.setId_post(post.getId());
		reaction.setId_user(user.getId());
		reaction.setImg("like");
		reactionDAO.insert(reaction, post, user);
	}
	public void unReactToPost(Post post, User user) throws DeleteException{//adaptar para ser uma imagem
		reactionDAO.delete(post,user);
	}
	public void commentPost(Post post,User user, String txt) throws InsertException, SelectException{
		Comment comment = new Comment();
		comment.setText(txt);
		comment.setUser_id(user.getId());
		comment.setPost_id(post.getId());
		comentarioDAO.insert(comment);
	}
	public ArrayList<User> show_following(User user) throws SelectException{
		return followersDAO.selectAllFollowing(user);
	}
	public ArrayList<User> show_followers(User user) throws SelectException {
		return followersDAO.selectAllFollowers(user);
	}
	public ArrayList<Reaction> show_reactions(Post post) throws SelectException{
		return reactionDAO.selectAll(post);
	}
	public ArrayList<Comment> show_comments(Post post) throws SelectException{
		return comentarioDAO.selectAll(post);
	}
	public ArrayList<User> show_users() throws SelectException {
		return userDAO.selectAll();
	}
	public ArrayList<Post> show_posts() throws SelectException {
		return postDAO.selectAll();
	}
}
