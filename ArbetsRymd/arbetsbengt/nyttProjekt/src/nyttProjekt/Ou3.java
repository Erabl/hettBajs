package nyttProjekt;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ou3 {
	public static void main(String[] args) {
		System.out.println("ange antal stationer i de tv� zonerna");
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

//		System.out.println("grej");
		
		int[] a = new int[n+1];
		int[][] b = new int[n+1][m+1];
		int[] c = new int[m+1];
		
	//	System.out.println(a[20456]);

		for (int i = 1; i <= n; i++) {
			a[i] = new Random().nextInt(10+1);
			for (int j = 1; j <= m; j++) {
				c[j] = new Random().nextInt(10+1);
				b[i][j] = new Random().nextInt(10 + 1);
				
			}
			
		}
		System.out.println(Arrays.toString(mellanstationer(n,m,a,b,c)));
		
	}

	public static int [] mellanstationer(int n, int m, int[] a, int[][] b, int[] c) {
		int kort = a[1] + b[1][1] + c[1];
//		System.out.println("test");
		String Zon = "station 1 och station 1. Vilket �r p� avst�ndet: " + kort + ".";
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=m; j++) {
				int kortastev�gen = a[i] + b[i][j] + c[j];
			System.out.println("avst�nd mellan station " +  i + " och station " +  j + " �r str�ckan" + kortastev�gen);
				if (kortastev�gen < kort) {

					kort = kortastev�gen;
					Zon = "station " + (i + 1) + " och station " + (j + 1) + ". Vilket �r p� avst�ndet " + kort + ".";
				System.out.println("kortastev�gen g�r igenom" + "station" + i + "och" + j);
				System.out.println(Zon);
				System.out.println("j: " + j + " m: " + m);

				}
			

			}
			System.out.println("\nKortaste v�gen fr�n X till Y �r" + " " + kort);

		}
		System.out.println();
		int[] sst = {0,0};
		 return sst;
																																																																																																																																																																																																																																																																																																																		
	}

	// for (int i = 0; i < n; i++) {

	// c[i] = new Random().nextInt();
	// }

//	public static void kortaste (int n, int m, int[] a, int[][] b, int[] c)
//	{
//
//		int kort = a[0] + b[0][0] + c[0];
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				int kortastev�gen = a[i] + b[i][j] + c[j];
//				System.out.println("avst�nd mellan station" + i + "och station" + j + "�r str�ckan" + kortastev�gen);
//				if (kortastev�gen < kort) {
//
//					kortastev�gen = kort;
//				}
//				System.out.println("\nAntal stationer i f�rsta zonen: " + m + "\nAntal stationer i andra zonen: " + n
//						+ "\nKortaste v�gen fr�n X till Y �r" + kort);
//			}
//
//		}
}
