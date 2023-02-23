/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logica.Cliente;
import logica.ClienteSender;

/**
 *
 * @author rvrso
 */
public class ClienteFrame extends JFrame {
    
    private ClienteSender sender;
    private JTextField idField;
    private JTextField nombreField;
    
    public ClienteFrame(ClienteSender sender){
        this.sender = sender;
        
        idField = new JTextField();
        nombreField = new JTextField();
        
        JButton enviarBtn = new JButton("Enviar");
        
        enviarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                
                //Crea cliente a enviar
                Cliente cliente = new Cliente(id, nombre);
                sender.sendCliente(cliente);
                
            }
        });
        
        JPanel panel = new JPanel(new GridLayout(2,2));
        
        panel.add(new JLabel("ID: "));
        panel.add(idField);
        panel.add(new JLabel("Nombre: "));
        panel.add(nombreField);
        
        add(panel, BorderLayout.CENTER);
        add(enviarBtn, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Enviar datos CLIENTE");
        setSize(300, 150);
        
        setVisible(true);
        
    }
    
}
