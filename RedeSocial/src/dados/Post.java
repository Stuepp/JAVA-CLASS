package dados;

import java.util.ArrayList;

public class Post {
	//Atributos
	private String subtitle, description;
	private ArrayList<Comment> comments = new ArrayList<Comment>();
	private ArrayList<Image> imagens = new ArrayList<Image>();
	private ArrayList<Reaction> likes = new ArrayList<Reaction>();
	private ArrayList<Reaction> sads = new ArrayList<Reaction>();
	private ArrayList<Reaction> happys = new ArrayList<Reaction>();
	private ArrayList<Reaction> angrys = new ArrayList<Reaction>();
	private User user;
	//Getters and Setters
	public ArrayList<Reaction> getLikes() {
		return likes;
	}
	public void setLikes(ArrayList<Reaction> likes) {
		this.likes = likes;
	}
	public ArrayList<Reaction> getSads() {
		return sads;
	}
	public void setSads(ArrayList<Reaction> sads) {
		this.sads = sads;
	}
	public ArrayList<Reaction> getHappys() {
		return happys;
	}
	public void setHappys(ArrayList<Reaction> happys) {
		this.happys = happys;
	}
	public ArrayList<Reaction> getAngrys() {
		return angrys;
	}
	public void setAngrys(ArrayList<Reaction> angrys) {
		this.angrys = angrys;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	public ArrayList<Image> getImagens() {
		return imagens;
	}
	public void setImagens(ArrayList<Image> imagens) {
		this.imagens = imagens;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//métodos
	public void cancel_reactPost(String reactType) {//implementar lógica da imagem (emoji) se react == 0 no emoji
		switch(reactType) {
		case "like":
			for(int i = 0; i < likes.size(); i++) {
				if(likes.get(i).getUser() == user) {
					likes.remove(i);
				}
			}
			break;
		case "sad":
			for(int i = 0; i < sads.size(); i++) {
				if(sads.get(i).getUser() == user) {
					sads.remove(i);
				}
			}
			break;
		case "happy":
			for(int i = 0; i < happys.size(); i++) {
				if(happys.get(i).getUser() == user) {
					happys.remove(i);
				}
			}
			break;
		case "angry":
			for(int i = 0; i < angrys.size(); i++) {
				if(angrys.get(i).getUser() == user) {
					angrys.remove(i);
				}
			}
			break;
		default:
			break;
		}
	}
	public void reactPost(String reactType, User user) {//implementar lógica da imagem (emoji) se react > 0 si emoji
		switch(reactType) {
		case "like":
			if(likes.size() > 0) {
				for(int i = 0; i < likes.size(); i++) {
					if(likes.get(i).getUser() == user) {
						return;
					}
				}
				Reaction like = new Reaction();
				like.setUser(user);
				likes.add(like);
			}else {
				Reaction like = new Reaction();
				like.setUser(user);
				likes.add(like);
			}
			break;
		case "sad":
			if(sads.size() > 0) {
				for(int i = 0; i < sads.size(); i++) {
					if(sads.get(i).getUser() == user) {
						return;
					}
				}
				Reaction sad = new Reaction();
				sad.setUser(user);
				sads.add(sad);
			}else {
				Reaction sad = new Reaction();
				sad.setUser(user);
				sads.add(sad);
			}
			break;
		case "happy":
			if(happys.size() > 0) {
				for(int i = 0; i < happys.size(); i++) {
					if(happys.get(i).getUser() == user) {
						return;
					}
				}
				Reaction happy = new Reaction();
				happy.setUser(user);
				happys.add(happy);
			}else {
				Reaction happy = new Reaction();
				happy.setUser(user);
				happys.add(happy);
			}
			break;
		case "angry":
			if(angrys.size() > 0) {
				for(int i = 0; i < angrys.size(); i++) {
					if(angrys.get(i).getUser() == user) {
						return;
					}
				}
				Reaction angry = new Reaction();
				angry.setUser(user);
				angrys.add(angry);
			}else {
				Reaction angry = new Reaction();
				angry.setUser(user);
				angrys.add(angry);
			}			
			break;
		default:
			break;
		}
	}
	public void comment_in_Post(Comment comment) {
		comments.add(comment);
	}
	public void update_post(ArrayList<Image> imgs,String subtitle,String description){
		imagens = imgs;
		this.subtitle = subtitle;
		this.description = description;
	}
}
