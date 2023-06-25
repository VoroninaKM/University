import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


/** Класс служит для отображения главного окна и хранит в себе всю логику
 @author datebackk
 @version 1.0
 */
class Calculator extends JFrame implements ActionListener {
    static JFrame frame;

    static JTextField textField;

    String s0, s1, s2;

    Calculator() {
        s0 = s1 = s2 = "";
    }

    /** Главный метод программы. Создает объекты: frame, c, textField и кнопки и устанавливает для них значения свойств,
     *  а затем устанавливаает для них event listeners и добавляет на главный экран
     @params args Параметры командной строки
     */
    public static void main(String[] args) {
        frame = new JFrame("Калькулятор");

        Calculator c = new Calculator();

        textField = new JTextField(16);

        textField.setEditable(false);

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        beq1 = new JButton("=");

        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");

        be = new JButton(".");

        JPanel p = new JPanel();

        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);

        p.add(textField);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);

        p.setBackground(Color.blue);

        frame.add(p);

        frame.setSize(350, 230);
        frame.setResizable(false);
        frame.show();
    }
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        System.out.println(s);

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            textField.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";

            textField.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {
            double te = switch (s1) {
                case "+" -> (Double.parseDouble(s0) + Double.parseDouble(s2));
                case "-" -> (Double.parseDouble(s0) - Double.parseDouble(s2));
                case "/" -> (Double.parseDouble(s0) / Double.parseDouble(s2));
                default -> (Double.parseDouble(s0) * Double.parseDouble(s2));
            };

            textField.setText(s0 + s1 + s2 + "=" + te);

            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            else {
                double te = switch (s1) {
                    case "+" -> (Double.parseDouble(s0) + Double.parseDouble(s2));
                    case "-" -> (Double.parseDouble(s0) - Double.parseDouble(s2));
                    case "/" -> (Double.parseDouble(s0) / Double.parseDouble(s2));
                    default -> (Double.parseDouble(s0) * Double.parseDouble(s2));
                };

                s0 = Double.toString(te);

                s1 = s;

                s2 = "";
            }
            textField.setText(s0 + s1 + s2);
        }
    }
}