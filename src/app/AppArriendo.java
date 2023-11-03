package app;

import dominio.*;

public class AppArriendo {
    public static void main(String[] args) {
        Casa casa = new Casa();
        Apartamento apartamento = new Apartamento();
        Lote lote = new Lote();
        Casa yate = new Casa();

        Agencia agencia = new Agencia("BEMSA");

        agencia.agregarInmueble(casa);
        agencia.agregarInmueble(apartamento);
        agencia.agregarInmueble(lote);
        agencia.agregarInmueble(yate);



        agencia.vender(lote);
        agencia.vender(apartamento);

        agencia.arrendar(casa);
        agencia.arrendar(yate);
        agencia.devolver(casa);



        System.out.println("ARRENDADOS");
        System.out.println(agencia.getArrendados());
        System.out.println("//////////////////////////////////////////////////////////////");
        System.out.println("DISPONIBLES PARA ARRENDAR");
        System.out.println(agencia.getArrendablesDisponibles());
        }
    }