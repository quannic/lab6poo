// Joel Seura - RUT: 21.556.232-8
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Javier Vera M. 21.697.880-3
package gui;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import logic.FiguraGeometrica;

public class VentanaCalculadora extends JFrame {

    private JTextField ladoAField, ladoBField, resultadoArea, resultadoPerimetro, tipoFigura;
    private JButton calcularBtn, limpiarBtn, salirBtn;

    public VentanaCalculadora() {
        setTitle("Figura Geométrica");
        setSize(300, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        
        JPanel panelDimensiones = new JPanel(new GridLayout(2, 2, 10, 10));
        panelDimensiones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Dimensiones", TitledBorder.LEFT, TitledBorder.TOP));
        

        panelDimensiones.add(new JLabel("Lado A"));
        ladoAField = new JTextField();
        panelDimensiones.add(ladoAField);

        panelDimensiones.add(new JLabel("Lado B"));
        ladoBField = new JTextField();
        panelDimensiones.add(ladoBField);

        calcularBtn = new JButton("Calcular");
        JPanel panelCalcular = new JPanel();
        panelCalcular.add(calcularBtn);

        
        JPanel panelResultados = new JPanel(new GridLayout(4, 2, 10, 10));
        panelResultados.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Resultados", TitledBorder.LEFT, TitledBorder.TOP));
        

        panelResultados.add(new JLabel("Tipo"));
        tipoFigura = new JTextField();
        tipoFigura.setEditable(false);
        panelResultados.add(tipoFigura);

        panelResultados.add(new JLabel("Perímetro"));
        resultadoPerimetro = new JTextField();
        resultadoPerimetro.setEditable(false);
        panelResultados.add(resultadoPerimetro);

        panelResultados.add(new JLabel("Área"));
        resultadoArea = new JTextField();
        resultadoArea.setEditable(false);
        panelResultados.add(resultadoArea);

        
        limpiarBtn = new JButton("Limpiar");
        salirBtn = new JButton("Salir");
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 5));
        panelBotones.add(limpiarBtn);
        panelBotones.add(salirBtn);

        
        panelPrincipal.add(panelDimensiones, BorderLayout.NORTH);
        panelPrincipal.add(panelCalcular, BorderLayout.CENTER);
        panelPrincipal.add(panelResultados, BorderLayout.SOUTH);

        getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);

       
        calcularBtn.addActionListener(e -> calcular());
        limpiarBtn.addActionListener(e -> limpiarCampos());
        salirBtn.addActionListener(e -> confirmarSalida());
    }

    private void calcular() {
        String textoA = ladoAField.getText();
        String textoB = ladoBField.getText();

        if (textoA.isEmpty() || textoB.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar ambos lados para calcular.");
            return;
        }

        try {
            double a = Double.parseDouble(textoA);
            double b = Double.parseDouble(textoB);

            FiguraGeometrica figura = new FiguraGeometrica(a, b);

            resultadoArea.setText(String.valueOf(figura.calcularArea()));
            resultadoPerimetro.setText(String.valueOf(figura.calcularPerimetro()));
            tipoFigura.setText(figura.determinarTipo());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos.");
        }
    }

    private void limpiarCampos() {
        ladoAField.setText("");
        ladoBField.setText("");
        resultadoArea.setText("");
        resultadoPerimetro.setText("");
        tipoFigura.setText("");
    }

    private void confirmarSalida() {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas salir?",
                "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}


