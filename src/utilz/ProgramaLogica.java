package utilz;

import java.util.Random;

public class ProgramaLogica {

    public static int SeleccionPrograma()
    {
        int num = new Random().nextInt(3);

        return num;
    }
}
