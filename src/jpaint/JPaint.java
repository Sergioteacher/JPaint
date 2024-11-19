/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpaint;

import jpaint.dibujando.Dibujando;
import javax.swing.JOptionPane;
import jpaint.ventanaJFPaint.VentanaJFPaint;

/**
 *
 * @author Sergio Teacher
 */
public class JPaint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Iniciando mi JPaint+-");
        int optionT=0;
        String[] optionesVentana={"A mano","JFPaint"};
        optionT = JOptionPane.showOptionDialog(null, "Control de presentación de imágenes", "Seleccione VENTANA de arranque", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionesVentana, "A mano");

//sólo creo el objto que necesito.
        if( optionT == 0 ){
            System.out.println("Opción: A mano");
            Dibujando Vmano = new Dibujando();
            Vmano.mostrar();
        }else if( optionT == 1 ){
            System.out.println("Opción: JFPaint");
            VentanaJFPaint VFriki= new VentanaJFPaint();
            VFriki.setVisible(true);
        }else{
            System.out.println("Descartado lanzar alguna ventana, se sale ...");
        }

    }
}
