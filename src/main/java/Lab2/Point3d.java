package Lab2;

public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;

    //конструкторы
    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    public Point3d() {
        this(0, 0, 0);
    }

    // Получение значений координат
    public double getX() {
        return xCoord;
    }
    public double getY() {
        return yCoord;
    }
    public double getZ() {
        return zCoord;
    }

    //  Изменение значений координат
    public void setX(double val) {
        xCoord = val;
    }
    public void setY(double val) {
        yCoord = val;
    }
    public void setZ(double val) {
        zCoord = val;
    }

    // Проверка равенства двух точек
    public boolean equals(Point3d point) {
        return xCoord == point.getX() && yCoord == point.getY() && zCoord == point.getZ();
    }

    // Расстояние между двумя точками
    public double distanceTo(Point3d point) {
        return Math.sqrt(Math.pow(xCoord - point.getX(), 2) +
                        Math.pow(yCoord - point.getY(), 2) +
                        Math.pow(zCoord - point.getZ(), 2));
    }
}
