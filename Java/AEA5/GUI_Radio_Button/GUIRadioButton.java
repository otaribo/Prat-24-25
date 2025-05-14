package Java.AEA5.GUI_Radio_Button;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class GUIRadioButton extends JFrame{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public GUIRadioButton(){
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(500,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Un titul completament normal");
        this.iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBounds(0, 0, WIDTH, HEIGHT);

        for(int i = 0;i<5;i++){
            JRadioButton button = new JRadioButton("Boton " + i);
            button.setBounds(20, 30 + i * 40, 100, 30);
            panel.add(button);
        }

        panel.revalidate();
        panel.repaint();
        
    }

    public static void main(String[] args) {
        GUIRadioButton RB = new GUIRadioButton();
        RB.setVisible(true);

    }
}