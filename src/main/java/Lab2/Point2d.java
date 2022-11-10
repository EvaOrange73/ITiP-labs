package Lab2;

public class Point2d {

    private double xCoord;
    private double yCoord;

    //конструкторы
    public Point2d(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    public Point2d() {
        this(0, 0);
    }

    // Получение значений координат
    public double getX() {
        return xCoord;
    }

    public double getY() {
        return yCoord;
    }

    //  Изменение значений координат
    public void setX(double val) {
        xCoord = val;
    }

    public void setY(double val) {
        yCoord = val;
    }
}

