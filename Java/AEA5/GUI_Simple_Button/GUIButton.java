package Java.AEA5.GUI_Simple_Button;

import javax.swing.*;

public class GUIButton extends JFrame{
    JButton boton1;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public GUIButton(){
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(500,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Un titul completament normal");
        this.iniciarComponentes();
    }
    private void iniciarComponentes(){
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setBounds(0, 0, WIDTH, HEIGHT);

        boton1=new JButton("Finalizar");
        boton1.setBounds(HEIGHT/2,WIDTH/2,100,30);
        panel.add(boton1);
    }

    public static void main(String[] args) {
        GUIButton ventana = new GUIButton();
        ventana.setVisible(true);
    }
}