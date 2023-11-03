package dominio;

public class Casa extends Inmueble implements Arrendable, Hipotecable{
    @Override
    public void arrendar() {this.arrendado = true;}

    @Override
    public void devolver() {this.arrendado = false;}

    @Override
    public void hipotecar() {
        System.out.println("Se hipoteco");
    }
   @Override
        public String toString() {
            System.out.println("Casa");
            return super.toString();
        }
    @Override
    public boolean estaHipotecado() {
        return false;
    }
}
