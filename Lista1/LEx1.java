package lista1.exercicios;

import java.util.Scanner;

public class LEx1 {

	private int array_size, sum_primes=0, media=0, lowest, biggest, counter=0;
	private int[] values;
	private Scanner s = new Scanner(System.in);
	
	public LEx1() {			
			System.out.println("Digite o tamanho da array: ");
			array_size = Integer.parseInt(s.nextLine());
			values = new int[array_size];
	}
	
    public boolean isPrime(int num) {
        int i = 2;
        if(num == 1){
          return false;
        }
        if(num == 3 || num == 2) {
            return true;
        }
        while(i <= Math.sqrt(num)) {
            if(num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
	
    public void fillArray() {
		System.out.println("Digite um número:");
		values[counter] = Integer.parseInt(s.nextLine());
		lowest = values[counter];
		biggest = values[counter];
		media += values[counter];
		if(isPrime(values[counter])) {
			sum_primes += values[counter];
		}
		counter++;
		
		while(counter < array_size) {
			System.out.println("Digite um número:");
			values[counter] = Integer.parseInt(s.nextLine());
			media += values[counter];
			if(lowest > values[counter]) {
				lowest = values[counter];
			}
			if(biggest < values[counter]) {
				biggest = values[counter];
			}
			if(isPrime(values[counter])) {
				sum_primes += values[counter];
			}
			counter++;
		}
		s.close();
    }
    
    public void print() {
		System.out.println("Soma dos elementos: "+media
				+"\nMenor: "+lowest
				+"\nMaior: "+biggest
				+"\nMédia: "+media/array_size
				+"\nSoma dos primos: "+sum_primes);
    }
    
	public static void main(String[] args) {
		LEx1 ex3 = new LEx1();
		ex3.fillArray();
		ex3.print();
	}

}
