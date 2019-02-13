
// package temp;

import java.text.DecimalFormat;
import java.util.Scanner;

enum TempUnit {
    fUnit, cUnit, kUnit
};

public class TempConverter_Leone {

    public static TempUnit goal;
    public static TempUnit given;

    public static double valueInKelvin;

    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat(".##");

    public static void main(String[] args) {
        // get which metric the user wants to convert into
        System.out.println("Would you like to convert to Fahrenheit (F), Celsius (C), or Kelvin (K)?");
        goal = charToTempUnit(sc.next().charAt(0));

        System.out.println("Which temperature are you in: F, C, or K?");
        given = charToTempUnit(sc.next().charAt(0));

        // get the value of the temp
        System.out.println("Enter your temperature");
        double userValue = sc.nextDouble();

        // call the sorting method
        // sortingGeneral(wantThisTemp, knowThisTemp, temp);

        valueInKelvin = toKelvin(given, userValue);

        System.out.println(kelvinTo(goal, valueInKelvin));
    }

    public static TempUnit charToTempUnit(char name) {
        switch (name) {
        case 'f':
        case 'F':
            return TempUnit.fUnit;
        case 'c':
        case 'C':
            return TempUnit.cUnit;
        case 'k':
        case 'K':
            return TempUnit.kUnit;
        default:
            throw new Error("Unknown char");
        }
    }

    public static double toKelvin(TempUnit currUnit, double currValue) {
        switch (currUnit) {
        case cUnit:
            return cToK(currValue);
        case fUnit:
            return kToF(currValue);
        case kUnit:
            return currValue;
        default:
            throw new Error("How did we get here?");
        }
    }

    public static double kelvinTo(TempUnit newUnit, double value) {
        switch (newUnit) {
        case kUnit:
            return value;
        case cUnit:
            return kToC(value);
        case fUnit:
            return fToK(value);
        default:
            throw new Error("No really, how did we get here?");
        }
    }

    public static void sortingF(char knowThisTemp, double temp) {
        // finds out which temp is known so it can do conversions and print
        if (knowThisTemp == 'C' || knowThisTemp == 'c') {
            System.out.println("The temperature in Fahrenheit is " + df.format(cToF(temp)) + " degrees.");
        } else if (knowThisTemp == 'K' || knowThisTemp == 'k') {
            System.out.println("The temperature in Fahrenheit is " + df.format(kToF(temp)) + " degrees.");
        } else if (knowThisTemp == 'F' || knowThisTemp == 'f') {
            System.out.println(
                    "The temperature in Fahrenheit is " + temp + " degrees. You didn't need this converter, silly.");
        } else {
            System.out.println("You have entered an invalid value. Please try again");
            main(new String[0]);
        }

        // switch (given) {
        // case cUnit:
        //     sortingC();
        //     break;
        // case fUnit:
        //     sortingF();
        //     break;
        // case kUnit:
        //     sortingK();
        //     break;
        // }
    }

    public static void sortingC(char knowThisTemp, double temp) {
        // finds out which temp is known so it can do conversions and print
        if (knowThisTemp == 'F' || knowThisTemp == 'f') {
            System.out.println("The temperature in Celsius is " + df.format(fToC(temp)) + " degrees.");
        } else if (knowThisTemp == 'K' || knowThisTemp == 'k') {
            System.out.println("The temperature in Celsius is " + df.format(kToC(temp)) + " degrees.");
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
            System.out.println("The temperature in Kelvin is " + df.format(fToK(temp)) + " degrees.");
        } else if (knowThisTemp == 'C' || knowThisTemp == 'c') {
            System.out.println("The temperature in Kelvin is " + df.format(cToK(temp)) + " degrees.");
        } else if (knowThisTemp == 'K' || knowThisTemp == 'k') {
            System.out.println(
                    "The temperature in Kelvin is " + temp + " degrees. You didn't need this converter, silly.");
        } else {
            System.out.println("You have entered an invalid value. Please try again");
            main(new String[0]);
        }
    }

    // the following process all the conversions

    public static double cToF(double x) {
        return (x * (9 / 5)) + 32;
    }

    public static double kToF(double x) {
        return (x - 273.15) * 9 / 5 + 32;
    }

    public static double fToC(double x) {
        return (x - 32) * 5 / 9;
    }

    public static double kToC(double x) {
        return x - 273.15;
    }

    public static double fToK(double x) {
        return (x - 32) * 5 / 9 + 273.15;
    }

    public static double cToK(double x) {
        return x + 273.15;
    }
}