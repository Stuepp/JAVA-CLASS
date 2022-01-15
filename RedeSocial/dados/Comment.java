package dados;

public class Comment {
	//Atributos
	private int id, user_id, post_id;
	private String text;
	public Comment(int id, int user_id, int post_id, String msg) {
		this.id = id;
		this.user_id = user_id;
		this.post_id = post_id;
		this.text = msg;
	}
	public Comment() {
		
	}
	//Getters and Setters
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
}