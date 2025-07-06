// Joel Seura - RUT: 21.556.232-8
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Javier Vera M. 21.697.880-3
package logic;
public class FiguraGeometrica {
    private double ladoA;
    private double ladoB;

    public FiguraGeometrica(double ladoA, double ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    public double calcularArea() {
        return ladoA * ladoB;
    }

    public double calcularPerimetro() {
        return 2 * (ladoA + ladoB);
    }

    public String determinarTipo() {
        if (ladoA == ladoB) {
            return "Cuadrado";
        } else {
            return "Rectángulo";
        }
    }
}

