import java.util.Scanner;



public class P3TC {
  public static void main(String[] args){

	  Scanner scanner = new Scanner(System.in);
	  double [][] precios= {{12,2},{15,2.2},{18,4.5},{19,3.5},{23,6},{25,6},{29,5}};
	  //System.out.println("Introduzca la clave telefonica");
	  //Comentado para que no corrompa la respuesta
	  int limite=0;
while(limite<5) {
	  String entrada=scanner.nextLine();
	  String[] parts = entrada.split(",");
	  String part1 = parts[0]; // "clave"
	  String part2 = parts[1]; // "minutos"
	  int CLAVE=Integer.parseInt(parts[0]);
	  int NUMIN=Integer.parseInt(parts[1]);
	  int i=0;
	  for (i=0;i<7;i++)
	  {if (CLAVE==precios [i][0]) {
	//System.out.println("El costo de llamada es: "+((int)(precios [i][1]*NUMIN)));
	//Comentado para que no corrompa la respuesta
	
	if((precios [i][1]*NUMIN)-(int)(precios [i][1]*NUMIN)>0)
	{System.out.println((precios [i][1]*NUMIN));
	}
	else
	{System.out.println((int)(precios [i][1]*NUMIN));
	}
	
}}
limite++;}



  }
}
