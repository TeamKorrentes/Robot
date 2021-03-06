package ru.teamkorrentes.robot;

/**
 * Класс для управления роботом.
 *
 * @author Глазунов А. С.
 */
public class RobotOld {

    private Direction direction;
    private Point position;

    /**
     * Констукртор по умолчанию, который задаёт точку (0, 0) и направление взгляда - вверх.
     */
    public RobotOld(){
        this.direction = Direction.TOP;
        this.position = new Point(0, 0);
    }

    /**
     * Конструктор с двумя параметрами, позволяющий задать позицию.
     * Направление используется из конструктора по умолчанию.
     *
     * @param position Позиция в пространстве. Класс Point
     */
    public RobotOld(Point position){
        this.direction = Direction.TOP;
        this.position = new Point(position.getX(), position.getY());
    }

    /**
     * Конструктор с двумя параметрами, позволяющий задать направление и позицию.
     *
     * @param direction Направление. Enum Direction
     * @param position Позиция в пространстве. Класс Point
     */
    public RobotOld(Direction direction, Point position){
        this.direction = direction;
        this.position = new Point(position.getX(), position.getY());
    }

    /**
     * Метод для изменения стороны, куда смотрит робот, в левую сторону.
     */
    public void turnLeft(){
        switch (this.direction){
            case TOP:
                this.direction = Direction.LEFT;
                break;
            case LEFT:
                this.direction = Direction.BOTTOM;
                break;
            case BOTTOM:
                this.direction = Direction.RIGHT;
                break;
            case RIGHT:
                this.direction = Direction.TOP;
                break;
        }
    }

    /**
     * Метод для изменения стороны, куда смотрит робот, в правую сторону.
     */
    public void turnRight(){
        switch (this.direction){
            case TOP:
                this.direction = Direction.RIGHT;
                break;
            case RIGHT:
                this.direction = Direction.BOTTOM;
                break;
            case BOTTOM:
                this.direction = Direction.LEFT;
                break;
            case LEFT:
                this.direction = Direction.TOP;
                break;
        }
    }


    /**
     * Функция для шага робота. Двигается на 1 в направлении, который указан в классе
     */
    public void walk(){
        switch (this.direction){
            case TOP:
                position.setY(position.getY() + 1);
                break;
            case LEFT:
                position.setX(position.getX() - 1);
                break;
            case BOTTOM:
                position.setY(position.getY() - 1);
                break;
            case RIGHT:
                position.setX(position.getX() + 1);
                break;
        }

        Demo.writer.println("Робот переместился на координаты: " + position.toString());
    }

    /**
     * Функция для шага робота. Двигается на указанное кол-во шагов в направлении, который указан в классе.
     * Работает только для маленьких шагов (0 < x < 1). Если аргумент больше единицы - ничего не происходит.
     *
     * @param change Длина шага (0 < x < 1)
     */
    public void walk(double change){
        if(change <= 0 && change >= 1) return;

        switch (this.direction){
            case TOP:
                position.setY(position.getY() + change);
                break;
            case LEFT:
                position.setX(position.getX() - change);
                break;
            case BOTTOM:
                position.setY(position.getY() - change);
                break;
            case RIGHT:
                position.setX(position.getX() + change);
                break;
        }

        Demo.writer.println("Робот переместился на координаты: " + position.toString());
    }

    /**
     * Метод для перемещения робота
     *
     * @param end Конечная точка типа Point
     */
    public void move(Point end){
        //Двигаем робота по x
        if(position.getX() < end.getX()){
            //Поварачиваем робота в нужную нам сторону (Право)
            switch (direction){
                case TOP:
                    turnRight();
                    break;
                case LEFT:
                    turnRight();
                    turnRight();
                    break;
                case BOTTOM:
                    turnLeft();
                    break;
            }

            //Двигаем его в повёрнутом направлении.
            while(position.getX() < end.getX()){
                walk();
            }
            if(position.getX() != end.getX()){
                turnRight();
                turnRight();
                walk(Math.abs(end.getX() - position.getX()));
            }
        } else {
            //Поварачиваем робота в нужную нам сторону (Лево)
            switch (direction){
                case TOP:
                    turnLeft();
                    break;
                case RIGHT:
                    turnRight();
                    turnRight();
                    break;
                case BOTTOM:
                    turnRight();
                    break;
            }

            //Двигаем его в повёрнутом направлении.
            while(position.getX() > end.getX()){
                walk();
            }
            if(position.getX() != end.getX()){
                turnRight();
                turnRight();
                walk(Math.abs(end.getX() - position.getX()));
            }
        }

        //Двигаем робота по y
        if(position.getY() < end.getY()){
            //Поварачиваем робота в нужную нам сторону (Вверх)
            switch (direction){
                case LEFT:
                    turnRight();
                    break;
                case RIGHT:
                    turnLeft();
                    break;
                case BOTTOM:
                    turnLeft();
                    turnLeft();
                    break;
            }

            //Двигаем его в повёрнутом направлении.
            while(position.getY() < end.getY()){
                walk();
            }
            if(position.getY() != end.getY()){
                turnRight();
                turnRight();
                walk(Math.abs(end.getY() - position.getY()));
            }
        } else {
            //Поварачиваем робота в нужную нам сторону (Вниз)
            switch (direction){
                case TOP:
                    turnLeft();
                    turnLeft();
                    break;
                case RIGHT:
                    turnRight();
                    break;
                case LEFT:
                    turnLeft();
                    break;
            }

            //Двигаем его в повёрнутом направлении.
            while(position.getY() > end.getY()){
                walk();
            }
            if(position.getY() != end.getY()){
                turnRight();
                turnRight();
                walk(Math.abs(end.getY() - position.getY()));
            }
        }

    }

    public Point getPosition(){
        return this.position;
    }

    public Direction getDirection(){
        return this.direction;
    }

    @Override
    public String toString() {
        return "Робот находится в координатах " + position.toString() + " и смотрит в направлении \"" + direction.toString() + "\".";
    }
}
