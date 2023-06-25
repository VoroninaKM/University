import javax.swing.*;


/**
 * @author islamagiev
 * @version 1.0
 * В классе описываются свойства LoginFrame
 */
public class Login {
    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Форма логина");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}