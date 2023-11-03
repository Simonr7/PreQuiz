package Dominio;

import Dominio.Excepcion.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agencia {

    private String nombre;
    private List<Inmueble> inmuebles;

    public Agencia(String nombre, List<Inmueble> inmuebles) {
        this.nombre = nombre;
        this.inmuebles = inmuebles;
    }

    public void agregarInmueble  (Inmueble inmueble) {
        this.inmuebles.add(inmueble);
    }

    public boolean arrendar(Inmueble inmueble) {
        if (!inmueble.arrendado && inmueble instanceof Arrendable) {
            ((Arrendable) inmueble).arrendar();
            return true;
        } else {
            if (inmueble instanceof Arrendable) {
                throw new InmuebleArrendadoException();
            }
            throw new InmuebleNoArrendableException();
        }
    }

    public boolean devolver(Inmueble inmueble) {
        if (inmueble.arrendado && inmueble instanceof Arrendable) {
            ((Arrendable) inmueble).devolver();
            return true;
        } else {
            System.out.println("El inmueble a devolver no está arrendado");
        }
        return false;
    }

    public boolean vender(Inmueble inmueble){
        if(!inmueble.arrendado){
            this.inmuebles.remove(inmueble);
            return true;
        }
        else{
            throw new InmuebleNoVendibleException();
        }
    }

    public List<Inmueble> getArrendablesDisponibles() {
        return this.inmuebles.stream().filter
                        (inmueble -> !inmueble.arrendado && inmueble instanceof Arrendable)
                .collect(Collectors.toList());
    }

    public List<Inmueble> getArrendados() {
        List<Inmueble> arrendados = new ArrayList<>();

        for (Inmueble inmueble : this.inmuebles) {
            if (inmueble.arrendado) {
                arrendados.add(inmueble);
            }
        }
        return arrendados;
    }

    private List<Inmueble> getHipotecados() {
        List<Inmueble> hipotecados = new ArrayList<>();

        for (Inmueble inmueble : this.inmuebles) {
            if (inmueble instanceof Hipotecable && ((Hipotecable) inmueble).estaHipotecado()) {
                hipotecados.add(inmueble);
            }
        }
        return hipotecados;
    }

    public void hipotecarInmueble(String codigo) {
        Inmueble inmueble = buscarInmueblePorCodigo(codigo);

        if (inmueble instanceof Hipotecable) {
            try {
                ((Hipotecable) inmueble).hipotecar();
                System.out.println("Se ha hipotecado el inmueble con código " + codigo);
            } catch (UnsupportedOperationException e) {
                System.out.println("No se puede hipotecar el inmueble con código " + codigo + ": " + e.getMessage());
            }
        } else {
            System.out.println("El inmueble con código " + codigo + " no es hipotecable.");
        }
    }

    private Inmueble buscarInmueblePorCodigo(String codigo) {
        for (Inmueble inmueble : this.inmuebles) {
            if (inmueble.getCodigo().equals(codigo)) {
                return inmueble;
            }
        }
        throw new InmuebleInexistenteException();
    }

}