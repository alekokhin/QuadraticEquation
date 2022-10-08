package org.example.database;
import java.io.PrintWriter;
import org.example.database.dao.QuadraticDAO;
import org.example.database.models.QuadraticDate;
import java.io.IOException;
import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args)throws IOException {
        //You can change the file name but it is not necessary
        PrintWriter out = new PrintWriter("result.txt");// create the PrintWriter object out and associates it with the file result.txt .
        QuadraticDAO quadraticDAO = new QuadraticDAO();
        for (QuadraticDate q:quadraticDAO.getAllquadraticDate()) {
            double a=q.getA();//getting coeffs from database
            double b= q.getB();
            double c= q.getC();

            double d = b * b - 4 * a * c;
            double x1, x2;
            if (d > 0) {

                // two real and distinct roots
                x1 = (-b + sqrt(d)) / (2 * a);
                x2 = (-b - sqrt(d)) / (2 * a);
                out.println("\nx1= " + x1 + " and " + " x2= " + x2);

            } else if (d == 0) {
                x1 = x2 = -b / (2 * a);
                out.println("\nx1 = x2 = " + x1);

            } else {

                // roots are complex number and distinct
                double real = -b / (2 * a);
                double imaginary = sqrt(-d) / (2 * a);
                out.printf("\nx1 = %.2f+%.2fi ", real, imaginary);
                out.printf("\nx2 = %.2f-%.2fi ", real, imaginary);
                out.print(System.lineSeparator());
            }
        }out.close();//close file
    }
}
