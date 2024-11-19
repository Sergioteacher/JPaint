/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaint.dibujando;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sergio Teacher
 */
public class Dibujando extends JPanel implements PaletaColorEscuchador {

private JFrame ventanita;
private BufferedImage lienzo;
private Graphics2D g2d;
private PaletaColor miPaleta;

    public Dibujando() {
        super();
        System.out.println("Cargando... Dibujando");
        ventanita = new JFrame("Dibujando ...");
        miPaleta = new PaletaColor(this); //ahora será es escuchador
//        ventanita.setMinimumSize(new Dimension(640,480));
// en vez de determinar un tamaño mínimo, se puede pedir una preferencia 
// y con el gestor .pack  -> determine los tamaños
// redefiniendo a  ->   "ventanita.getPreferredSize();"
//        ventanita.setPreferredSize(new Dimension(640,480));
        ventanita.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//El contenido principal será el propio panel personalizado
//        ventanita.setContentPane(this);
//Ahora que van a ser más objetos necesito un Layout -> BorderLayout viene por defecto
        ventanita.add(this,BorderLayout.CENTER);
        ventanita.add(miPaleta,BorderLayout.EAST);
        ventanita.getContentPane().setBackground(Color.GRAY);

        //capturo el Layout, para darle un pequeño margen
        BorderLayout miLayout = (BorderLayout) ventanita.getContentPane().getLayout();
        miLayout.setHgap(6);

        ventanita.pack();
        ventanita.setLocationRelativeTo(null);

//para que panel eschuche el teclado (nuestro canvas-panel escuche el teclado)
        this.requestFocus();
        iniciando();
    }

    public void mostrar(){
        ventanita.setVisible(true);
    }    

    @Override
    public void colorChanged(Color nuevoColor){
        g2d.setColor(nuevoColor);
        ventanita.getContentPane().setBackground(nuevoColor);
    }


    @Override
    public Dimension getPreferredSize(){
        //redefino.
        return new Dimension(640,480);
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

        MouseAdapter manejadorRaton = new MouseAdapter(){
            private Point puntoEnCurso = new Point();

            @Override
            public void mousePressed(MouseEvent e){
                puntoEnCurso.setLocation(e.getPoint());
//                System.out.println("P-> " + puntoEnCurso.toString());
            }

            @Override
            public void mouseDragged(MouseEvent e){
                g2d.drawLine(puntoEnCurso.x, puntoEnCurso.y, e.getX(), e.getY());
//                System.out.println("   D-> " + e.getPoint().toString());
                puntoEnCurso.setLocation(e.getPoint());
                repaint();
            }
        };
        this.addMouseListener(manejadorRaton);
        this.addMouseMotionListener(manejadorRaton);
// Ahora ha saco una clase anónima
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                if( e.getKeyCode() == KeyEvent.VK_DELETE ){
                //pillo el color, para después usarlo
                Color colorTmp = g2d.getColor();
                g2d.setColor(getBackground());
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.setColor(colorTmp);
                repaint();
            }
//además debes indicar que objeto escucha el teclado
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(lienzo, 0, 0, null);
    }

}
