package inputs;

import Audio.ReproductorAudio;
import main.Juego;
import main.PanelJuego;
import utilz.Constantes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.temporal.ValueRange;

import static utilz.Constantes.JugandoOnO.*;
import static utilz.Constantes.ConstantesJugador.*;

public class inputTeclado implements KeyListener {

    private PanelJuego panelJuego;
    public inputTeclado(PanelJuego panelJuego)
    {
        this.panelJuego = panelJuego;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_1:
                if(FueraODentro == 2)
                {
                    SeleccionJugador = 1;
                }
                break;
            case KeyEvent.VK_2:
                if(FueraODentro == 2)
                {
                    SeleccionJugador = 2;
                }
                break;
            case KeyEvent.VK_3:
                if(FueraODentro == 2)
                {
                    SeleccionJugador = 3;
                }
                break;
            case KeyEvent.VK_ESCAPE:
                inicioOnO = 0;
                Variable1 = 0;
                FueraODentro = 0;
                Constantes.Puntuaciones.PuntuacionComputadora = 0;
                Constantes.Puntuaciones.PuntuacionJugador = 0;
                SeleccionJugador = 0;
                Variable2 = 5;
                break;
            case KeyEvent.VK_SPACE:
                if (FueraODentro == 1)
                {
                    FueraODentro = 2;
                    Variable2 = 0;
                }
                else if (FueraODentro == 3)
                {
                    inicioOnO = 0;
                    Variable1 = 0;
                    FueraODentro = 0;
                    Constantes.Puntuaciones.PuntuacionComputadora = 0;
                    Constantes.Puntuaciones.PuntuacionJugador = 0;
                    SeleccionJugador = 0;
                    Variable2 = 5;
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
