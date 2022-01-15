package dados;

public class Reaction {
	//Atributos
	private User user;
	private String img;
	private int id, id_user, id_post;
	public Reaction(int id, int id_user, int id_post, String img) {
		this.id = id;
		this.id_user = id_user;
		this.id_post = id_post;
		this.img = img;
	}
	public Reaction() {
		// TODO Auto-generated constructor stub
	}
	//Getters and Setters
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_post() {
		return id_post;
	}
	public void setId_post(int id_post) {
		this.id_post = id_post;
	}	
}
