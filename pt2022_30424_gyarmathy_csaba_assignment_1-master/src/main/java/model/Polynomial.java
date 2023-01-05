package model;

import java.util.ArrayList;

public class Polynomial {
    ArrayList<Monomial> polynomial = new ArrayList<>();

    public Polynomial() {
    }

    public Polynomial(ArrayList<Monomial> polynomial) {
        this.polynomial = polynomial;
    }

    public ArrayList<Monomial> getPolynomial() {
        return polynomial;
    }

    //sorts the polynomial by degree
    public void sortDegree() {
        polynomial.sort((m1, m2) -> Integer.compare(m2.getPow(), m1.getPow()));
    }

    //just prints the polynomial in the console
    //used for initial testing
    public void printPolynomial() {
        for (Monomial currentMonom : this.getPolynomial()) {
            currentMonom.printMonomial();
        }
        System.out.println(" ");
    }

    //finds the degree
    public Monomial findDeg(int deg) {
        Monomial result = null;

        for (Monomial current : this.getPolynomial()) {
            if (current.getPow() == deg)
                result = current;
        }
        return result;
    }

    //copies the given polynomial into another
    public Polynomial copy(Polynomial p) {
        Polynomial copy = new Polynomial();

        for (Monomial current : p.getPolynomial()) {
            int pow = current.getPow();
            double coeff = current.getCoeff();

            Monomial mon = new Monomial(coeff, pow);
            copy.getPolynomial().add(mon);
        }
        return copy;
    }

    //creates a string from the polynomial type object for easy printing
    public String polToString() {
        StringBuilder builder = new StringBuilder();

        for (Monomial current : this.getPolynomial()) {
            builder.append(current.monToString());
        }
        return builder.toString();
    }
}
