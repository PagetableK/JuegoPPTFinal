package utilz;


public class Constantes {

    public static class JugandoOnO
    {
        public static int FueraODentro = 0;
        public static int inicioOnO = 0;
        public static int Variable1 = 0;
        public static int Variable2 = 0;
    }

    public static class Puntuaciones
    {
        public static int PuntuacionJugador = 1;
        public static int PuntuacionComputadora = 1;
    }

    public static class ConstantesJugador{
        public static final int QUIETO = 0;
        public static final int DECIDIENDO = 1;
        public static final int INICIANDO = 4;
        public static int SeleccionJugador = 0;

        public static int CantidadSprite(int accionJugador)
        {
            switch (accionJugador)
            {
                case QUIETO:
                    return 3;
                case DECIDIENDO:
                    return 3;
                case INICIANDO:
                    return 7;
                default:
                    return 3;
            }
        }
    }
}
