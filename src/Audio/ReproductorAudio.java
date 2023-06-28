package Audio;

import utilz.Constantes;

import javax.sound.sampled.*;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import static utilz.Constantes.JugandoOnO.FueraODentro;

public class ReproductorAudio {

    private Clip[] canciones, sonidoWin, sonidoFail;
    private int cancionSonandoId;
    private Random randy = new Random();


    public ReproductorAudio()
    {
        cargarCanciones();
        cargarSonidoWin();
        cargarSonidoFail();
    }

    private void cargarSonidoFail() {
        String[] sonidoF = {"fail"};
        sonidoFail = new Clip[sonidoF.length];

        sonidoFail[0] = conseguirClip(sonidoF[0]);
    }

    private void cargarCanciones()
    {
        String[] nombresC = {"Megalovania", "DeathByGlamour", "DoomEternal"};
        canciones = new Clip[nombresC.length];
        for (int i = 0; i < canciones.length; i++)
        {
            canciones[i] = conseguirClip(nombresC[i]);
        }
    }

    private void cargarSonidoWin()
    {
        String[] sonidoW = {"win"};
        sonidoWin = new Clip[sonidoW.length];

        sonidoWin[0] = conseguirClip(sonidoW[0]);
    }

    private Clip conseguirClip(String chanson)
    {
        URL url = getClass().getResource("/Audio/" + chanson + ".wav");
        AudioInputStream audio;

        try {
            audio = AudioSystem.getAudioInputStream(url);

            Clip cli = AudioSystem.getClip();

            cli.open(audio);

            return cli;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void pararCancion()
    {
        if (canciones[cancionSonandoId].isActive())
            canciones[cancionSonandoId].stop();
    }

    public void pararSonido()
    {
        if (sonidoFail[0].isActive())
            sonidoFail[0].stop();
        else if (sonidoWin[0].isActive())
            sonidoWin[0].stop();
    }

    public void ponerCancion()
    {
        int ran = randy.nextInt(3);
        reproducirCancion(ran);
    }

    public void reproducirCancion(int cancion)
    {
        pararCancion();

        cancionSonandoId = cancion;
        canciones[cancion].setMicrosecondPosition(-2);
        canciones[cancion].loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void reproducirSonidoWin()
    {
        pararCancion();

        sonidoWin[0].setMicrosecondPosition(0);
        sonidoWin[0].start();
    }

    public void reproducirSonidoFail()
    {
        pararCancion();

        sonidoFail[0].setMicrosecondPosition(1250000);
        sonidoFail[0].start();
    }
}
