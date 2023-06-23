package inputs;

import main.PanelJuego;
import utilz.Constantes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static utilz.Constantes.JugandoOnO.*;
import static utilz.Constantes.ConstantesJugador.*;

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

        int botonStartAncho = 281; // Ancho del botón
        int botonStartAlto = 188; // Alto del botón
        int botonesAnchos = 187;
        int botonesAltos = 125;
        int botonReiniciarAncho = 200;
        int botonReiniciarAlto = 125;

        // Verificar si el clic está dentro del área específica
//        int EsIzStartx = (panelWidth - botonStartAncho) / 2;// Coordenada x de la esquina superior izquierda del área
//        int EsIzStarty = (panelHeight - botonStartAlto) / 2; // Coordenada y de la esquina superior izquierda del área
        int EsIzStartx = 375;
        int EsIzStarty = 200;
        int EsDeStartx = EsIzStartx + botonStartAncho;// Coordenada x de la esquina inferior derecha del área
        int EsDeStarty = EsIzStarty + botonStartAlto;// Coordenada y de la esquina inferior derecha del área

        int EsIzPiedrax = 200;
        int EsIzPiedray = 30;
        int EsDePiedrax = EsIzPiedrax + botonesAnchos;
        int EsDePiedray = EsIzPiedray + botonesAltos;

        int EsIzPapelx = 415;
        int EsIzPapely = 30;
        int EsDePapelx = EsIzPapelx + botonesAnchos;
        int EsDePapely = EsIzPapely + botonesAltos;

        int EsIzTijerax = 624;
        int EsIzTijeray = 30;
        int EsDeTijerax = EsIzTijerax + botonesAnchos;
        int EsDeTijeray = EsIzTijeray + botonesAltos;

        int EsIzReiniciarx = 350;
        int EsIzReiniciary = 200;
        int EsDeReiniciarx = EsIzReiniciarx + botonStartAncho;
        int EsDeReiniciary = EsIzReiniciary + botonStartAlto;

        if (x >= EsIzStartx && x <= EsDeStartx && y >= EsIzStarty && y <= EsDeStarty && FueraODentro == 1) {
            FueraODentro = 2;
        }
        else if(x >= EsIzPiedrax && x <= EsDePiedrax && y >= EsIzPiedray && y <= EsDePiedray && FueraODentro == 2)
        {
//            System.out.println("Piedra");
            SeleccionJugador = 1;
        }
        else if(x >= EsIzPapelx && x <= EsDePapelx && y >= EsIzPapely && y <= EsDePapely && FueraODentro == 2)
        {
            SeleccionJugador = 2;
        }
        else if(x >= EsIzTijerax && x <= EsDeTijerax && y >= EsIzTijeray && y <= EsDeTijeray && FueraODentro == 2)
        {
//            System.out.println("Tijera");
            SeleccionJugador = 3;
        }
        else if(x >= EsIzReiniciarx && x <= EsDeReiniciarx && y >= EsIzReiniciary && y <= EsDeReiniciary && FueraODentro == 3)
        {
            inicioOnO = 0;
            Variable1 = 0;
            FueraODentro = 0;
            Constantes.Puntuaciones.PuntuacionComputadora = 0;
            Constantes.Puntuaciones.PuntuacionJugador = 0;
            SeleccionJugador = 0;
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
