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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import logica.ClienteSender;
import logica.VentaSender;

/**
 *
 * @author rvrso
 */
public class MainFrame extends JFrame {
    
    private ClienteSender clienteSender;
    private VentaSender ventaSender;
    
    public MainFrame(){
        
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel(new GridLayout(2,1));
        
        JButton clienteBtn = new JButton("Iniciar envío de datos de cliente");
        
        clienteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteFrame clienteFrame = new ClienteFrame(clienteSender);
            }
        });
        
        panel.add(clienteBtn);
        
        JButton ventaBtn = new JButton("Iniciar envío de datos de venta");
        
        ventaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentaFrame ventaFrame = new VentaFrame(ventaSender);
            }
        });
        
        panel.add(ventaBtn);
        
        add(panel, BorderLayout.SOUTH);
        
    }
    
    
}
