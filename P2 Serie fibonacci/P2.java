import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		
		//
		System.out.println("La serie de Fibonacci consiste en una serie de n�meros enteros positivos que inicia con los n�meros 0 y 1.");
		System.out.println("El siguiente n�mero corresponde a la suma de los 2 anteriores. Entonces la serie de Fibonacci es: 0,1,1,2,3,5,8,13,21,... ");
		System.out.println("Implemente un algoritmo que imprima la serie de Fibonacci");
		
		//Se inicia un escaner
		Scanner scanner= new Scanner(System.in);
		System.out.println("Este programa imprime los n�meros que desees visualizar de la serie de fibonacci. \n�Cu�ntos N�meros deseas revisar?");
				int n=scanner.nextInt();//Se pregunta al usuario cuantos numeros desea ver
				//Declaracion de variables
				int i=3;
				double []cont= {0,1}; //numeros a sumar
				double suma=0;
				System.out.println("Los primeros"+n+"numeros de la serie de Fibonacci son:");
				//Switch case con la impresion de 1,2 y n numeros
		switch (n) {
		case 1:
			System.out.println("1� N�mero = "+cont[0]);
			break;
		case 2:
			System.out.println("1� N�mero = "+cont[0]);
			System.out.println("2� N�mero = "+cont[1]);
			break;
		default:
			System.out.println("1� N�mero = 0");
			System.out.println("2� N�mero = 1");
			//ciclo para sumar n numeros.
			while (i<=n)
			{
				suma=cont[1]+cont[0];
				cont[0]=cont[1];
				cont[1]=suma;
				System.out.println((i)+"� N�mero = "+suma);
				i++;
			}
			break;
		
		
		
		}


	}

}
