package Lab2;

public class Point3d extends Point2d {
    private double zCoord;

    //конструкторы
    public Point3d(double x, double y, double z) {
        super(x, y);
        zCoord = z;
    }
    public Point3d() {
        super();
        zCoord = 0;
    }

    // Получение значений координат
    public double getZ() {
        return zCoord;
    }

    //  Изменение значений координат
    public void setZ(double val) {
        zCoord = val;
    }

    // Проверка равенства двух точек
    public boolean equals(Point3d point) {
        return super.getX() == point.getX() && super.getY() == point.getY() && zCoord == point.getZ();
    }

    // Расстояние между двумя точками
    public double distanceTo(Point3d point) {
        return Math.sqrt(Math.pow(super.getX() - point.getX(), 2) +
                        Math.pow(super.getY() - point.getY(), 2) +
                        Math.pow(zCoord - point.getZ(), 2));
    }
}
