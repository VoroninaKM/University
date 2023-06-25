import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bitwise extends JFrame implements ActionListener {

    Container container = getContentPane();
    String[] methods = {"&", "|", "^", "<<", ">>"};

    JTextField aTextField = new JTextField();
    JTextField bTextField = new JTextField();
    JTextField negationTextField = new JTextField();

    JLabel value = new JLabel("");
    JLabel quantity = new JLabel("");
    JLabel negationLabel = new JLabel("~");


    JButton abJButton = new JButton("Выполнить");
    JButton negationJButton = new JButton("Выполнить");
    JComboBox methodsComboBox = new JComboBox(methods);


    public Bitwise() throws HeadlessException {
        setLayoutManager();
        setLocationAndSize();
        addActionEvent();
        addComponentsToContainer();
    }

    public void addActionEvent() {
        methodsComboBox.addActionListener(this);
        abJButton.addActionListener(this);
        negationJButton.addActionListener(this);
    }

    public void addComponentsToContainer() {
        container.add(methodsComboBox);
        container.add(aTextField);
        container.add(bTextField);
        container.add(abJButton);
        container.add(negationTextField);
        container.add(negationLabel);
        container.add(negationJButton);
        container.add(value);
        container.add(quantity);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        methodsComboBox.setBounds(165, 50, 70, 50);
        aTextField.setBounds(65, 63, 100, 20);
        bTextField.setBounds(235, 63, 100, 20);
        abJButton.setBounds(150, 100, 100, 20);
        value.setBounds(70, 40, 100, 20);
        quantity.setBounds(240, 40, 100, 20);
        negationTextField.setBounds(165, 150, 70, 20);
        negationLabel.setBounds(149, 150, 100, 20);
        negationJButton.setBounds(150, 180, 100, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == methodsComboBox){
                if (methodsComboBox.getSelectedItem() == "<<" || methodsComboBox.getSelectedItem() == ">>"){
                    value.setText("Значение");
                    quantity.setText("Количество");
                } else {
                    value.setText("");
                    quantity.setText("");
                }
            }
            else if (e.getSource() == abJButton) {
                if (!aTextField.getText().equals("") && !bTextField.getText().equals("")) {
                    int parseIntA = Integer.parseInt(aTextField.getText());
                    int parseIntB = Integer.parseInt(bTextField.getText());
                    String aBinary = Integer.toBinaryString(parseIntA);
                    String bBinary = Integer.toBinaryString(parseIntB);
                    String binary = "Входные данные: \n" + "В десятичной: " + parseIntA + ", в двоичной: " + aBinary + "\n" +
                            "В десятичной: " + parseIntB + ", в двоичной: " + bBinary + "\n" +
                            "Результат: \n";
                    if (methodsComboBox.getSelectedItem() == "&") {
                        int logicalAnd = parseIntA & parseIntB;
                        JOptionPane.showMessageDialog(this, binary + "В десятичной форме: "+ Integer.toString(logicalAnd) + "\nВ двоичной форме: " + Integer.toBinaryString(logicalAnd), "Результат", JOptionPane.INFORMATION_MESSAGE);
                    } else if (methodsComboBox.getSelectedItem() == "|") {
                        int logicalOr = parseIntA | parseIntB;
                        JOptionPane.showMessageDialog(this, binary +"В десятичной форме: "+ Integer.toString(logicalOr) + "\nВ двоичной форме: " + Integer.toBinaryString(logicalOr), "Результат", JOptionPane.INFORMATION_MESSAGE);
                    } else if (methodsComboBox.getSelectedItem() == "^") {
                        int exclusiveOr = parseIntA ^ parseIntB;
                        JOptionPane.showMessageDialog(this, binary + "В десятичной форме: "+ Integer.toString(exclusiveOr) + "\nВ двоичной форме: " + Integer.toBinaryString(exclusiveOr), "Результат", JOptionPane.INFORMATION_MESSAGE);
                    } else if (methodsComboBox.getSelectedItem() == "<<") {
                        int leftShift = parseIntA << parseIntB;
                        JOptionPane.showMessageDialog(this, "В десятичной форме: "+ Integer.toString(leftShift) + "\nВ двоичной форме: " + Integer.toBinaryString(leftShift), "Результат", JOptionPane.INFORMATION_MESSAGE);

                    } else if (methodsComboBox.getSelectedItem() == ">>") {
                        int rightShift = parseIntA >> parseIntB;
                        JOptionPane.showMessageDialog(this, "В десятичной форме: "+ Integer.toString(rightShift) + "\nВ двоичной форме: " + Integer.toBinaryString(rightShift), "Результат", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else if (e.getSource() == negationJButton) {
                if (!negationTextField.getText().equals("")){
                    System.out.println(Integer.toBinaryString(Integer.parseInt(negationTextField.getText())));
                    System.out.println(Integer.toBinaryString(~Integer.parseInt(negationTextField.getText())));
                    System.out.println(~Integer.parseInt(negationTextField.getText()));
                    int parseNegation = Integer.parseInt(negationTextField.getText());
                    String binaryNegation = Integer.toBinaryString(parseNegation);
                    String binary = "Входные данные: \nВ десятичной: " + parseNegation + "\n" +
                            "В двоичной: " + binaryNegation + "\n" +
                            "Результат: \n";
                    JOptionPane.showMessageDialog(this, binary + "В десятичной форме: "+ Integer.toString(~parseNegation) + "\nВ двоичной форме: " + Integer.toBinaryString(~parseNegation), "Результат", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(this, "Некорректно введены данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
