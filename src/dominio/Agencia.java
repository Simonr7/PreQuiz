package dominio;

import dominio.Exception.InmuebleArrendadoException;
import dominio.Exception.InmuebleNoArrendableException;
import dominio.Exception.InmuebleNoVendibleException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agencia {
    protected String nombre;

    private List<Inmueble> inmuebles;

    public Agencia(String nombre) {
        this.nombre = nombre;
        this.inmuebles = new ArrayList<>();
    }

    public void agregarInmueble(Inmueble inmueble){
        this.inmuebles.add(inmueble);

    }
    public boolean arrendar(Inmueble inmueble){
        if(!inmueble.arrendado && inmueble instanceof Arrendable){
            ((Arrendable)inmueble).arrendar();
            return true;
        }
        else{
            if(inmueble instanceof Arrendable){
                throw new InmuebleArrendadoException();
            }
            throw new InmuebleNoArrendableException();
        }
    }
    public boolean devolver(Inmueble inmueble){
        if(inmueble.arrendado && inmueble instanceof Arrendable){
            ((Arrendable)inmueble).devolver();
            return true;
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
                (inmuebles-> !inmuebles.arrendado && inmuebles instanceof Arrendable)
                .collect(Collectors.toList());
    }
    public List<Inmueble> getArrendados() {
        List<Inmueble> arrendados = new ArrayList<>();
        for (Inmueble inmueble : this.inmuebles) {
            if (inmueble.arrendado) {
            arrendados.add(inmueble);
        }
    }
        return inmuebles;
    }
}
