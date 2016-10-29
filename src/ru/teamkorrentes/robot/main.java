package ru.teamkorrentes.robot;

public class main{
    public static void main(String[] args) {
        Point start = new Point(0, 0);
        Point end = new Point(-15.5, -10.6);

        Robot robot = new Robot(start);
        robot.move(end);
        System.out.println(robot.toString());
    }
}
