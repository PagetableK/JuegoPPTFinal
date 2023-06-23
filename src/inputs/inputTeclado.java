package inputs;

import main.PanelJuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                break;
            case KeyEvent.VK_2:
                break;
            case KeyEvent.VK_3:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
