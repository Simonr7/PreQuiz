package dominio.Exception;

public class InmuebleNoVendibleException extends RuntimeException{
    public InmuebleNoVendibleException(){
        super("no se puede vender pues esta arrendado");
    }
}
