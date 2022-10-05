package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*  MÉTODOS ABSTRATOS
    - São os métodos que não possuem implementação.

    - Métodos precisam ser abstratos quando a classe é genérica demais para conter sua implementação.

    - Se uma classe possuir pelo menos um método abstrato, então esta classe também é abstrata.

    - Notação UML: itálico

* */
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        List<Shape> list = new ArrayList<>();

        System.out.println("Enter the number of shapes: ");
        int n = sc.nextInt();

        for(int i=1; i<n; i++){
            System.out.println("Shape #" + i + " data:");
            System.out.println("Rectangle or Circle (r/c) ? ");
            char opc = sc.next().charAt(0);
            System.out.println("Color (BLACK/BLUE/RED):");
            Color color = Color.valueOf(sc.next()); //Para receber Enums e Datas utilizamos apenas o sc.next();
                if(opc == 'r' || opc == 'R'){
                    sc.nextLine();
                    System.out.println("WIDTH");
                    double width = sc.nextDouble();
                    System.out.println("HEIGHT");
                    double height = sc.nextDouble();
                    list.add(new Rectangle(color, width, height));
                }else {
                    sc.nextLine();
                    System.out.println("Radius: ");
                    double radius = sc.nextDouble();
                    list.add(new Circle(color, radius));
                }
        }
        System.out.println();
        System.out.println("SHAPE AREAS: ");
        for (Shape shape: list) {
            System.out.printf("%.2f%n",shape.area());
        }


        sc.close();
    }
}
