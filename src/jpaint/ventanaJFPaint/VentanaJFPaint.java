/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jpaint.ventanaJFPaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Sergio Teacher
 */
public class VentanaJFPaint extends javax.swing.JFrame implements ActionListener {

PanelLienzo PLienzo;

    /**
     * Creates new form VentanaFriki
     */
    public VentanaJFPaint() {
        System.out.println("Cargando ventana JFPaint");
        PLienzo = new PanelLienzo();
        PLienzo.setBackground(Color.BLACK);
        //PLienzo.setPreferredSize(new Dimension(640,480));
        this.getContentPane().add(PLienzo, java.awt.BorderLayout.CENTER);
        initComponents();
//        setBounds(0,0,640,480);
        this.setLocationRelativeTo(null);
        escuchadores();
    }

private void escuchadores(){
btnC1.addActionListener(this);
btnC2.addActionListener(this);
btnC3.addActionListener(this);
btnC4.addActionListener(this);
btnC5.addActionListener(this);
btnC6.addActionListener(this);
btnC7.addActionListener(this);
btnC8.addActionListener(this);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLateral = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnC1 = new javax.swing.JButton();
        btnC2 = new javax.swing.JButton();
        btnC6 = new javax.swing.JButton();
        btnC7 = new javax.swing.JButton();
        txtETC1 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        btnC3 = new javax.swing.JButton();
        btnC4 = new javax.swing.JButton();
        btnC5 = new javax.swing.JButton();
        btnC8 = new javax.swing.JButton();
        txtETC2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana JFPaint");

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        btnC1.setBackground(new java.awt.Color(0, 0, 0));
        btnC1.setText("N1");
        btnC1.setFocusable(false);
        btnC1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnC1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnC1);

        btnC2.setBackground(new java.awt.Color(170, 170, 170));
        btnC2.setForeground(new java.awt.Color(170, 170, 170));
        btnC2.setText("N3");
        btnC2.setFocusable(false);
        btnC2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnC2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnC2);

        btnC6.setBackground(new java.awt.Color(255, 0, 0));
        btnC6.setForeground(new java.awt.Color(255, 0, 0));
        btnC6.setText("R1");
        btnC6.setFocusable(false);
        btnC6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnC6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnC6);

        btnC7.setBackground(new java.awt.Color(0, 0, 255));
        btnC7.setForeground(new java.awt.Color(0, 0, 255));
        btnC7.setText("A1");
        btnC7.setFocusable(false);
        btnC7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnC7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnC7);

        txtETC1.setText("...");
        jToolBar1.add(txtETC1);

        jPanelLateral.add(jToolBar1);

        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);

        btnC3.setBackground(new java.awt.Color(85, 85, 85));
        btnC3.setForeground(new java.awt.Color(85, 85, 85));
        btnC3.setText("N2");
        btnC3.setFocusable(false);
        btnC3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnC3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnC3);

        btnC4.setBackground(new java.awt.Color(255, 255, 255));
        btnC4.setForeground(new java.awt.Color(255, 255, 255));
        btnC4.setText("B1");
        btnC4.setFocusable(false);
        btnC4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnC4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnC4);

        btnC5.setBackground(new java.awt.Color(0, 255, 0));
        btnC5.setForeground(new java.awt.Color(0, 255, 0));
        btnC5.setText("V1");
        btnC5.setFocusable(false);
        btnC5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnC5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnC5);

        btnC8.setBackground(new java.awt.Color(170, 85, 0));
        btnC8.setForeground(new java.awt.Color(170, 85, 0));
        btnC8.setText("V2");
        btnC8.setFocusable(false);
        btnC8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnC8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnC8);

        txtETC2.setText("...");
        jToolBar2.add(txtETC2);

        jPanelLateral.add(jToolBar2);

        getContentPane().add(jPanelLateral, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnC1;
    private javax.swing.JButton btnC2;
    private javax.swing.JButton btnC3;
    private javax.swing.JButton btnC4;
    private javax.swing.JButton btnC5;
    private javax.swing.JButton btnC6;
    private javax.swing.JButton btnC7;
    private javax.swing.JButton btnC8;
    private javax.swing.JPanel jPanelLateral;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel txtETC1;
    private javax.swing.JLabel txtETC2;
    // End of variables declaration//GEN-END:variables

@Override
public void actionPerformed(ActionEvent e){
    System.out.println("e-> " + e.getActionCommand());
switch (e.getActionCommand()){
    case "N1":
        jPanelLateral.setBackground(Color.BLACK);
        break;
    case "N2":
        jPanelLateral.setBackground(new Color(85,85,85));
        break;
    case "N3":
        jPanelLateral.setBackground(new Color(170,170,170));
        break;
    case "R1":
        jPanelLateral.setBackground(Color.RED);
        break;
    case "A1":
        jPanelLateral.setBackground(Color.BLUE);
        break;
    case "B1":
        jPanelLateral.setBackground(Color.WHITE);
        break;
    case "V1":
        jPanelLateral.setBackground(Color.GREEN);
        break;
    case "V2":
        jPanelLateral.setBackground(new Color(170,85,0));
        break;
    default:
        System.out.println("No establecida acción en: "+e.getActionCommand());
}
}


}


class PanelLienzo extends JPanel implements MouseListener {
private BufferedImage lienzo;
private Graphics2D g2d;
private Point puntoEnCurso;

    public PanelLienzo() {
        super();
        puntoEnCurso = new Point();
        System.out.println("Cargando... Panel Lienzo");
        iniciando();
    }

private void iniciando(){
    setBackground(Color.BLACK);
    lienzo = new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
    g2d = lienzo.createGraphics();
    //pillas el color
    g2d.setBackground(getBackground());  //básicamente lo que ya tiene
    //por defecto la imagen viene en color negro
    //pintando un rectángulo controlas su color
    g2d.setColor(getBackground());
    g2d.fillRect(0, 0, 640, 480);

g2d.setColor(Color.GREEN);
g2d.setStroke(new BasicStroke(2));
//g2d.drawOval(200, 300, 100, 150);

this.addMouseListener(this);
}

@Override
public void mousePressed(MouseEvent e){
    puntoEnCurso.setLocation(e.getPoint());
    System.out.println("P-> " + puntoEnCurso.toString());
}
public void mouseClicked(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}



/**
* Redefino el método para que pinte
*/
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(lienzo, 0, 0, null);
    }

/**
* Redefino el método, estableciendo un tamaño base
*/
    @Override
    public Dimension getPreferredSize(){
        //redefino.
        return new Dimension(640,480);
    }

}