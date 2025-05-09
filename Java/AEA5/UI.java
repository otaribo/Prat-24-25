package Java.AEA5;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI extends JFrame{
    JButton boton1;
    public UI(){
        this.setSize(500, 500);
        this.setLocation(500,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Un titulo completamente normal");
        this.iniciarComponentes();
    }
    private void iniciarComponentes(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        this.getContentPane().add(panel);

        JLabel etiqueta = new JLabel();
        etiqueta.setText("Hola");
        panel.add(etiqueta);

        boton1=new JButton("Finalizar");
        boton1.setBounds(300,250,100,30);
        panel.add(boton1);


    }
}
