/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rvrso
 */
public class Interpreter {

    private List<Expresion> expresiones;

    public Interpreter(){

        expresiones = new ArrayList<>();
        
        expresiones.add(new ClienteExpresion());
        expresiones.add(new VentaExpresion());
        
    }
    
    public Object interpet(String data){
        
        for (Expresion expresion : expresiones) {
            
            if (expresion.equal(data)) {
                
                return expresion.interpret(data);
                
            }
            
        }
        
        return null;
        
    }
    

    private interface Expresion {

        boolean equal(String data);

        Object interpret(String data);

    }

    private class ClienteExpresion implements Expresion{
        private static final String prefijo = "Cliente:";
        
        @Override
        public boolean equal(String data) {
            return data.startsWith(prefijo);
        }

        @Override
        public Object interpret(String data) {
            String[] partes = data.substring(prefijo.length()).split(",");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            
            return new Cliente(id, nombre);
            
        }
        
    }
    
    private class VentaExpresion implements Expresion{
        private static final String prefijo = "Venta:";
        
        @Override
        public boolean equal(String data) {
            return data.startsWith(prefijo);
        }

        @Override
        public Object interpret(String data) {
            String[] partes = data.substring(prefijo.length()).split(",");
            int id = Integer.parseInt(partes[0]);
            String descripcion = partes[1];
            double monto = Double.parseDouble(partes[2]);
            
            return new Venta(id, descripcion, monto);
            
        }
        
    }
    
    
}
