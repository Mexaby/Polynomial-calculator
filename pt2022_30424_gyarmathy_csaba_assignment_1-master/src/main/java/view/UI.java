package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UI extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton subtractButton;
    private JButton addButton;
    private JButton divideButton;
    private JButton multipyButton;
    private JButton derivateButton;
    private JButton integrateButton;


    private JLabel resultLabel;
    private JButton helpButton;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JLabel titleLabel;
    private JLabel resultTextLabel;

    JFrame frame = new JFrame("title");

    //getters and setters for textfields and rresult label
    public void setResultLabel(String result) {
        resultLabel.setText(result);
    }

    public String getTextField1() {
        return textField1.getText();
    }

    public String getTextField2() {
        return textField2.getText();
    }

    //main window initialization
    public UI() {
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 370);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);

    }

    //actionlisteners for the buttons
    public void addAdditionButtonActionListener(final ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void addSubtractButtonActionListener(final ActionListener actionListener) {
        subtractButton.addActionListener(actionListener);
    }

    public void addMultiplicationButtonActionListener(final ActionListener actionListener) {
        multipyButton.addActionListener(actionListener);
    }

    public void addDivisionButtonActionListener(final ActionListener actionListener) {
        divideButton.addActionListener(actionListener);
    }

    public void addDerivationButtonActionListener(final ActionListener actionListener) {
        derivateButton.addActionListener(actionListener);
    }

    public void addIntegrationButtonActionListener(final ActionListener actionListener) {
        integrateButton.addActionListener(actionListener);
    }

    public void addHelpButtonActionListener(final ActionListener actionListener) {
        helpButton.addActionListener(actionListener);
    }
}
