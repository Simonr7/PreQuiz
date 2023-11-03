package dominio.Exception;

public class InmuebleNoRetornableException extends  RuntimeException{
    public InmuebleNoRetornableException(){
        super("El inmueble a devolver no esta arrendado por lo tanto no se puede devolver");
    }
}
