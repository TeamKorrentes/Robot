package ru.teamkorrentes.robot;

/**
 * Вспомогательный класс для ввода координат.
 *
 * @author Маклаков С.П. 13ИОТ18К
 */
public class Point {
    private double x;
    private double y;

    /**
     * Конструктор по умолчанию задает две точки координат.
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Конструктор с параметрами задает две точки координат.
     * @param x Первая точка координат
     * @param y Вторая точка координат
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) { this.x = x; }

    public double getX() {
        return x;
    }

    public void setY(double y) { this.y = y; }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[x=" + x + ", y=" + y + "]";
    }
}
