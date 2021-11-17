package lista1.exercicios;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Lex6 {
	public static String common_letters(String msg, String msg2) {
		msg = msg.toLowerCase();
		msg2 = msg2.toLowerCase();
		char[] Charmsg, Charmsg2;
		if(msg.length() > msg2.length()) {
			Charmsg = msg2.toCharArray();
			Charmsg2 = msg.toCharArray();
		}else {
			Charmsg = msg.toCharArray();
			Charmsg2 = msg2.toCharArray();
		}
		String commonLetters = "";
		int indice1 = 0, indice2 = 0;
		while(indice1 < Charmsg.length) {
			if(Charmsg[indice1] == 32) {
				
			}else {
				while(indice2 < Charmsg2.length) {
					if(Charmsg2[indice2] == 32) {
						
					}else if(Charmsg[indice1] == Charmsg2[indice2]) {
						commonLetters += Charmsg[indice1];
					}
					indice2++;
				}
				indice2 = 0;
			}
			indice1++;
		}
		char[] cl = commonLetters.toCharArray();
		// remover repetidos
        char[] unicos = new char[cl.length];
        int qtd = 0;
        for(int i = 0 ; i < cl.length ; i++) {
            boolean existe = false;
            for( int j = 0 ; j < qtd ; j++ ) {
                if( unicos[ j ] == cl[ i ] ) {
                    existe = true;
                    break;
                }
            }
            if( !existe ) {
                unicos[ qtd++ ] = cl[ i ];
            }
        }

        // ajuste do tamanho do vetor resultante
        unicos = Arrays.copyOf( unicos , qtd );
		Arrays.sort(unicos);

		return new String(unicos);
	}
	
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Escreva a 1º msg:");
		String msg = s.nextLine();
		System.out.println("Escreva a 2º msg:");
		String msg2 = s.nextLine();
		s.close();
		//
		String commonLetters = common_letters(msg,msg2);
		System.out.println(commonLetters);
	}
}
