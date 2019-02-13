
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
        while (true) {
            try {
                mainLoop();
                return;
            } catch (Error err) {
                // I'm too lazy to have the user retype just the one error they made
                // (maybe you can do it?)
                System.out.println("Whoa an error occured (" + err.getMessage()
                        + ") while parsing your input!\nType it all again!");
            }
        }
    }

    private static void mainLoop() {
        System.out.println("Would you like to convert to Fahrenheit (F), Celsius (C), or Kelvin (K)?");
        goal = charToTempUnit(sc.next().charAt(0));

        System.out.println("Which temperature are you in: F, C, or K?");
        given = charToTempUnit(sc.next().charAt(0));

        System.out.println("Enter your temperature");
        valueInKelvin = toKelvin(given, sc.nextDouble());

        System.out.println("The temperature in " + tempUnitToString(goal) + " is "
                + df.format(kelvinTo(goal, valueInKelvin)) + " degrees.");

        if (goal == given) {
            System.out.println("You didn't need this converter, silly.");
        }
    }

    private static TempUnit charToTempUnit(char name) {
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

    private static double toKelvin(TempUnit currUnit, double currValue) {
        switch (currUnit) {
        case cUnit:
            return cToK(currValue);
        case fUnit:
            return fToK(currValue);
        case kUnit:
            return currValue;
        default:
            throw new Error("How did we get here?");
        }
    }

    private static String tempUnitToString(TempUnit unit) {
        switch (unit) {
        case cUnit:
            return "celsius";
        case fUnit:
            return "fahrenheit";
        case kUnit:
            return "kelvin";
        default:
            throw new Error("No really, how did we get here?");
        }
    }

    private static double kelvinTo(TempUnit newUnit, double value) {
        switch (newUnit) {
        case kUnit:
            return value;
        case cUnit:
            return kToC(value);
        case fUnit:
            return kToF(value);
        default:
            throw new Error(
                    "WHAT TYPE OF BUG IS THIS?!? WHAT LOGICAL FLOW OF EVENTS HAD TO HAVE OCCURED FOR THIS BUG TO HAVE OCCURED?!");
        }
    }

    private static double kToF(double x) {
        return (x - 273.15) * 9 / 5 + 32;
    }

    private static double kToC(double x) {
        return x - 273.15;
    }

    private static double fToK(double x) {
        return (x - 32) * 5 / 9 + 273.15;
    }

    private static double cToK(double x) {
        return x + 273.15;
    }
}