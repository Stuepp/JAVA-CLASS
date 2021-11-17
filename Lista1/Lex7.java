package lista1.exercicios;

import java.util.Calendar;
import java.util.Scanner;

public class Lex7 {
	public static int idade_dias(int dd, int mm, int yy) {
		Calendar calendar = Calendar.getInstance();
		int anoAtual = calendar.get(Calendar.YEAR);
		int mesAtual = calendar.get(Calendar.MONTH);
		int diaAtual = calendar.get(Calendar.DAY_OF_MONTH);
		
		yy = anoAtual - yy;
		mm = mesAtual - mm;
		dd = diaAtual - dd;
		
		dd =  dd + (mm*31)+ (yy*365);
		
		return dd;
	}
	
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite sua data de nascimento: (dd/mm/yy)");
		String birth = s.nextLine();
		String[] splitBirth = birth.split("\\/");
		int dd = Integer.parseInt(splitBirth[0]);
		int mm = Integer.parseInt(splitBirth[1]);
		int yy = Integer.parseInt(splitBirth[2]);
		
		System.out.println("Sua idade em dias é: "+ idade_dias(dd,mm,yy));
	}
}
