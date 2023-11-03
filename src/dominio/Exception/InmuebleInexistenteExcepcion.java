package dominio.Exception;

public class InmuebleInexistenteExcepcion extends RuntimeException{
    public InmuebleInexistenteExcepcion(){
        super("NO EXISTE EL INMUEBLE");
    }

}
