import controller.Controller;
import model.Monomial;
import model.Operations;
import model.Polynomial;
import view.UI;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {
    UI view = new UI();
    Operations op = new Operations();
    Polynomial pol1 = new Polynomial();
    Polynomial pol2 = new Polynomial();
    Controller co = new Controller(view);

    @Test
    public void additionTest(){
        Monomial m1 = new Monomial(4, 5);
        Monomial m2 = new Monomial(-4, 3);
        Monomial m3 = new Monomial(3, 1);
        Monomial m4 = new Monomial(-3, 3);
        Monomial m5 = new Monomial(-3, 0);
        pol1.getPolynomial().add(m1);
        pol1.getPolynomial().add(m2);
        pol1.getPolynomial().add(m3);
        pol2.getPolynomial().add(m4);
        pol2.getPolynomial().add(m5);

        //pol1 = co.readPolTextField("4x^5-4x^3+3x^1");
        //pol2 = co.readPolTextField("-3x^3-3x^0");
        assertEquals("+ 4.0x^5  -7.0x^3 + 3.0x^1  -3.0x^0 ", op.addition(pol1, pol2).polToString());
    }

    @Test
    public void subtractionTest(){
        Monomial m1 = new Monomial(4, 5);
        Monomial m2 = new Monomial(-4, 3);
        Monomial m3 = new Monomial(3, 1);
        Monomial m4 = new Monomial(-3, 3);
        Monomial m5 = new Monomial(-3, 0);
        pol1.getPolynomial().add(m1);
        pol1.getPolynomial().add(m2);
        pol1.getPolynomial().add(m3);
        pol2.getPolynomial().add(m4);
        pol2.getPolynomial().add(m5);

        //pol1 = co.readPolTextField("4x^5-4x^3+3x^1");
        //pol2 = co.readPolTextField("-3x^3-3x^0");
        assertEquals("+ 4.0x^5  -1.0x^3 + 3.0x^1 + 3.0x^0 ", op.subtraction(pol1, pol2).polToString());
    }

    @Test
    public void multiplicationTest(){
        Monomial m1 = new Monomial(4, 5);
        Monomial m2 = new Monomial(-4, 3);
        Monomial m3 = new Monomial(3, 1);
        Monomial m4 = new Monomial(-3, 3);
        Monomial m5 = new Monomial(-3, 0);
        pol1.getPolynomial().add(m1);
        pol1.getPolynomial().add(m2);
        pol1.getPolynomial().add(m3);
        pol2.getPolynomial().add(m4);
        pol2.getPolynomial().add(m5);

        //pol1 = co.readPolTextField("4x^5-4x^3+3x^1");
        //pol2 = co.readPolTextField("-3x^3-3x^0");
        assertEquals(" -12.0x^8 + 12.0x^6  -12.0x^5  -9.0x^4 + 12.0x^3  -9.0x^1 ", op.multiplication(pol1, pol2).polToString());
    }

    @Test
    public void derivationTest(){
        Monomial m1 = new Monomial(4, 5);
        Monomial m2 = new Monomial(-4, 3);
        Monomial m3 = new Monomial(3, 1);
        pol1.getPolynomial().add(m1);
        pol1.getPolynomial().add(m2);
        pol1.getPolynomial().add(m3);

        //pol1 = co.readPolTextField("4x^5-4x^3+3x^1");
        assertEquals("+ 20.0x^4  -12.0x^2 + 3.0x^0 ", op.derivation(pol1).polToString());
    }

    @Test
    public void integrationTest(){
        Monomial m1 = new Monomial(4, 5);
        Monomial m2 = new Monomial(-4, 3);
        Monomial m3 = new Monomial(3, 1);
        pol1.getPolynomial().add(m1);
        pol1.getPolynomial().add(m2);
        pol1.getPolynomial().add(m3);

        //pol1 = co.readPolTextField("4x^5-4x^3+3x^1");
        assertEquals("+ 0.6666666666666666x^6  -1.0x^4 + 1.5x^2 ", op.integration(pol1).polToString());
    }
}

