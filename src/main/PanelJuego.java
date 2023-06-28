package main;

import inputs.inputMouse;
import inputs.inputTeclado;
import utilz.Constantes;
import utilz.ProgramaLogica;
//import inputs.inputMouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static utilz.Constantes.ConstantesJugador.*;
import static utilz.Constantes.JugandoOnO.*;
import static utilz.Constantes.Puntuaciones.*;

public class PanelJuego extends JPanel{

    protected  Juego juego;
    private float xDelta = 650, yDelta =250, xDelta1 = 5;
    private BufferedImage img, imgVolteada,botonesimg, puntuacionimg, YouWYLimg, Unosimg;
    private BufferedImage [][] animaciones, animacionesReves, botonesOpcion;
    private BufferedImage [] puntuaciones, YouWYL, UnosAni;
    private int aniTick, Ganador, indiceUnos, tickUnos, variable2, variable3, seleccionPrograma, cambioMano, conteoSeleccion, aniIndice, aniIndiceReves = 2, aniVelocidad, aniTick1, aniTick2, parpadeo, variableTiempo1 = 200, variableTiempo2 =300;
    private int accionJugador = INICIANDO;



    public PanelJuego()
    {
        addKeyListener(new inputTeclado(this));
        ponerTPanel();
        importarImg();
        importarImgReves();
        importarBotonesImg();
        importarPuntuaciones();
        importarYouWYL();
        importarUnos();
        cargarAnimaciones();
        cargarAnimacionesReves();
        cargarBotones();
        cargarPuntuacion();
        cargarYWYL();
        cargarUnos();
    }

    private void cargarPuntuacion() {
        puntuaciones = new BufferedImage[9];

        for (int i= 0; i<puntuaciones.length; i++)
            puntuaciones[i] = puntuacionimg.getSubimage(i*61, 0, 61, 10);
    }
    private void cargarUnos() {
        UnosAni = new BufferedImage[6];

        for (int i= 0; i<UnosAni.length; i++)
            UnosAni[i] = Unosimg.getSubimage(i*17, 0, 17, 33);
    }
    private void cargarAnimaciones() {
        animaciones = new BufferedImage[5][7];

        for (int j = 0; j < animaciones.length; j++)
            for (int i= 0; i<animaciones[j].length; i++)
                animaciones[j][i] = img.getSubimage(i*34, j*20, 34, 20);
    }
    private void cargarBotones() {
        botonesOpcion = new BufferedImage[3][3];

        for (int j = 0; j < botonesOpcion.length; j++)
            for (int i= 0; i<botonesOpcion.length; i++)
                botonesOpcion[j][i] = botonesimg.getSubimage(i*48, j*30, 48, 30);
        addMouseListener(new inputMouse(this));
    }

    private void cargarYWYL() {
        YouWYL = new BufferedImage[2];

        for (int i= 0; i<YouWYL.length; i++)
            YouWYL[i] = YouWYLimg.getSubimage(0, i*21, 121, 21);
    }

    private void cargarAnimacionesReves() {
        animacionesReves = new BufferedImage[5][7];

        for (int j = 0; j < animacionesReves.length; j++)
            for (int i= 0; i<animacionesReves[j].length; i++)
                animacionesReves[j][i] = imgVolteada.getSubimage(i*34, j*20, 34, 20);
    }
    private void importarImg() {
        InputStream is = getClass().getResourceAsStream("/rppc.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void importarImgReves() {
        InputStream is = getClass().getResourceAsStream("/rppci.png");

        try {
            imgVolteada = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void importarBotonesImg() {
        InputStream is = getClass().getResourceAsStream("/botonesppt.png");

        try {
            botonesimg = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void importarPuntuaciones() {
        InputStream is = getClass().getResourceAsStream("/puntuaciones.png");

        try {
            puntuacionimg = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void importarUnos() {
        InputStream is = getClass().getResourceAsStream("/unos1.png");

        try {
            Unosimg = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void importarYouWYL() {
        InputStream is = getClass().getResourceAsStream("/YouWinYouLose.png");

        try {
            YouWYLimg = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void ponerTPanel() {
        setMinimumSize(new Dimension(1000,600));
        setPreferredSize(new Dimension(1000,600));
        setMaximumSize(new Dimension(1000,600 ));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(inicioOnO == 0)
        {
            if (Variable1 == 0)
            {
                xDelta = 650;
                xDelta1 = 5;
                aniIndice=0;
                variable2 =0;
                conteoSeleccion = 0;
                variable3 = 0;
            }
            Variable1++;
            accionJugador = INICIANDO;
            aniVelocidad = 100;

            g.drawImage(animaciones[accionJugador][aniIndice], (int)xDelta, (int)yDelta,350,200,null);
            g.drawImage(animacionesReves[accionJugador][aniIndice], (int)xDelta1, (int)yDelta,350,200,null);
            actualizarTickInicio();
            actualizarTickInicioReves();
        }
        else if(accionJugador == QUIETO && SeleccionJugador != 0)
        {
            if (SeleccionJugador == 1)
            {
                //PIEDRA
                conteoSeleccion++;
                if (conteoSeleccion == 200 && aniIndice <2 && variable2 == 0)
                {
                    conteoSeleccion = 2;
                    aniIndice++;
                    aniIndiceReves--;
                }
                else if(conteoSeleccion == 1)
                {
                    aniIndice = 0;
                    aniIndiceReves = 2;
                    seleccionPrograma = ProgramaLogica.SeleccionPrograma();
                }

                g.drawImage(animaciones[accionJugador][aniIndice], (int)xDelta, (int)yDelta,350,200,null);
                g.drawImage(animacionesReves[accionJugador][aniIndiceReves], (int)xDelta1, (int)yDelta,350,200,null);

                if (conteoSeleccion == 201)
                {
                    variable3++;
                }
                else if (conteoSeleccion == 202 && seleccionPrograma == 0 && variable3 != 0)
                {
                    aniIndiceReves = 2;
                    aniIndice = 0;
                    variable2++;
                    Ganador = 0;
                }
                else if (conteoSeleccion == 202 && seleccionPrograma == 1 && variable3 != 0)
                {
                    aniIndiceReves = 2;
                    aniIndice = 1;
                    variable2++;
                    PuntuacionComputadora++;
                    Ganador = 2;
                }
                else if (conteoSeleccion == 202 && seleccionPrograma == 2 && variable3 != 0)
                {
                    aniIndiceReves = 2;
                    aniIndice = 2;
                    variable2++;
                    PuntuacionJugador++;
                    Ganador = 1;
                }
                else if (conteoSeleccion >=203 && conteoSeleccion <=549)
                {
                    tickUnos++;
                    if (Ganador == 1)
                    {
                        if (tickUnos > 50)
                        {
                            indiceUnos++;
                            tickUnos = 0;
                        }
                        else if (indiceUnos < 6)
                        {
                            g.drawImage(UnosAni[indiceUnos], 300, 175, 50, 100, null);
                        }
                    }
                    else if(Ganador == 2)
                    {
                        if (tickUnos > 50)
                        {
                            indiceUnos++;
                            tickUnos = 0;
                        }
                        else if (indiceUnos < 6)
                        {
                            g.drawImage(UnosAni[indiceUnos], 600, 175, 50, 100, null);
                        }
                    }
                    else
                    {
                        Ganador = 0;
                    }
                }
                else if(conteoSeleccion == 550)
                {
                    SeleccionJugador = 0;
                    variable2 =0;
                    conteoSeleccion = 0;
                    variable3 = 0;
                    tickUnos = 0;
                    indiceUnos = 0;
                    Ganador = 0;
                }
            }
            else if (SeleccionJugador == 2)
            {
                //PAPEL
                conteoSeleccion++;
                if (conteoSeleccion == 200 && aniIndice <2 && variable2 == 0)
                {
                    conteoSeleccion = 2;
                    aniIndice++;
                    aniIndiceReves--;
                }
                else if(conteoSeleccion == 1)
                {
                    aniIndice = 0;
                    aniIndiceReves = 2;
                    seleccionPrograma = ProgramaLogica.SeleccionPrograma();
                }

                g.drawImage(animaciones[accionJugador][aniIndice], (int)xDelta, (int)yDelta,350,200,null);
                g.drawImage(animacionesReves[accionJugador][aniIndiceReves], (int)xDelta1, (int)yDelta,350,200,null);

                if (conteoSeleccion == 201)
                {
                    variable3++;
                }
                else if (conteoSeleccion == 202 && seleccionPrograma == 0 && variable3 != 0)
                {
                    aniIndiceReves = 1;
                    aniIndice = 0;
                    variable2++;
                    PuntuacionJugador++;
                    Ganador = 1;
                }
                else if (conteoSeleccion == 202 && seleccionPrograma == 1 && variable3 != 0)
                {
                    aniIndiceReves = 1;
                    aniIndice = 1;
                    variable2++;
                    Ganador = 0;
                }
                else if (conteoSeleccion == 202 && seleccionPrograma == 2 && variable3 != 0)
                {
                    aniIndiceReves = 1;
                    aniIndice = 2;
                    variable2++;
                    PuntuacionComputadora++;
                    Ganador = 2;
                }
                else if (conteoSeleccion >=203 && conteoSeleccion <=549)
                {
                    tickUnos++;
                    if (Ganador == 1)
                    {
                        if (tickUnos > 50)
                        {
                            indiceUnos++;
                            tickUnos = 0;
                        }
                        else if (indiceUnos < 6)
                        {
                            g.drawImage(UnosAni[indiceUnos], 300, 175, 50, 100, null);
                        }
                    }
                    else if(Ganador == 2)
                    {
                        if (tickUnos > 50)
                        {
                            indiceUnos++;
                            tickUnos = 0;
                        }
                        else if (indiceUnos < 6)
                        {
                            g.drawImage(UnosAni[indiceUnos], 600, 175, 50, 100, null);
                        }
                    }
                    else
                    {
                        Ganador = 0;
                    }
                }
                else if(conteoSeleccion == 550)
                {
                    SeleccionJugador = 0;
                    variable2 =0;
                    conteoSeleccion = 0;
                    variable3 = 0;
                    tickUnos = 0;
                    indiceUnos = 0;
                    Ganador = 0;
                }
            }
            else
            {
                //TIJERA
                conteoSeleccion++;
                if (conteoSeleccion == 200 && aniIndice <2 && variable2 == 0)
                {
                    conteoSeleccion = 2;
                    aniIndice++;
                    aniIndiceReves--;
                }
                else if(conteoSeleccion == 1)
                {
                    aniIndice = 0;
                    aniIndiceReves = 2;
                    seleccionPrograma = ProgramaLogica.SeleccionPrograma();
                }

                g.drawImage(animaciones[accionJugador][aniIndice], (int)xDelta, (int)yDelta,350,200,null);
                g.drawImage(animacionesReves[accionJugador][aniIndiceReves], (int)xDelta1, (int)yDelta,350,200,null);

                if (conteoSeleccion == 201)
                {
                    variable3++;
                }
                else if (conteoSeleccion == 202 && seleccionPrograma == 0 && variable3 != 0)
                {
                    aniIndiceReves = 0;
                    aniIndice = 0;
                    variable2++;
                    PuntuacionComputadora++;
                    Ganador = 2;
                }
                else if (conteoSeleccion == 202 && seleccionPrograma == 1 && variable3 != 0)
                {
                    aniIndiceReves = 0;
                    aniIndice = 1;
                    variable2++;
                    PuntuacionJugador++;
                    Ganador = 1;
                }
                else if (conteoSeleccion == 202 && seleccionPrograma == 2 && variable3 != 0)
                {
                    aniIndiceReves = 0;
                    aniIndice = 2;
                    variable2++;
                    Ganador = 0;
                }
                else if (conteoSeleccion >=203 && conteoSeleccion <=549)
                {
                    tickUnos++;
                    if (Ganador == 1)
                    {
                        if (tickUnos > 50)
                        {
                            indiceUnos++;
                            tickUnos = 0;
                        }
                        else if (indiceUnos < 6)
                        {
                            g.drawImage(UnosAni[indiceUnos], 300, 175, 50, 100, null);
                        }
                    }
                    else if(Ganador == 2)
                    {
                        if (tickUnos > 50)
                        {
                            indiceUnos++;
                            tickUnos = 0;
                        }
                        else if (indiceUnos < 6)
                        {
                            g.drawImage(UnosAni[indiceUnos], 600, 175, 50, 100, null);
                        }
                    }
                    else
                    {
                        Ganador = 0;
                    }
                }
                else if(conteoSeleccion == 550)
                {
                    SeleccionJugador = 0;
                    variable2 =0;
                    conteoSeleccion = 0;
                    variable3 = 0;
                    tickUnos = 0;
                    indiceUnos = 0;
                    Ganador = 0;
                }
            }
        }
        else
        {
            aniTick1 = 0;
            aniTick2 = 0;
            g.drawImage(animaciones[accionJugador][aniIndice], (int)xDelta, (int)yDelta,350,200,null);
            g.drawImage(animacionesReves[accionJugador][aniIndice], (int)xDelta1, (int)yDelta,350,200,null);
            if(aniIndice == 6)
            {
                accionJugador = QUIETO;
                aniIndice = 0;
                FueraODentro = 1;
            }

            if(FueraODentro == 1)
            {
                actualizarTickAnimacion();
                parpadeo++;
                if (parpadeo <= variableTiempo1)
                {
                    g.drawImage(botonesOpcion[0][0], 375,200, 281,188, null);
                }
                else if (parpadeo <=variableTiempo2)
                {
                    g.drawImage(botonesOpcion[0][1], 200,30, 187,125, null);
                }
                else
                {
                    parpadeo =0;
                }
            }
            else
            {
                if (PuntuacionJugador ==7)
                {
                    FueraODentro = 3;
//                    juego.getReproductorAudio().pararCancion();
                    g.drawImage(puntuaciones[PuntuacionComputadora], 700,500, 225,38, null);
                    g.drawImage(puntuaciones[PuntuacionJugador], 50,500, 225,38, null);
                    g.drawImage(YouWYL[0], 120,25, 800,150, null);
                    parpadeo++;
                    if (parpadeo <= variableTiempo1+125)
                    {
                        g.drawImage(botonesOpcion[2][0], 350,200, 300,188, null);
                    }
                    else if (parpadeo <=variableTiempo2+100)
                    {
                        g.drawImage(botonesOpcion[2][1], 350,200, 300,188, null);
                    }
                    else
                    {
                        parpadeo =0;
                    }
                }
                else if(PuntuacionComputadora == 7)
                {
                    FueraODentro = 3;
//                    juego.getReproductorAudio().pararCancion();
                    g.drawImage(puntuaciones[PuntuacionComputadora], 700,500, 225,38, null);
                    g.drawImage(puntuaciones[PuntuacionJugador], 50,500, 225,38, null);
                    g.drawImage(YouWYL[1], 120,25, 800,150, null);
                    parpadeo++;
                    if (parpadeo <= variableTiempo1+125)
                    {
                        g.drawImage(botonesOpcion[2][0], 350,200, 300,188, null);
                    }
                    else if (parpadeo <=variableTiempo2+100)
                    {
                        g.drawImage(botonesOpcion[2][1], 350,200, 300,188, null);
                    }
                    else
                    {
                        parpadeo =0;
                    }
                }
                else
                {
                    actualizarTickAnimacion();
                    FueraODentro = 2;
                    g.drawImage(botonesOpcion[1][2], 200,30, 187,125, null);
                    g.drawImage(botonesOpcion[1][0], 415,30, 187,125, null);
                    g.drawImage(botonesOpcion[1][1], 624,30, 187,125, null);
                    g.drawImage(puntuaciones[PuntuacionComputadora], 700,500, 225,38, null);
                    g.drawImage(puntuaciones[PuntuacionJugador], 50,500, 225,38, null);
                }
            }
        }
    }

    private void actualizarTickAnimacion() {
        aniVelocidad = new Random().nextInt(250,300);
        aniTick ++;
        if (aniTick >= aniVelocidad)
        {
            aniTick = 0;
            aniIndice++;
            if (aniIndice >=CantidadSprite(accionJugador))
            {
                aniIndice = 0;
            }
        }
    }

    private void actualizarTickInicio() {
        aniTick1++;
        if (aniTick1 == aniVelocidad && aniIndice <7)
        {
            aniTick1 = 0;
            aniIndice++;
            xDelta -= 5;
        }
        else if(aniIndice ==6)
        {
            inicioOnO = 1;
        }
    }
    private void actualizarTickInicioReves() {
        aniTick2++;
        if (aniTick2 == aniVelocidad && aniIndice <7)
        {
            aniTick2 = 0;
            xDelta1 += 5;
        }
    }

//    private void actualizarTickSeleccion() {
//        aniTick++;
//        if (aniTick == aniVelocidad && aniIndice <7)
//        {
//            aniTick = 0;
//            aniIndice++;
//            xDelta -= 5;
//        }
//        else if(aniIndice ==6)
//        {
//            inicioOno = 1;
//        }
//    }
}
