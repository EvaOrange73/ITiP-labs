package Lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Point3d[] points = new Point3d[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите координаты точки x" + (i + 1) );
            Point3d point = new Point3d(
                    Double.parseDouble(reader.readLine()),
                    Double.parseDouble(reader.readLine()),
                    Double.parseDouble(reader.readLine())
            );
            points[i] = point;
        }
        if (points[0].equals(points[1]) || points[0].equals(points[2])) {
            System.out.println("Точки совпадают, площадь треугольника 0");
        } else {
            System.out.println("Площадь треугольника " + computeArea(points[0], points[1], points[2]));
        }
    }

    //вычисление площади треугольника по координатам вершин через формулу Герона
    public static double computeArea(Point3d a, Point3d b, Point3d c) {
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ca = c.distanceTo(a);
        double p = (ab + bc + ca) / 2;
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
    }
}
