package model;

import java.util.Iterator;

public class Operations {

    //ADDITION
    public Polynomial addition(Polynomial p1, Polynomial p2) {
        Polynomial sum = p1.copy(p1);

        for (Monomial current : p2.getPolynomial()) {
            int deg = current.getPow();
            double coeff = current.getCoeff();

            Monomial searched = sum.findDeg(deg);
            if (searched == null) {
                sum.getPolynomial().add(current);
            } else {
                double oldCoeff = searched.getCoeff();
                searched.setCoeff(coeff + oldCoeff);
            }
        }

        sum.sortDegree();
        return sum;
    }

    //SUBTRACTION
    public Polynomial subtraction(Polynomial p1, Polynomial p2) {
        Polynomial result = p1.copy(p1);

        for (Monomial current : p2.getPolynomial()) {

            int deg = current.getPow();
            double coeff = current.getCoeff();

            Monomial searched = result.findDeg(deg);
            if (searched == null) {
                Monomial mon = new Monomial(-coeff, deg);
                result.getPolynomial().add(mon);
            } else {
                double oldCoeff = searched.getCoeff();
                searched.setCoeff(oldCoeff - coeff);
            }
        }

        result.sortDegree();
        return result;
    }

    //MULTIPLICATION
    public Polynomial multiplication(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        Polynomial p1Copy = p1.copy(p1);
        Polynomial p2Copy = p2.copy(p2);

        for (Monomial p1Current : p1Copy.getPolynomial()) {
            int p1Pow = p1Current.getPow();
            double p1Coeff = p1Current.getCoeff();

            for (Monomial p2Current : p2Copy.getPolynomial()) {
                int p2Pow = p2Current.getPow();
                int resultPow = p1Pow + p2Pow;

                double p2Coeff = p2Current.getCoeff();
                double resultCoeff = p1Coeff * p2Coeff;

                Monomial searched = result.findDeg(resultPow);
                if (searched == null) {
                    Monomial mon = new Monomial(resultCoeff, resultPow);
                    result.getPolynomial().add(mon);
                } else {
                    double oldCoeff = searched.getCoeff();
                    searched.setCoeff(oldCoeff + resultCoeff);
                }
            }
        }

        result.sortDegree();
        return result;
    }


    //DIVISION
    public Polynomial division(Polynomial p) {
        //didn't work
        return null;
    }

    //DERIVATION
    public Polynomial derivation(Polynomial p) {
        Polynomial derivatedPolynomial = new Polynomial();

        Polynomial copyP = p.copy(p);

        Iterator<Monomial> myIterator = copyP.getPolynomial().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonom = myIterator.next();
            int power = currentMonom.getPow();
            double coeff = currentMonom.getCoeff();

            currentMonom.setCoeff(power * coeff);
            currentMonom.setPow(power - 1);

            derivatedPolynomial.getPolynomial().add(currentMonom);
        }
        derivatedPolynomial.sortDegree();

        return derivatedPolynomial;
    }

    //INTEGRATION
    public Polynomial integration(Polynomial p) {
        Polynomial integratedPolynomial = new Polynomial();

        Polynomial copyP = p.copy(p);

        Iterator<Monomial> myIterator = copyP.getPolynomial().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonom = myIterator.next();

            int power = currentMonom.getPow();
            double coeff = currentMonom.getCoeff();

            currentMonom.setPow(power + 1);
            if (power == -1) {
                currentMonom.setCoeff(coeff);
            } else
                currentMonom.setCoeff(coeff / (power + 1));

            integratedPolynomial.getPolynomial().add(currentMonom);
        }
        integratedPolynomial.sortDegree();
        return integratedPolynomial;
    }

}
