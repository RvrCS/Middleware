/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import javax.swing.JTextArea;

/**
 *
 * @author rvrso
 */
public class Middleware implements ClienteSender, VentaSender {
    
    private Interpreter interpreter;
    private ClienteSender clienteS;
    private VentaSender ventaS;
    private JTextArea textArea;

    public Middleware(Interpreter interpreter, ClienteSender clienteS, VentaSender ventaS, JTextArea textArea) {
        this.interpreter = interpreter;
        this.clienteS = clienteS;
        this.ventaS = ventaS;
        this.textArea = textArea;
    }
    
    

    @Override
    public void sendCliente(Object cliente) {
        Object interpretedData = interpreter.interpet(cliente.toString());
        textArea.append("Enviando datos de cliente: " + cliente);
        clienteS.sendCliente(interpretedData);
        
    }

    @Override
    public void sendVenta(Object venta) {
        Object interpretedData = interpreter.interpet(venta.toString());
        textArea.append("Enviando datos de cliente: " + venta);
        ventaS.sendVenta(interpretedData);
    }
    
    
}
