package temp;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TempConv {

	public static char wantThisTemp, knowThisTemp;
	public static double Temp;
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
		double temp = sc.nextDouble();
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
			System.out.println("The temperature in Fahrenheit is " + df.format(getFFromC(temp)) + " degrees.");
		} else if (knowThisTemp == 'K' || knowThisTemp == 'k') {
			System.out.println("The temperature in Fahrenheit is " + df.format(getFFromK(temp)) + " degrees.");
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
			System.out.println("The temperature in Celsius is " + df.format(getCFromF(temp)) + " degrees.");
		} else if (knowThisTemp == 'K' || knowThisTemp == 'k') {
			System.out.println("The temperature in Celsius is " + df.format(getCFromK(temp)) + " degrees.");
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
			System.out.println("The temperature in Kelvin is " + df.format(getKFromF(temp)) + " degrees.");
		} else if (knowThisTemp == 'C' || knowThisTemp == 'c') {
			System.out.println("The temperature in Kelvin is " + df.format(getKFromC(temp)) + " degrees.");
		} else if (knowThisTemp == 'K' || knowThisTemp == 'k') {
			System.out.println(
					"The temperature in Kelvin is " + temp + " degrees. You didn't need this converter, silly.");
		} else {
			System.out.println("You have entered an invalid value. Please try again");
			main(new String[0]);
		}
	}

	// the following process all the conversions

	public static double getFFromC(double x) {
		return (x * (9 / 5)) + 32;
	}

	public static double getFFromK(double x) {
		return (x - 273.15) * 9 / 5 + 32;
	}

	public static double getCFromF(double x) {
		return (x - 32) * 5 / 9;
	}

	public static double getCFromK(double x) {
		return x - 273.15;
	}

	public static double getKFromF(double x) {
		return (x - 32) * 5 / 9 + 273.15;
	}

	public static double getKFromC(double x) {
		return x + 273.15;
	}
}