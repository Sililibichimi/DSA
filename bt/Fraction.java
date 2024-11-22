package DSA.bt;

import java.util.Scanner;

public class Fraction {
    private float numerator ;
    private float denominator ;
    public Fraction ( float numerator , float denominator ) {
        if(denominator == 0){
            throw new IllegalArgumentException ("denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction add ( Fraction c ) {
        float newNumerator = this.numerator * c.denominator + c.numerator * this.denominator;
        float newDenominator = this.denominator * c.denominator;
        return normalize(new Fraction(newNumerator, newDenominator));
    }
    public Fraction minus ( Fraction c ) {
        float newNumerator = this.numerator * c.denominator - c.numerator * this.denominator;
        float newDenominator = this.denominator * c.denominator;
        return normalize(new Fraction(newNumerator, newDenominator));
    }
    public Fraction multi ( Fraction c ) {
        float newNumerator = this.numerator * c.numerator;
        float newDenominator = this.denominator * c.denominator;
        return normalize(new Fraction(newNumerator, newDenominator));
    }
    public Fraction divi ( Fraction c ) {
        if(c.numerator == 0){
            throw new IllegalArgumentException ("Cannot divide by zero");
        }
        float newNumerator = this.numerator * c.denominator;
        float newDenominator = this.denominator * c.numerator;
        return normalize(new Fraction(newNumerator, newDenominator));
    }
    public float gcd(float a, float b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
    public Fraction normalize ( Fraction c ) {
        float UCLN  = gcd(c.numerator, c.denominator);
        return new Fraction(c.numerator/UCLN,c.denominator/UCLN);
    }
    public float getNumerator () {
        return numerator ;
    }
    public float getDenominator () {
        return denominator ;
    }
    @Override
    public String toString () {
        return numerator + "/" + denominator;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("So luong phan so: ");
        int n = sc.nextInt();
        Fraction[] fractions = new Fraction[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Tu so phan so thu " + (i + 1) + " la : ");
            float numerator = sc.nextFloat();
            System.out.print("Mau so phan so thu" + (i + 1)+ "la : ");
            float denominator = sc.nextFloat();
            fractions[i] = new Fraction(numerator,denominator);
        }
        System.out.print("Nhap vi tri thu: ");
        int v = sc.nextInt();
        if(v >= 1 && v <= n){
            System.out.println(fractions[v-1]);
        }else{
            System.out.println("Vi tri khong hop le");
        }
        Fraction sum = new Fraction(0,1);
        for (int i = 0; i < n; i++) {
            sum = sum.add(fractions[i]);
        }
        System.out.println(sum);

        Fraction minus = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            minus = minus.minus(fractions[i]);
        }
        System.out.println(minus);
        Fraction multi = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            multi = multi.multi(fractions[i]);
        }
        System.out.println(multi);
        Fraction divi = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            divi = divi.divi(fractions[i]);
        }
        System.out.println(divi);


    }
}