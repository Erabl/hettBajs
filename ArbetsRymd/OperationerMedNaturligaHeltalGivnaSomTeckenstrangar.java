package labb;

import java.util.*;
//Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
	public static void main(String[] args) {

		out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

		// mata in tv� naturliga heltal
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		out.println("tv� naturliga heltal, tal1 m�ste vara st�rre �n tal2:");

		String tal1 = in.next();
		String tal2 = in.next();
		System.out.println(tal1);
		System.out.println(tal2);
		
		while (tal1.length() > tal2.length()) {
			tal2 = 0 + tal2;
		}
		
		

		out.println();

		// addera heltalenoch visa resultatet
		String summa = addera(tal1, tal2);
		visa(tal1, tal2, summa, '+');

		// subtrahera heltalen och visa resultatet

		// koden h�r
		String differens = subtrahera(tal1, tal2);
		visa(tal1, tal2, differens, '-');
		
		
			
	}

	// addera tar emot tv� naturliga heltal givna somteckenstr�ngar, och returnerar
	// deras
	// summa som en teckenstr�ng.
	public static String addera(String tal1, String tal2) {
		// int a = Integer.parseInt(tal1);
		// int b = Integer.parseInt(tal2);
		// int sum = a + b;
		// String summa = Integer.toString(sum);
		// return summa;
		

		StringBuilder sbSum = new StringBuilder();
		int minne = 0;
	int summa = 0;
	
				
			
		
		for (int i = tal1.length() - 1; i >= 0; i--) {
		//	System.out.println("test3");
            if (((Character.getNumericValue(tal1.charAt(i))) + (Character.getNumericValue(tal2.charAt(i)) + minne) >= 10)) {
                    summa = (((Character.getNumericValue(tal1.charAt(i))) + (Character.getNumericValue(tal2.charAt(i))) + minne) % 10);
                    minne = 1;
        //            System.out.println("test1");
            }
            else {
                    summa = (Character.getNumericValue(tal1.charAt(i))) + (Character.getNumericValue(tal2.charAt(i))) + minne;
                    minne = 0;
       //             System.out.println("test2");

            }
     //       System.out.println("test4");
            sbSum.insert (0,summa); //insert l�gger till summa l�ngst fram i str�ngen(str�ngbufferten)
            summa = 0;
    }

		 
        // Om minne == 1
        if (minne == 1)
                sbSum.insert (0, minne);


        return sbSum.toString ();
}
	

	// subtrahera tar emot tv� naturliga heltal givna somteckenstr�ngar, och
	// returnerar
	// deras differens som en teckenstr�ng.
	// Det f�rsta heltalet �r inte mindre �n det andra heltalet.
	public static String subtrahera(String tal1, String tal2) {
		StringBuilder sbDiff = new StringBuilder ();
		 
        int minne = 0;
        int diff = 0;


        for (int i = tal1.length () - 1; i >= 0; i--) {
                if ((Character.getNumericValue(tal1.charAt(i))) + minne - (Character.getNumericValue(tal2.charAt(i)) ) < 0) {
                        diff = ((Character.getNumericValue(tal1.charAt(i)))) + minne + 10 - (Character.getNumericValue(tal2.charAt(i)));
                        
                        minne = -1;
                }
                else {
                        diff = (Character.getNumericValue(tal1.charAt(i))) + minne - (Character.getNumericValue(tal2.charAt(i)));
                        minne = 0;
                }

                sbDiff.insert (0, diff);
                diff = 0;
        }

        return sbDiff.toString ();
}

	// visa visar tv� givna naturliga heltal, och resultatet av en aritmetisk
	// operation
	// utf�rd i samband med hetalen
	public static void visa(String tal1, String tal2, String resultat, char operator) {
		// s�tt en l�mplig l�ngd p� heltalen och resultatet
		int len1 = tal1.length();
		int len2 = tal2.length();

		int len = resultat.length();
		int maxLen = Math.max(Math.max(len1, len2), len);

		tal1 = sattLen(tal1, maxLen - len1);
		tal2 = sattLen(tal2, maxLen - len2);
		resultat = sattLen(resultat, maxLen - len);

		// visa heltalen och resultatet
		out.println("  " + tal1);
		out.println("" + operator + " " + tal2);

		for (int i = 0; i < maxLen + 2; i++) {
			out.print("-");
		}

		out.println();
		out.println("  " + resultat + "\n");
	}

	// sattLen l�gger till ett angivet antal mellanslagi b�rjan av en given str�ng
	public static String sattLen(String s, int antal) {

		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < antal; i++) {
			sb.insert(0, " ");
		}

		return sb.toString();
	}
}