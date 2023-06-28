package main;

import Audio.ReproductorAudio;

import java.awt.*;

import static utilz.Constantes.JugandoOnO.*;

public class Juego implements Runnable{

    private VentanaJuego ventana;
    private PanelJuego panel;
    private Thread hiloJuego;
    public ReproductorAudio reproductorAudio;


    public Juego()
    {
        reproductorAudio = new ReproductorAudio();
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
        double tiempoPFrame = 1000000000.0 / 175;
        double tiempoPActu = 1000000000.0 / 200;

        long tiempoAnterior = System.nanoTime();

        int frames = 0;
        int actus = 0;
        long ultimoCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long tiempoActual = System.nanoTime();

            deltaU += (tiempoActual - tiempoAnterior) / tiempoPActu;
            deltaF += (tiempoActual - tiempoAnterior) / tiempoPFrame;
            tiempoAnterior = tiempoActual;

            if (deltaU >= 1) {
                if (FueraODentro == 2 && Variable2 == 0)
                {
                    Variable2++;
                    getReproductorAudio().ponerCancion();
                }
                else if (FueraODentro == 3 && Variable2 == 4)
                {
                    Variable2 = 6;
                    getReproductorAudio().reproducirSonidoWin();
                }
                else if (FueraODentro == 3 && Variable2 == 3)
                {
                    Variable2 = 6;
                    getReproductorAudio().reproducirSonidoFail();
                }
                else if (Variable2 == 5)
                {
                    getReproductorAudio().pararSonido();
                    getReproductorAudio().pararCancion();
                }

                actus++;
                deltaU--;
            }

            if (deltaF >= 1) {
                panel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - ultimoCheck >= 1000) {
                ultimoCheck = System.currentTimeMillis();
                frames = 0;
                actus = 0;
            }
        }
    }

    public ReproductorAudio getReproductorAudio() {
        return reproductorAudio;
    }
}
