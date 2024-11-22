package DSA.Hw3_22000123_NguyenDucSi.bai1;

public class Fraction implements Comparable<Fraction> {
    private float numerator;
    private float denominator;

    public Fraction (float numerator, float denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Denominator can't be 0");
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public float gcd(float a, float b) {
        int scale = 1000000;
        int intA = (int) (a * scale);
        int intB = (int) (b * scale);

        while (intB != 0) {
            int temp = intB;
            intB = intA % intB;
            intA = temp;
        }

        return (float) intA / scale;
    }

    public Fraction add(Fraction c) {
        if(this.getDenominator() == c.getDenominator()) {
            return new Fraction(this.getNumerator() + c.getNumerator(), this.getDenominator());
        }
        float temp = gcd(this.getDenominator(), c.getDenominator());

        return new Fraction(this.getNumerator() * (c.getDenominator() / temp) + c.getNumerator() * (this.getDenominator() / temp), this.getDenominator() * (c.getDenominator() / temp));
    }

    public Fraction minus(Fraction c) {
        if(this.getDenominator() == c.getDenominator()) {
            return new Fraction(this.getNumerator() - c.getNumerator(), this.getDenominator());
        }
        float temp = gcd(this.getDenominator(), c.getDenominator());

        return new Fraction(this.getNumerator() * (c.getDenominator() / temp) - c.getNumerator() * (this.getDenominator() / temp), this.getDenominator() * (c.getDenominator() / temp));
    }

    public Fraction multi(Fraction c) {
        float nume = this.getNumerator() * c.getNumerator();
        float deno = this.getDenominator() * c.getDenominator();
        float temp = gcd(nume, deno);

        return new Fraction(nume / temp, deno / temp);
    }

    public Fraction divi(Fraction c) {
        if(c.numerator == 0) {
            throw new IllegalArgumentException("Can't divide by 0");
        }

        Fraction temp = new Fraction(c.getDenominator(), c.getNumerator());

        return this.multi(temp);
    }

    public float getNumerator() {
        return numerator;
    }

    public void setNumerator(float numerator) {
        this.numerator = numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setDenominator(float denominator) {
        this.denominator = denominator;
    }

    public void normalize() {
        float temp = gcd(this.getNumerator(), this.getDenominator());
        this.setNumerator(this.getNumerator() / temp);
        this.setDenominator(this.getDenominator() / temp);
    }

    public int compareTo(Fraction c) {
        float temp = this.minus(c).getNumerator();
        if(temp > 0) {
            return 1;
        } else if(temp < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        boolean isNegative = false;
        if(this.getDenominator() * this.getNumerator() < 0) {
            isNegative = true;
        }
        return (isNegative ? "-" : "") + Math.abs(this.getNumerator()) + "/" + Math.abs(this.getDenominator());
    }
}
