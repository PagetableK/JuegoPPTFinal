package main;

import java.awt.*;

public class Juego implements Runnable{

    private VentanaJuego ventana;
    private PanelJuego panel;
    private Thread hiloJuego;
    private  final int PONER_FPS = 200;
    public Juego()
    {
        panel = new PanelJuego();
        panel.setBackground(Color.decode("#88ceeb"));
        ventana = new VentanaJuego(panel);
        panel.requestFocus();
        IniciarLoopJuego();
    }

    private void IniciarLoopJuego()
    {
        hiloJuego = new Thread(this);
        hiloJuego.start();
    }

    @Override
    public void run() {
        double tiempoPFrame = 1000000000.0 / PONER_FPS;
        long ultimoFrame = System.nanoTime();
        long ahora = System.nanoTime();
        int frames = 0;
        long ultimaR = System.currentTimeMillis();

        while (true)
        {
            ahora = System.nanoTime();
            if (ahora - ultimoFrame >= tiempoPFrame)
            {
                panel.repaint();
                ultimoFrame = ahora;
                frames++;
            }

            if(System.currentTimeMillis() - ultimaR >= 1000)
            {
                ultimaR = System.currentTimeMillis();
//                System.out.println("FPS: "+frames);
                frames = 0;
            }
        }
    }
}
