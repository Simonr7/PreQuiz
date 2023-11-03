package dominio.Exception;

public class InmuebleArrendadoException extends RuntimeException{
    public InmuebleArrendadoException(){
        super("El inmueble ya esta arrendado");
    }
}
