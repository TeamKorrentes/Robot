package ru.teamkorrentes.robot;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Демонстрационный класс.
 *
 * @author Першин С.А , Манчин А.С.
 */
public class Demo {

    public static PrintWriter writer;

    public static void main(String[] args) {
        writer = null;
        try {
            writer = new PrintWriter("Robot.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Point start = new Point(0, 0);
        Point end = new Point(12, 22);

        Robot robot = new Robot(start);
        robot.move(end);
        writer.println(robot.toString());
        robot.turnLeft();
        writer.println(robot.toString());
        robot.walk();
        robot.turnRight();
        writer.println(robot.toString());

        writer.close();

        System.out.println("Координаты введены в файл");
    }
}


