//This is a model of table (class)
//jbhvdfj
package org.example.database.models;

public class QuadraticDate {
    private Long id;
    private double a;
    private double b;
    private double c;

    public QuadraticDate() {
    }

    public QuadraticDate(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticDate(Long id, double a, double b, double c) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

}
