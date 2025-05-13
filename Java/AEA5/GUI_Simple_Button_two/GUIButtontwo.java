package Java.AEA5.GUI_Simple_Button_two;

import javax.swing.*;

public class GUIButtontwo extends JFrame{
    JButton boton1;
    JButton boton2;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public GUIButtontwo(){
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

        boton1=new JButton("Finalizar");
        boton1.setBounds(HEIGHT/2-50,WIDTH/2-15,100,30);
        panel.add(boton1);
        
        boton2=new JButton("Click Me");
        boton2.setBounds(HEIGHT/4,WIDTH/4,100,30);
        panel.add(boton2);
    }

    public static void main(String[] args) {
        GUIButtontwo ventana = new GUIButtontwo();
        ventana.setVisible(true);
    }
}