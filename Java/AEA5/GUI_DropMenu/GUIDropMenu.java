package Java.AEA5.GUI_DropMenu;

import javax.swing.*;

public class GUIDropMenu extends JFrame {
    JButton show;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public GUIDropMenu(){
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

        JButton showButton = new JButton("Show");
        showButton.setBounds(300, 200, 70, 30);
        panel.add(showButton);

        String[] personas = {"Persona 1","Persona 2", "Persona 3", "Persona 4"};
        JComboBox<String> dropmenu = new JComboBox<String>(personas);
        dropmenu.setBounds(80, 200, 200, 30);
        panel.add(dropmenu);
        panel.revalidate();
        panel.repaint();
    
        showButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel,"Has seleccionat " + dropmenu.getSelectedItem(),"Seleccio",JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
        GUIDropMenu ventana = new GUIDropMenu();
        ventana.setVisible(true);
    }
}
