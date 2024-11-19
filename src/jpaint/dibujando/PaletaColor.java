/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpaint.dibujando;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author Sergio Teacher
 */
public class PaletaColor extends JPanel {

    private PaletaColorEscuchador miEscuchador;
    
    @Override
    public Dimension getPreferredSize(){
        //Para una paleta de 16 colores, en el lado derecho, 2 columnas y 8 filas
        //Y cada botón de 32 pixeles:
        return new Dimension(64,480);
    }


    public PaletaColor(PaletaColorEscuchador miEscuchador) {
        super();
        this.miEscuchador = miEscuchador;
        iniciando();
    }
private void iniciando(){
    System.out.println("Creando miPaleta de colores");
    //Para que se note las dimensiones de la paleta
    this.setBackground(Color.GRAY);
    MouseAdapter manejadorRaton = new MouseAdapter(){
        @Override
        public void mousePressed(MouseEvent e){
            //implimenta el click del botón virtual
            int n=0;
            if( e.getX() < 32 ){
                n= ((e.getY()/32)*2);
            }else{
                n= ((e.getY()/32)*2 + 1);
            }
//                System.out.println("e-> "+e.getPoint().toString());
            if(n<16){
                miEscuchador.colorChanged(obtenColor(n));
//                System.out.println("n-> "+n);
            }
        }
    };
    this.addMouseListener(manejadorRaton);
}

private Color obtenColor(int nColor){
//básicamente es un método que a 1 entero da 3 enteros, sin reptir tuplas.
    //Fijo el tamaño a repartir paleta
    final int nColores=16;
    int aRepartir=(nColores-7)/3; //3 -> lo óptimo es que sea impar
    int r=0,g=0,b=0,i=0;
    //Control de errores a lo bestia
    if(nColor <0) nColor=0;
    if(nColor >16) nColor=16;

    switch (nColor){
        case 0:
            r=g=b=0;
            break;
        case 1:
            r=g=b=85;
            break;
        case 2:
            r=g=b=170;
            break;
        case 3:
            r=g=b=255;
            break;
        case 4:
            r=255;
            g=b=0;
            break;
        case 5:
            g=255;
            r=b=0;
            break;
        case 6:
            b=255;
            g=r=0;
            break;
        default:
            // el resto de mezclas de colores (orden psicodélico)
            if( 7 <= nColor && nColor < (7+aRepartir) ){
                //1º 7 < nColor    nColor < 7+3=10       // 7 8 9
                i = nColor - 6;
                r=255-((255/(aRepartir+1))*i);
                g=(255/(aRepartir+1))*i;
                b=0;
            }else if( (7+aRepartir) <= nColor && nColor < (7+2*aRepartir) ){
                //2º 10 <= nColor    nColor < 7+2*3=13    // 10 11 12
                i = nColor - 9;
                r=255-((255/(aRepartir+1))*i);
                b=(255/(aRepartir+1))*i;
                g=0;
            }else if( (6+2*aRepartir) <= nColor && nColor < nColores ){
                //3º 13 <= nColor    nColor < 16         // 13 14 15
                i = nColor - 12;
                g=255-((255/(aRepartir+1))*i);
                b=(255/(aRepartir+1))*i;
                r=0;
            }
    }
//    System.out.println("r:" + r + " g:" + g + " b:" + b);
return new Color(r,g,b);
}

@Override
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int n=0; n<16; n++){
    Color color = obtenColor(n);
    g.setColor(color);
    g.fillRect((n%2)*32, (n/2)*32, 32, 32);
    }
}

}
