package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import dados.User;
import exceptions.*;
import dados.Post;
import negocio.Action;

public class TempMain {

	private static Scanner s = new Scanner(System.in);
	private static User me;
	private static Action action;
	private static String senha = "COLOQUE-SUA-SENHA-AQUI";
	
	public static void main(String[] args) throws ClassNotFoundException, SelectException {
		try {
			action = new Action(senha);
		}catch(SQLException e) {
			System.out.println("Falha ao inicializar");
			e.printStackTrace();
			System.exit(0);
		}
		int menu = 0;
		while(menu == 0) {
			if(me == null) {
				panel();
			}else{
				panelLoged();
			}
			System.out.println("Deseja continuar?"
					+ "\n(0)Sim\n(1)Não");
			menu = Integer.parseInt(s.nextLine());
			try {

			}catch(Exception e) {
				System.err.println(e);
			}
		}

	}
	public static void panel() {
		try {
			System.out.println("(1) registra usuário\n(2) login\n(3) mostra usuários"
					+ "\n(4) motra posts\n(5) procura por um usuário\n(6) procura por usuários");
			int escolha = Integer.parseInt(s.nextLine());
			switch(escolha) {
				case 1:
					register();				
					break;
				case 2:
					login();
					break;
				case 3:
					show_users();
					break;
				case 4:
					show_posts();
					break;
				case 5:
					System.out.println("Digite o id do usuário:");
					int id = Integer.parseInt(s.nextLine()); 
					search_user(id);
					break;
				case 6:
					System.out.println("Digite o nick do usuário:");
					String nick = s.nextLine();
					search_user(nick);
				default:
					break;
			}
		}catch(Exception e) {
			System.err.println(e);
		}

	}
	public static void panelLoged() {
		try {
			System.out.println("(1) registra usuário\n(2) login\n(3) mostra usuários"
					+ "\n(4) motra posts\n(5) procurar usuarios\n(6) procura por um usuário\n(7) deletar usuário"
					+ "\n(8) seguir usuário\n(9) deixar se seguir usuário\n(10) criar post"
					+ "\n(11) deletar post\n(12) logout");
			int escolha = Integer.parseInt(s.nextLine());
			switch(escolha) {
				case 1:
					register();				
					break;
				case 2:
					login();
					break;
				case 3:
					show_users();
					break;
				case 4:
					show_posts();
					break;
				case 5:
					System.out.println("Digite o nick do usuário:");
					String name = s.nextLine();
					search_user(name);
					break;
				case 6:
					System.out.println("Digite o id do usuário:");
					int id = Integer.parseInt(s.nextLine()); 
					search_user(id);
					break;
				case 7:
					delete_user();
					break;
				case 8:
					follow_user();
					break;
				case 9:
					unfollow_user();
					break;
				case 10:
					create_post();
					break;
				case 11:
					delete_post();
					break;
				case 12:
					logout();
					break;
				default:
				break;
			}
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	public static void register() throws InsertException, SelectException {
		User user = new User();
		System.out.println("Digite o nome:");
		user.setName(s.nextLine());
		System.out.println("Vai querer nickname?");
		boolean nick = Boolean.parseBoolean(s.nextLine());
		if(nick == true) {
			System.out.println("Digite o nickname:");
			user.setNickname(s.nextLine());
		}else if(nick == false) {
			user.setNickname(user.getName());
		}
		System.out.println("Digite a senha:");
		user.setPassword(s.nextLine());
		System.out.println("Escreva uma bio:");
		user.setBio(s.nextLine());
		
		action.registerUser(user);
		System.out.println("Seu código único: " +user.getId());
	}
	public static void login() throws SelectException {
		try {
			System.out.println("Digite seu código único:");
			int uniquecode = Integer.parseInt(s.nextLine());
			System.out.println("Digite sua senha:");
			String password = s.nextLine();
			me = action.login(uniquecode,password);
		}catch(Exception e) {
			System.err.println(e);
		}
		if(me != null) {
			System.out.println("login was a success");
			System.out.println("Usuário logado:"
					+ "\n"+me.getNickname()+"#"+me.getId());
		}else{
			System.out.println("login failed check for the correct code and/or password");
		}
		
	}
	public static void logout() throws LogoutException{
		System.out.println("Deseja fazer logout?");
		boolean escolha = Boolean.parseBoolean(s.nextLine());
		if(escolha) {
			me = action.logout();
		}
	}
	public static void show_users() throws SelectException{//Criar na action, na verdade está ok
		System.out.println("Usuários cadastrados:");
		ArrayList<User> temp = new ArrayList<User>();
		temp = action.show_users();
		for(int i = 0; i < temp.size(); i++) {
			System.out.println(temp.get(i).getNickname()+"#"+temp.get(i).getId()
					+"\n\t"+temp.get(i).getBio());
			//fazer para mostrar nº de seguidores e seguindo
		}
	}
	public static void delete_user() throws DeleteException, SelectException{
		System.out.println("Deseja realmente deletar a conta?");
		boolean escolha = Boolean.parseBoolean(s.nextLine());
		if(escolha == true) {//fazer deletar os posts do usuario
			action.deleteUser(me.getId());
			me = null;
			System.out.println("Usuário deletado");
		}else if(escolha == false){
			System.out.println("Operação cancelada");
		}
	}
	public static void follow_user() throws FollowException, UpdateException, SelectException{
		show_users();
		System.out.println("Digite o código de quem deseja seguir:");
		int uniquecode = Integer.parseInt(s.nextLine());
		for(int i = 0; i < action.getUsers().size();i++) {
			if(uniquecode == me.getId()) {
				System.out.println("Você não pode se seguir");
			}else if(uniquecode == action.getUsers().get(i).getId() && uniquecode != me.getId()) {
				action.followUser(me, action.getUsers().get(i));
				System.out.println(me.getNickname()+" começou a seguir "+action.getUsers().get(i).getNickname());
			}
		}
	}
	public static void unfollow_user() throws UnfollowException, UpdateException{
		System.out.println("Seguindo:");
		for(int i = 0; i < me.getFollowing().size(); i++) {
			System.out.println("\t"+me.getFollowing().get(i).getNickname()+"#"+me.getFollowing().get(i).getId());
		}
		System.out.println("Digite o código de quem deseja parar de seguir:");
		int uniquecode = Integer.parseInt(s.nextLine());
		for(int i = 0; i < me.getFollowing().size(); i++) {
			if(me.getFollowing().get(i).getId() == uniquecode) {
				action.unfollowUser(me, me.getFollowing().get(i));
			}
		}
	}
	public static void create_post() throws InsertException, SelectException{
		Post post = new Post();
		System.out.println("Digite o sub titulo do post:");
		post.setSubtitle(s.nextLine());
		System.out.println("Descrição do post:");
		post.setDescription(s.nextLine());
		System.out.println("Img:");
		post.setImagem(s.nextLine());
		post.setUser(me);
		action.createPost(post, me);
	}
	public static void show_posts() throws UnreactException, ReactException, SelectException, InsertException{
		ArrayList<Post> posts = new ArrayList<Post>();
		posts = action.show_posts();
		for(int i = 0; i < posts.size(); i++) {
			System.out.println("\t"+posts.get(i).getSubtitle());
			System.out.println(posts.get(i).getDescription());
			System.out.println(posts.get(i).getImagem());
			/*
			if(post.getLikes().size() > 0) {
				System.out.print(" likes: "+post.getLikes().size());
			}
			if(post.getSads().size() > 0) {
				System.out.print(" sad: "+post.getSads().size());	
			}
			if(post.getHappys().size() > 0) {
				System.out.print(" happy: "+post.getHappys().size());	
			}
			if(post.getAngrys().size() > 0) {
				System.out.print(" angry: "+post.getAngrys().size());	
			}
			*/
			if(action.show_comments(posts.get(i)).size() > 0) {
				System.out.println("Deseja ver os comentários?");
				Boolean escolha = Boolean.parseBoolean(s.nextLine());
				if(escolha) {
					for(int j = 0; j < action.show_comments(posts.get(i)).size(); j++) {
						System.out.println("   "+action.searchUser(action.show_comments(posts.get(i)).get(j).getUser_id()).getNickname()+"#"+action.show_comments(posts.get(i)).get(j).getUser_id());
						System.out.println("\t"+action.show_comments(posts.get(i)).get(j).getText());
					}
				}
			}
			if(me != null) {
				/*
				System.out.println("\nDeseja reagir?");
				boolean react = Boolean.parseBoolean(s.nextLine());
				if(react == true) {
					react_post(post);
				}
				if((post.getLikes().size()+post.getSads().size()+post.getHappys().size()+post.getAngrys().size()) > 0) {
					System.out.println("\nDeseja deixar de reagir?");
					boolean unreact = Boolean.parseBoolean(s.nextLine());
					if(unreact == true) {
						unreact_post(post);
					}
				}*/
				System.out.println("Deseja fazer um comentário?");
				Boolean escolha = Boolean.parseBoolean(s.nextLine());
				if(escolha) {
					comment_post(posts.get(i));
				}
				
			}
			//System.out.println("Autor: " + post.getUser().getNickname()); ver como fazer funfar
		}
	}
	public static void delete_post() throws DeleteException, SelectException{
		System.out.println("Meus Posts:");
		ArrayList<Post> myposts = new ArrayList<Post>();
		for(int i = 0; i < action.show_posts().size(); i++) {
			if(action.show_posts().get(i).getUser_id() == me.getId()) {
				myposts.add(action.show_posts().get(i));
			}
		}
		for(int i = 0; i < myposts.size();i++) {
			System.out.println("id#"+myposts.get(i).getId());
			System.out.println("#"+i+"\n"+myposts.get(i).getSubtitle()+"\n\t"+myposts.get(i).getDescription());
			System.out.println(myposts.get(i).getImagem());
		}
		System.out.println("Digite o id do post que deseja deletar");
		int deletar = Integer.parseInt(s.nextLine());
		action.deletePost(me, deletar);
	}
	public static void react_post(Post post) throws ReactException{
		System.out.println("Escolha uma reação: like,sad,happy,angry");
		String react = s.nextLine();
		action.reactToPost(react, post, me);
	}
	public static void unreact_post(Post post) throws UnreactException{
		System.out.println("Quer deixar de reagir?: like,sad,happy,angry");
		String react = s.nextLine();
		action.unReactToPost(react, post);
	}
	public static void search_user(int uniquecode) throws SelectException{
		if(action.searchUser(uniquecode) == null) {
			System.out.println("Usuário não encontrado");
		}else {
			System.out.println(action.searchUser(uniquecode).getName()
					+"\n\t"+action.searchUser(uniquecode).getNickname()+"#"+action.searchUser(uniquecode).getId()
					+"\n\t"+action.searchUser(uniquecode).getBio());
		}
	}
	public static void search_user(String nick) throws SelectException{
		if(action.searchUser(nick) == null) {
			
		}else {
			for(int i = 0; i < action.searchUser(nick).size(); i++) {
				System.out.println(action.searchUser(nick).get(i).getName());
				System.out.println("\t"+action.searchUser(nick).get(i).getNickname()+"#"+action.searchUser(nick).get(i).getId());
			}
		}
	}
	public static void comment_post(Post post) throws InsertException, SelectException{
		System.out.println("Digite seu comentário");
		action.commentPost(post,me, s.nextLine());
	}
}
