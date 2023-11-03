package dominio;

public class Apartamento extends Inmueble implements Arrendable, Hipotecable{
    @Override
    public void arrendar() { this.arrendado = true;
    }

    @Override
    public void devolver() { this.arrendado = false;
    }

    @Override
    public void hipotecar() {
        System.out.println("se hipoteco la propiedad");
    }
    @Override
    public String toString() {
        System.out.println("Apartamento");
        return super.toString();
    }
    @Override
    public boolean estaHipotecado() {
        return false;
    }
}
