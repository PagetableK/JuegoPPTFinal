package main;

import inputs.inputTeclado;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static utilz.Constantes.ConstantesJugador.*;

public class PanelJuego extends JPanel {

    private float xDelta = 650, yDelta =250, xDelta1 = 5;
    private BufferedImage img, imgVolteada,botonesimg, puntuacionimg;
    private BufferedImage [][] animaciones, animacionesReves, botonesOpcion;
    private BufferedImage [] puntuaciones;
    private int aniTick, aniIndice, aniVelocidad, aniTick1, parpadeo, variableTiempo1 = 200, variableTiempo2 =400;
    private int accionJugador = INICIANDO;
    private int inicioOno= 0;
    private int JugarOno=0;
    public static int NRondas = 0;
    public PanelJuego()
    {
        addKeyListener(new inputTeclado(this));
        ponerTPanel();
        importarImg();
        importarImgReves();
        importarBotonesImg();
        importarPuntuaciones();
        cargarAnimaciones();
        cargarAnimacionesReves();
        cargarBotones();
        cargarPuntuacion();
    }

    private void cargarPuntuacion() {
        puntuaciones = new BufferedImage[9];

        for (int i= 0; i<puntuaciones.length; i++)
            puntuaciones[i] = puntuacionimg.getSubimage(i*61, 0, 61, 10);
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

    private void ponerTPanel() {
        setMinimumSize(new Dimension(1000,600));
        setPreferredSize(new Dimension(1000,600));
        setMaximumSize(new Dimension(1000,600 ));
    }

    public void ponerDireccion()
    {

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);


        g.drawImage(animaciones[accionJugador][aniIndice], (int)xDelta, (int)yDelta,350,200,null);
        g.drawImage(animacionesReves[accionJugador][aniIndice], (int)xDelta1, (int)yDelta,350,200,null);
        if(inicioOno == 0)
        {
            aniVelocidad = 100;
            actualizarTickInicio();
            actualizarTickInicioReves();
        }
        else
        {
            if(aniIndice == 6)
            {
                accionJugador = QUIETO;
                aniIndice = 0;
            }
            actualizarTickAnimacion();
            if(JugarOno == 0)
            {
//                System.out.println(parpadeo);
//                parpadeo++;
//                if (parpadeo <= variableTiempo1)
//                {
//                    g.drawImage(botonesOpcion[0][0], 375,200, 281,188, null);
//                }
//                else if (parpadeo <=variableTiempo2)
//                {
//                    System.out.println("a");
//                    g.drawImage(botonesOpcion[0][1], 200,30, 187,125, null);
//                }
//                else
//                {
//                    parpadeo =0;
//                }
                g.drawImage(botonesOpcion[0][0], 375,200, 281,188, null);
            }
            else
            {
                g.drawImage(botonesOpcion[1][0], 200,30, 187,125, null);
                g.drawImage(botonesOpcion[1][1], 415,30, 187,125, null);
                g.drawImage(botonesOpcion[1][2], 624,30, 187,125, null);
                g.drawImage(puntuaciones[0], 700,500, 225,38, null);
                g.drawImage(puntuaciones[0], 50,500, 225,38, null);
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
        aniTick++;
        if (aniTick == aniVelocidad && aniIndice <7)
        {
            aniTick = 0;
            aniIndice++;
            xDelta -= 5;
        }
        else if(aniIndice ==6)
        {
            inicioOno = 1;
        }
    }
    private void actualizarTickInicioReves() {
        aniTick1++;
        if (aniTick1 == aniVelocidad && aniIndice <7)
        {
            aniTick1 = 0;
            xDelta1 += 5;
        }
    }
}
