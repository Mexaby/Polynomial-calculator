package model;

public class Monomial {
    double coeff;
    int pow;

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public Monomial(double coeff, int pow) {
        this.coeff = coeff;
        this.pow = pow;
    }
    
    //prints the monomial
    public void printMonomial() {
        if (coeff > 0)
            System.out.println("+" + coeff + "x^" + pow + " ");
        else if (coeff < 0)
            System.out.print(coeff + "x^" + pow + " ");
        else
            System.out.print("+" + 0 + " ");

    }
    
    //transforms monomial into printable string
    public String monToString() {
        StringBuilder sBuilder = new StringBuilder();

        if (coeff > 0)
            return sBuilder.append("+ ").append(coeff).append("x^").append(pow).append(" ").toString();
        else if (coeff < 0)
            return sBuilder.append(" ").append(coeff).append("x^").append(pow).append(" ").toString();
        else
            return "";
    }
}
