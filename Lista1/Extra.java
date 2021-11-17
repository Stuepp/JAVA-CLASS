package lista1.exercicios;

import java.util.Scanner;

public class Extra {
	public static int[] msg_numerica(String msg) {
		msg = msg.toLowerCase();
		char[] cmsg = msg.toCharArray();
		int[] imsg = new int[cmsg.length];
		int j;
		int[] m = {1,11,111,1111};
		
		for(int i = 0; i < cmsg.length; i++) {
			if(cmsg[i] >= 97 && cmsg[i] <= 99) {//a-c
				j = (cmsg[i] % 97);
				for(int k = 0; k <= j; k++) {
					imsg[i] = 2*m[k];
				}
			}
			if(cmsg[i] >= 100 && cmsg[i] <= 102) {//d-f
				j = (cmsg[i] % 100);
				for(int k = 0; k <= j; k++) {
					imsg[i] = 3*m[k];
				}
			}
			if(cmsg[i] >= 103 && cmsg[i] <= 105) {//g-i
				j = (cmsg[i] % 103);
				for(int k = 0; k <= j; k++) {
					imsg[i] = 4*m[k];
				}
			}
			if(cmsg[i] >= 106 && cmsg[i] <= 108) {//j-l
				j = (cmsg[i] % 106);
				for(int k = 0; k <= j; k++) {
					imsg[i] = 5*m[k];
				}
			}
			if(cmsg[i] >= 109 && cmsg[i] <= 111) {//m-o
				j = (cmsg[i] % 109);
				for(int k = 0; k <= j; k++) {
					imsg[i] = 6*m[k];
				}
			}
			if(cmsg[i] >= 112 && cmsg[i] <= 115) {//p-s
				j = (cmsg[i] % 112);
				for(int k = 0; k <= j; k++) {
					imsg[i] = 7*m[k];
				}
			}
			if(cmsg[i] >= 116 && cmsg[i] <= 118) {//t-v
				j = (cmsg[i] % 116);
				for(int k = 0; k <= j; k++) {
					imsg[i] = 8*m[k];
				}
			}
			if(cmsg[i] >= 119 && cmsg[i] <= 122) {//w-z
				j = (cmsg[i] % 119);
				for(int k = 0; k <= j; k++) {
					imsg[i] = 9*m[k];
				}
			}
		}		
		return imsg;
}
	
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Escreva uma mensagem: ");
		String msg = s.nextLine();
		s.close();
		int[] imsg = msg_numerica(msg);
		char[] cmsg = msg.toCharArray();
		for(int i = 0; i < msg.length(); i++) {
			System.out.println(cmsg[i] +" " + imsg[i]);
		}
	}
}
