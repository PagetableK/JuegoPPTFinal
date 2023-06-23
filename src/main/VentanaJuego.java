package main;

import javax.swing.*;
import java.awt.*;

public class VentanaJuego {

    public VentanaJuego(PanelJuego panelJuego)
    {
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(panelJuego);
        jframe.pack();
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
    }

}
