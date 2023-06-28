package utilz;

import java.util.Random;

public class ProgramaLogica {

    public int PuntuacionPrograma = 0;
    public int PuntuacionJugador = 0;
    public int SeleccionPrograma = 0;

    public int SeleccionPrograma()
    {
        int num = new Random().nextInt(3);

        return num;
    }
}
