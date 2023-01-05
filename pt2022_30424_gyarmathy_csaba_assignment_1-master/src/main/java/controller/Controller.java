package controller;

import model.Monomial;
import model.Operations;
import model.Polynomial;
import view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {

    private final UI userInterface;
    private Polynomial pol1;
    private Polynomial pol2;
    private final Operations op;


    //reads the polynomial from the textfield
    public Polynomial readPolTextField(String textField) {
        Polynomial current = new Polynomial();
        String polString = textField;

        try {
            polString = polString.replaceAll("\\s", ""); // \\s means whitespace \\s = " "
            if (polString.charAt(0) == '+') {
                polString = polString.substring(1);
            }

                for (String val : polString.split("((?=\\+)|(?=-))")) {
                double coeff;
                int pow;
                int positionX = val.indexOf("x");
                int positionPow = val.indexOf("^");

                try {
                    coeff = Double.parseDouble(val.substring(0, positionX));
                    pow = Integer.parseInt(val.substring(positionPow + 1));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Wrong input format. Press HELP for more info.");
                    return null;
                }

                if (coeff != 0) {
                    Monomial mon = new Monomial(coeff, pow);
                    current.getPolynomial().add(mon);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wrong input format. Press HELP for more info.");
            return null;
        }
        return current;
    }

    public Controller(UI view) {
        userInterface = view;
        op = new Operations();

        view.addAdditionButtonActionListener(new AdditionButton());
        view.addSubtractButtonActionListener(new SubtractionButton());
        view.addMultiplicationButtonActionListener(new MultiplicationButton());
        view.addDerivationButtonActionListener(new DerivationButton());
        view.addIntegrationButtonActionListener(new IntegrationButton());
        view.addHelpButtonActionListener(new HelpButton());
    }

    //classes to be used in the actionlistener methods
    //ADDITION
    class AdditionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pol1 = readPolTextField(userInterface.getTextField1());
            pol2 = readPolTextField(userInterface.getTextField2());

            Polynomial sum;

            try {
                sum = op.addition(pol1, pol2);
                userInterface.setResultLabel(sum.polToString());
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }
    }

    //SUBTRACTION
    class SubtractionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pol1 = readPolTextField(userInterface.getTextField1());
            pol2 = readPolTextField(userInterface.getTextField2());

            Polynomial result;

            try {
                result = op.subtraction(pol1, pol2);
                userInterface.setResultLabel(result.polToString());
            } catch (Exception ignored) {
            }
        }
    }

    //MULTIPLICATION
    class MultiplicationButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pol1 = readPolTextField(userInterface.getTextField1());
            pol2 = readPolTextField(userInterface.getTextField2());

            Polynomial result;

            try {
                result = op.multiplication(pol1, pol2);
                userInterface.setResultLabel(result.polToString());
            } catch (Exception ignored) {
            }
        }
    }

    //DERIVATION
    class DerivationButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pol1 = readPolTextField(userInterface.getTextField1());

            Polynomial derivated;

            try {
                derivated = op.derivation(pol1);
                userInterface.setResultLabel(derivated.polToString());
            } catch (Exception ignored) {
            }
        }
    }

    //INTEGRATION
    class IntegrationButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pol1 = readPolTextField(userInterface.getTextField1());

            Polynomial integrated;

            try {
                integrated = op.integration(pol1);
                userInterface.setResultLabel(integrated.polToString());
            } catch (Exception ignored) {
            }
        }
    }

    class HelpButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(userInterface,
                    "Please input the operands as follows:  \n" +
                            "     ax^n + bx^(n-1) + cx^(n-2) ...\n\n" +
                            "The coefficients can be positive or negative integers.\n" +
                            "The powers must be positive integers.\n" +
                            "<html><font color='red'>Make sure to also specify the power for x^1 and x^0.</font></html>\n\n" +
                            "Example input: -3x^2 + 4x^1 -2x^0\n\n" +
                            "During subtraction or division, the order is Pol1 - Pol2.\n\n" +
                            "For derivation and integration only fill the first field.");
        }
    }
}
