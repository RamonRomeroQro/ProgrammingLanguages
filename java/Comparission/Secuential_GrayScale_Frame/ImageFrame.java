/*------------------------------------------------------------------------------

*

* Actividad de programación: Lenguajes de Programacion - Procesamiento Imagen

* Fecha: 29-Oct-2018

* Autor: A01700318 Ramon Romero

*

*-----------------------------------------------------------------------------*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageFrame {

	public static void showImage(String text, Image image) {
        JFrame frame = new JFrame(text);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
