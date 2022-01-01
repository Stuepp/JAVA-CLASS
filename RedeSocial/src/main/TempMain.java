package main;

import java.util.Scanner;
import dados.User;
import exceptions.*;
import dados.Post;
import dados.Image;
import negocio.Action;

public class TempMain {

	private static Scanner s = new Scanner(System.in);
	private static User me;
	private static Action action = new Action();
	
	public static void main(String[] args) {
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
					System.out.println("Digite o nick do usuário:");
					String name = s.nextLine();
					System.out.println("Digite o código único do usuário:");
					int uc = Integer.parseInt(s.nextLine()); 
					search_user(name,uc);
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
					+ "\n(4) motra posts\n(5) procura por um usuário\n(6) deletar usuário"
					+ "\n(7) seguir usuário\n(8) deixar se seguir usuário\n(9) criar post"
					+ "\n(10) deletar post\n(11) logout");
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
					System.out.println("Digite o código único do usuário:");
					int uc = Integer.parseInt(s.nextLine()); 
					search_user(name,uc);
					break;
				case 6:
					delete_user();
					break;
				case 7:
					follow_user();
					break;
				case 8:
					unfollow_user();
					break;
				case 9:
					create_post();
					break;
				case 10:
					delete_post();
					break;
				case 11:
					logout();
					break;
				default:
				break;
			}
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	public static void register() {
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
		System.out.println("Seu código único: " +user.getUniqueCode());
		
		action.registerUser(user);
	}
	public static void login() throws LoginException{
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
					+ "\n"+me.getNickname()+"#"+me.getUniqueCode());
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
	public static void show_users() throws SearchUserException{//Criar na action, na verdade está ok
		System.out.println("Usuários cadastrados:");
		for(int i = 0; i < action.getUsers().size(); i++) {
			System.out.println(action.getUsers().get(i).getNickname()+"#"+action.getUsers().get(i).getUniqueCode()
					+"\n"+action.getUsers().get(i).getBio()
					+"\n\tSeguidores: "+action.getUsers().get(i).getFollowers().size());
			for(int j = 0; j < action.getUsers().get(i).getFollowers().size(); j++) {
				System.out.println("\t\t"+action.getUsers().get(i).getFollowers().get(j).getNickname()+"#"+action.getUsers().get(i).getFollowers().get(j).getUniqueCode());
			}
		}
	}
	public static void delete_user() throws DeletePostException, DeleteUserException{
		System.out.println("Deseja realmente deletar a conta?");
		boolean escolha = Boolean.parseBoolean(s.nextLine());
		if(escolha == true) {
			for(int i = 0; i < me.getPosts().size(); i++) {
				action.deletePost(me, i);
			}
			System.out.println("Posts de "+me.getName()+" deletados");
			action.deleteUser(me);
			me = null;
			System.out.println("Usuário deletado");
		}else if(escolha == false){
			System.out.println("Operação cancelada");
		}
	}
	public static void follow_user() throws FollowException, SearchUserException{
		show_users();
		System.out.println("Digite o código de quem deseja seguir:");
		int uniquecode = Integer.parseInt(s.nextLine());
		for(int i = 0; i < action.getUsers().size();i++) {
			if(uniquecode == me.getUniqueCode()) {
				System.out.println("Você não pode se seguir");
			}else if(uniquecode == action.getUsers().get(i).getUniqueCode() && uniquecode != me.getUniqueCode()) {
				action.followUser(me, action.getUsers().get(i));
				System.out.println(me.getNickname()+" começou a seguir "+action.getUsers().get(i).getNickname());
			}
		}
	}
	public static void unfollow_user() throws UnfollowException{
		System.out.println("Seguindo:");
		for(int i = 0; i < me.getFollowing().size(); i++) {
			System.out.println("\t"+me.getFollowing().get(i).getNickname()+"#"+me.getFollowing().get(i).getUniqueCode());
		}
		System.out.println("Digite o código de quem deseja parar de seguir:");
		int uniquecode = Integer.parseInt(s.nextLine());
		for(int i = 0; i < me.getFollowing().size(); i++) {
			if(me.getFollowing().get(i).getUniqueCode() == uniquecode) {
				action.unfollowUser(me, me.getFollowing().get(i));
			}
		}
	}
	public static void create_post() throws PostException{
		Post post = new Post();
		System.out.println("Digite o sub titulo do post:");
		post.setSubtitle(s.nextLine());
		System.out.println("Descrição do post:");
		post.setDescription(s.nextLine());
		int repet = 0, contador = 0;
		while(repet == 0 && contador < 5) {
			Image img = new Image();
			System.out.println("Img:");
			img.setLocation(s.nextLine());
			post.getImagens().add(img);
			contador++;
			if(contador < 5) {
				System.out.println("Deseja adicionar outra img?(0)sim(1)não");
				repet = Integer.parseInt(s.nextLine());
			}
		}
		post.setUser(me);
		action.createPost(post, me);
	}
	public static void show_posts() throws CommentException, UnreactException, ReactException{
		for(int i = 0; i < action.getPosts().size(); i++) {
			Post post = action.getPosts().get(i);
			System.out.println(post.getSubtitle()+"\n\t"+post.getDescription());
			for(int j = 0; j < post.getImagens().size(); j++) {
				System.out.println(post.getImagens().get(j).getLocation()+"\n");
			}
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
			if(post.getComments().size() > 0) {
				System.out.println("Deseja ver os comentários?");
				Boolean escolha = Boolean.parseBoolean(s.nextLine());
				if(escolha) {
					for(int j = 0; j < post.getComments().size(); j++) {
						System.out.println(post.getComments().get(j).getUser().getNickname());
						System.out.println("\t"+post.getComments().get(j).getText());
					}
				}
			}
			if(me != null) {
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
				}
				System.out.println("Deseja fazer um comentário?");
				Boolean escolha = Boolean.parseBoolean(s.nextLine());
				if(escolha) {
					comment_post(post);
				}
			}
			System.out.println("Autor: "+post.getUser().getNickname());
		}
	}
	public static void delete_post() throws DeletePostException{
		System.out.println("Meus Posts:");
		for(int i = 0; i < me.getPosts().size();i++) {
			Post post = me.getPosts().get(i);
			System.out.println("#"+i+"\n"+post.getSubtitle()+"\n\t"+post.getDescription());
			for(int j = 0; j < post.getImagens().size(); j++) {
				System.out.println(post.getImagens().get(j).getLocation());
			}
		}
		System.out.println("Digite o número do post que deseja deletar");
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
	public static void search_user(String nick, int uniquecode) throws SearchUserException{
		if(action.searchUser(nick,uniquecode) == null) {
			System.out.println("Usuário não encontrado");
		}else {
			System.out.println(action.searchUser(nick,uniquecode).getName()
					+"\n"+action.searchUser(nick,uniquecode).getNickname()+action.searchUser(nick,uniquecode).getUniqueCode()
					+"\n"+action.searchUser(nick,uniquecode).getBio());
		}
	}
	public static void search_user(String nick) throws SearchUserException{
		if(action.searchUser(nick) == null) {
			
		}else {
			for(int i = 0; i < action.searchUser(nick).size(); i++) {
				System.out.println(action.searchUser(nick).get(i).getName());
				System.out.println("\t"+action.searchUser(nick).get(i).getNickname()+action.searchUser(nick).get(i).getUniqueCode());
			}
		}
	}
	public static void comment_post(Post post) throws CommentException{
		System.out.println("Digite seu comentário");
		action.commentPost(post, me, s.nextLine());
	}
}
