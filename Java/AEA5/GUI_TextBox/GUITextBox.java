package Java.AEA5.GUI_TextBox;

import javax.swing.*;

public class GUITextBox extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public GUITextBox(){
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Un titul completament normal");
        this.iniciarComponentes();
    }
    private void iniciarComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setContentPane(panel);

        JTextField textbox = new JTextField();
        textbox.setBounds(130, 200, 230, 30);
        panel.add(textbox);
        panel.revalidate();
        panel.repaint();
    }

    public static void main(String[] args) {
        GUITextBox ventana = new GUITextBox();
        ventana.setVisible(true);
    }
}
