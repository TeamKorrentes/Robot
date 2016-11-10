import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * Created by Алёха on 30.10.2016.
 */
public class Demo {

    public static void move(Point end){
        //Двигаем робота по x
        if(robot.getPosition().getX() < end.getX()){
            //Поварачиваем робота в нужную нам сторону (Право)
            switch (robot.getDirection()){
                case TOP:
                    robot.turnRight();
                    break;
                case LEFT:
                    robot.turnRight();
                    robot.turnRight();
                    break;
                case BOTTOM:
                    robot.turnLeft();
                    break;
            }

            //Двигаем его в повёрнутом направлении.
            while(robot.getPosition().getX() < end.getX()){
                robot.step();
            }
        } else {
            //Поварачиваем робота в нужную нам сторону (Лево)
            switch (robot.getDirection()){
                case TOP:
                    robot.turnLeft();
                    break;
                case RIGHT:
                    robot.turnRight();
                    robot.turnRight();
                    break;
                case BOTTOM:
                    robot.turnRight();
                    break;
            }

            //Двигаем его в повёрнутом направлении.
            while(robot.getPosition().getX() > end.getX()){
                robot.step();
            }
        }

        //Двигаем робота по y
        if(robot.getPosition().getY() < end.getY()){
            //Поварачиваем робота в нужную нам сторону (Вверх)
            switch (robot.getDirection()){
                case LEFT:
                    robot.turnRight();
                    break;
                case RIGHT:
                    robot.turnLeft();
                    break;
                case BOTTOM:
                    robot.turnLeft();
                    robot.turnLeft();
                    break;
            }

            //Двигаем его в повёрнутом направлении.
            while(robot.getPosition().getY() < end.getY()){
                robot.step();
            }
        } else {
            //Поварачиваем робота в нужную нам сторону (Вниз)
            switch (robot.getDirection()){
                case TOP:
                    robot.turnLeft();
                    robot.turnLeft();
                    break;
                case RIGHT:
                    robot.turnRight();
                    break;
                case LEFT:
                    robot.turnLeft();
                    break;
            }

            //Двигаем его в повёрнутом направлении.
            while(robot.getPosition().getY() > end.getY()){
                robot.step();
            }

        }

    }
    static Robot robot = new Robot();

    public static PrintWriter writer;
    public static void main(String[] args) {

        PrintWriter writer;
        writer = null;
        try {
            writer = new PrintWriter("Robot.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Point start = new Point(3, 6);
        Point end = new Point(2, -2);

        move(start);
        writer.println(robot.toString());
        move(end);
        writer.println(robot.toString());

        writer.close();

    }


}
