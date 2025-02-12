package labb;

import java.util.Arrays;
import java.util.Random;

public class Facit3 {


		
		public static void main(String[] args) {
			
			// Skapar v�rden
			int n = (new Random().nextInt(10)+1);
			int m = (new Random().nextInt(10)+1);
			int [] NtoY = new int[n];
			int [] XtoM = new int[m];
			int [][] vagar = new int[m][n];		
				for(int i = 0; i < m; i++)
				{
					XtoM [i] = (new Random().nextInt(10)+1);
						for(int i2 = 0; i2 < n; i2++)
						{	
							vagar[i][i2] =  (new Random().nextInt(30)+1);
						}
				}	
				for(int i = 0; i < n; i++)
					NtoY[i] = (new Random().nextInt(10)+1);	
				
				// Utf�r ber�kning 
				berakning(m, n, NtoY, XtoM, vagar);
		}
		
		public static void berakning(int m, int n, int[] NtoY, int[] XtoM, int[][] vagar)
		{
			int min = vagar[0][0] + XtoM[0] + NtoY[0];
			String Zon = "station 1 och station 1. Vilket �r p� avst�ndet: " + min + ".";
			for(int i = 0; i < m; i++)
			{
				for(int i2 = 0; i2 < n; i2++)
				{
					int kortvag = vagar[i][i2] + XtoM[i] + NtoY[i2];
					System.out.println("Station " + (i+1) + " och station " + (i2+1) + ". Avst�ndet: " + kortvag);
					if(kortvag < min)
					{
						min = kortvag;
						Zon = "station " + (i+1) + " och station " + (i2+1) + ". Vilket �r p� avst�ndet " + min + ".";			
					}
				}
				System.out.println();
			}
			System.out.println(
					  "Avst�nd fr�n X till M: " + Arrays.toString(XtoM)
					+ "\nAvst�nd fr�n Y till N: " + Arrays.toString(NtoY) 
					+ "\nAntal stationer i f�rsta zonen: " + m 
					+ "\nAntal stationer i andra zonen: " + n
					+ "\nKortaste v�gen fr�n X till Y �r genom " + Zon
					);
		}
}