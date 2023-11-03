package dominio;

public class Casa extends Inmueble implements Arrendable, Hipotecable{
    @Override
    public void arrendar() {

    }

    @Override
    public void devolver() {

    }

    @Override
    public void hipotecar() {

    }

    @Override
    public boolean estaHipotecado() {
        return false;
    }
}
