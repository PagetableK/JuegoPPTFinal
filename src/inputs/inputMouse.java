package inputs;

import main.PanelJuego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class inputMouse implements MouseListener {

    private PanelJuego panelJuego;

    public inputMouse(PanelJuego panelJuego)
    {
        this.panelJuego = panelJuego;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int panelWidth = 1000;
        int panelHeight = 600;
        int buttonWidth = 200; // Ancho del botón
        int buttonHeight = 100; // Alto del botón

        // Verificar si el clic está dentro del área específica
        int x1 = (panelWidth - buttonWidth) / 2;// Coordenada x de la esquina superior izquierda del área
        int y1 = (panelHeight - buttonHeight) / 2; // Coordenada y de la esquina superior izquierda del área
        int x2 = x1 + buttonWidth;// Coordenada x de la esquina inferior derecha del área
        int y2 = y1 + buttonHeight;// Coordenada y de la esquina inferior derecha del área

        if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {

            System.out.println("¡Clic dentro del área específica!");

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
