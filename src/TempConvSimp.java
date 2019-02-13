package temp;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TempConvSimp {

	public static char wantThisTemp, knowThisTemp;
	public static double temp, tempFinal;
	static Scanner sc = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat(".##");

	public static void main(String[] args) {
		// get which metric the user wants to convert into
		System.out.println("Would you like to convert to Fahrenheit (F), Celsius (C), or Kelvin (K)?");
		wantThisTemp = sc.next().charAt(0);
		System.out.println("Which temperature are you in: F, C, or K?");
		knowThisTemp = sc.next().charAt(0);
		// get the value of the temp
		System.out.println("Enter your temperature");
		temp = sc.nextDouble();
		// call the sorting method
		sortingGeneral(wantThisTemp, knowThisTemp, temp);
	}

	public static void sortingGeneral(char wantThisTemp, char knowThisTemp, double temp) {
		// finds out which temp is wanted and sends it to respective method
		if (wantThisTemp == 'F' || wantThisTemp == 'f') {
			sortingF(knowThisTemp, temp);
		} else if (wantThisTemp == 'C' || wantThisTemp == 'c') {
			sortingC(knowThisTemp, temp);
		} else if (wantThisTemp == 'K' || wantThisTemp == 'k') {
			sortingK(knowThisTemp, temp);
		} else {
			System.out.println("You have entered an invalid value. Please try again");
			main(new String[0]);
		}
	}

	public static void sortingF(char knowThisTemp, double temp) {
		// finds out which temp is known so it can do conversions and print
		if (knowThisTemp == 'C' || knowThisTemp == 'c') {
			tempFinal = (temp * (9 / 5)) + 32;
			System.out.println("The temperature in Fahrenheit is " + df.format(tempFinal) + " degrees.");
		} else if (knowThisTemp == 'K' || knowThisTemp == 'k') {
			tempFinal = (temp - 273.15) * 9 / 5 + 32;
			System.out.println("The temperature in Fahrenheit is " + df.format(tempFinal) + " degrees.");
		} else if (knowThisTemp == 'F' || knowThisTemp == 'f') {
			System.out.println(
					"The temperature in Fahrenheit is " + temp + " degrees. You didn't need this converter, silly.");
		} else {
			System.out.println("You have entered an invalid value. Please try again");
			main(new String[0]);
		}
	}

	public static void sortingC(char knowThisTemp, double temp) {
		// finds out which temp is known so it can do conversions and print
		if (knowThisTemp == 'F' || knowThisTemp == 'f') {
			tempFinal = (temp - 32) * 5 / 9;
			System.out.println("The temperature in Celsius is " + df.format(tempFinal) + " degrees.");
		} else if (knowThisTemp == 'K' || knowThisTemp == 'k') {
			tempFinal = temp - 273.15;
			System.out.println("The temperature in Celsius is " + df.format(tempFinal) + " degrees.");
		} else if (knowThisTemp == 'C' || knowThisTemp == 'c') {
			System.out.println(
					"The temperature in Celsius is " + temp + " degrees. You didn't need this converter, silly.");
		} else {
			System.out.println("You have entered an invalid value. Please try again");
			main(new String[0]);
		}
	}

	public static void sortingK(char knowThisTemp, double temp) {
		// finds out which temp is known so it can do conversions and print
		if (knowThisTemp == 'F' || knowThisTemp == 'f') {
			tempFinal = (temp - 32) * 5 / 9 + 273.15;
			System.out.println("The temperature in Kelvin is " + df.format(tempFinal) + " degrees.");
		} else if (knowThisTemp == 'C' || knowThisTemp == 'c') {
			tempFinal = temp + 273.15;
			System.out.println("The temperature in Kelvin is " + df.format(tempFinal) + " degrees.");
		} else if (knowThisTemp == 'K' || knowThisTemp == 'k') {
			System.out.println(
					"The temperature in Kelvin is " + temp + " degrees. You didn't need this converter, silly.");
		} else {
			System.out.println("You have entered an invalid value. Please try again");
			main(new String[0]);
		}
	}

}
