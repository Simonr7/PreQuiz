package dominio.Exception;

public class InmuebleNoArrendableException extends RuntimeException{
    public InmuebleNoArrendableException() {
        super("El inmueble aun no esta arrendado");
    }
}
