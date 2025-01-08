package Java.UF1.AEA3.Probes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz_grafica extends JFrame{
  
  private JPanel panelPrincipal;
  private CardLayout cardLayout;
  
  public Interfaz_grafica(){
    this.setTitle("Menú principal");
    this.setSize(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cardLayout = new CardLayout();
    panelPrincipal = new JPanel(cardLayout);
  }
  public static void main(String[] arg){
    new Interfaz_grafica();
  }
}