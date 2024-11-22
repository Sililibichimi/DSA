package DSA.Hw3_22000123_NguyenDucSi.bai1;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of array : ");
        int n = sc.nextInt();

        Fraction[] fractions = new Fraction[n];

        for(int i = 0; i < n; i++) {
            System.out.print("Enter numerator of fraction " + (i + 1) + " : ");
            float numerator = sc.nextFloat();
            System.out.print("Enter denominator of fraction " + (i + 1) + " : ");
            float denominator = sc.nextFloat();
            fractions[i] = new Fraction(numerator, denominator);
        }

        System.out.println("Enter v position: ");
        int v = sc.nextInt();
        System.out.println("Fraction in v position: " + fractions[v - 1].toString());

        System.out.print("Sum of all fractions: ");
        Fraction sum = new Fraction(0, 1);
        for(int i = 0; i < n; i++) {
            sum = sum.add(fractions[i]);
        }
        sum.normalize();
        System.out.println(sum.toString());
        System.out.println();

        System.out.print("Minus of all fractions: ");
        Fraction minus = new Fraction(0, 1);
        for(int i = 0; i < n; i++) {
            minus = minus.minus(fractions[i]);
        }
        minus.normalize();
        System.out.println(minus.toString());
        System.out.println();

        System.out.print("Multiplication of all fractions: ");
        Fraction multi = new Fraction(1, 1);
        for(int i = 0; i < n; i++) {
            multi = multi.multi(fractions[i]);
        }
        multi.normalize();
        System.out.println(multi.toString());
        System.out.println();

        System.out.print("Division of all fractions: ");
        Fraction divi = new Fraction(1, 1);
        for(int i = 0; i < n; i++) {
            divi = divi.divi(fractions[i]);
        }
        divi.normalize();
        System.out.println(divi.toString());
        System.out.println();

        System.out.print("Sort fraction array : ");
        sort(fractions);
        System.out.println(Arrays.toString(fractions));

    }

    public static void sort(Fraction[] fractions) {
        for(int i = 0; i < fractions.length - 1; i++) {
            for(int j = i + 1; j < fractions.length; j++) {
                if(fractions[i].compareTo(fractions[j]) > 0) {
                    Fraction temp = fractions[i];
                    fractions[i] = fractions[j];
                    fractions[j] = temp;
                }
            }
        }
    }
}
