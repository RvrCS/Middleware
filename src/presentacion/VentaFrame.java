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
import logica.Venta;

import logica.VentaSender;

/**
 *
 * @author rvrso
 */
public class VentaFrame extends JFrame {
    private VentaSender sender;
    private JTextField idField;
    private JTextField descripcionField;
    private JTextField montoField;
    
    public VentaFrame(VentaSender sender){
        this.sender = sender;
        
        idField = new JTextField();
        descripcionField = new JTextField();
        montoField = new JTextField();
        
        JButton enviarBtn = new JButton("Enviar");
        
        enviarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String descripcion = descripcionField.getText();
                double monto = Double.parseDouble(montoField.getText());
                
                //Crea cliente a enviar
                Venta venta = new Venta(id, descripcion, monto);
                sender.sendVenta(venta);
                
            }
        });
        
        JPanel panel = new JPanel(new GridLayout(2,2));
        
        panel.add(new JLabel("ID: "));
        panel.add(idField);
        panel.add(new JLabel("Descripcion: "));
        panel.add(descripcionField);
        panel.add(new JLabel("Monto: "));
        panel.add(montoField);
        
        add(panel, BorderLayout.CENTER);
        add(enviarBtn, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Enviar datos CLIENTE");
        setSize(300, 150);
        
        setVisible(true);
        
    }
}
