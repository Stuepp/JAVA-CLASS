package negocio;

import java.util.ArrayList;
import dados.User;
import exceptions.*;
import dados.Comment;
import dados.Post;

public class Action {
	//Atributos
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Post> posts = new ArrayList<>();
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
	public void registerUser(User user) {//ok no momento
		users.add(user);
	}
	public User login(int uniquecode, String password) throws LoginException{//ok no momento
		//usar um método de procura visto em EDA
		for(int i = 0; i < users.size();i++) {
			if(users.get(i).getUniqueCode() == uniquecode && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}
	public User logout() throws LogoutException{//é necessária no Action?
		return null;
	}
	public void deleteUser(User user) throws DeleteUserException{//ok no momento
		
		for(int i = 0;  i < users.size(); i++) {
			if(user.getUniqueCode() == users.get(i).getUniqueCode()) {
				users.remove(i);
			}
		}
	}
	public ArrayList<User> searchUser(String nome) throws SearchUserException{//retorna lista de usuarios que contenha o texto inserido no nome/apelido
		//usar um método de procura visto em EDA
		int size = users.size();
		ArrayList<User> foundedUsers = new ArrayList<User>();
		for(int i = 0; i < size; i++) {
			if(users.get(i).getName().contains(nome) || users.get(i).getNickname().contains(nome)) {
				foundedUsers.add(users.get(i));
			}
		}
		return foundedUsers;
	}
	public User searchUser(String nick,int uniquecode) throws SearchUserException{//retorna usúario do nome e código inseridos
		//usar um método de procura visto em EDA
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getNickname().equals(nick) && users.get(i).getUniqueCode() == uniquecode) {
				return users.get(i);
			}
		}
		return null;
	}
	public void followUser(User me,User user) throws FollowException{//ok no momento
		me.follow_user(user);
		user.getFollowers().add(me);
	}
	public void unfollowUser(User me,User user) throws UnfollowException{//ok no momento
		me.unfollow_user(user);
		for(int i = 0;  i < user.getFollowers().size(); i++) {
			if(me.getUniqueCode() == user.getFollowers().get(i).getUniqueCode()) {
				user.getFollowers().remove(i);
			}
		}
	}
	public void createPost(Post post, User user) throws PostException{//ok no momento
		posts.add(post);
		user.getPosts().add(post);
	}
	public void sharePost() {//como fazer?
		
	}
	public void deletePost(User user, int pos) throws DeletePostException{//ok no momento
		for(int i = 0; i < posts.size();i++) {
			user.delete_Post(pos);
			posts.remove(pos);
		}		
	}
	public void reactToPost(String reactType, Post post, User user) throws ReactException{//adaptar para ser uma imagem
		post.reactPost(reactType, user);
	}
	public void unReactToPost(String reactType, Post post) throws UnreactException{//adaptar para ser uma imagem
		post.cancel_reactPost(reactType);
	}
	public void commentPost(Post post,User user, String txt) throws CommentException{
		Comment comment = new Comment();
		comment.setText(txt);
		comment.setUser(user);
		post.comment_in_Post(comment);
	}
}
