package ru.teamkorrentes.robot;

/**
 * Класс для управления роботом, позволяющий:
 * <ul>
 *     <li>Инициализировать робота</li>
 *     <li>Повернуть его вправо</li>
 *     <li>Повернуть его влево</li>
 *     <li>Сделать шаг</li>
 * </ul>
 *
 * @author Глазунов А. С.
 */
public class Robot {

    private Direction direction;
    private Point position;

    /**
     * Констукртор без параметров.
     * Задаёт начальную точку ({@link Point}) x = 0, y = 0
     * и направление взгляда ({@link Direction}) - вверх.
     */
    public Robot(){
        this.direction = Direction.TOP;
        this.position = new Point();
    }

    /**
     * Конструктор с одним параметром, позволяющий задать начанльные координаты.
     * Направление задаётся такое же, как и в констукторе без параметров (вверх).
     *
     * @param position начальные координаты робота. {@link Point}
     */
    public Robot(Point position){
        this.direction = Direction.TOP;
        this.position = new Point(position.getX(), position.getY());
    }

    /**
     * Конструктор с двумя параметрами, позволяющий задать начанльные координаты
     * и направление взгляда робота.
     *
     * @param direction взгляд робота. {@link Direction}
     * @param position начальные координаты робота. {@link Point}
     */
    public Robot(Direction direction, Point position){
        this.direction = direction;
        this.position = new Point(position.getX(), position.getY());
    }

    /**
     * Метод для поворота взгляда робота в левую сторону.
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
     * Метод для поворота взгляда робота в правую сторону.
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
     * Метод для шага робота.
     * Передвигает робота на одну координату в направлении его взгляда.
     */
    public void step(){
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
    }

    /**
     * Возвращает текущие координаты робота.
     *
     * @return координаты робота в виде класса {@link Point}
     */
    public Point getPosition(){
        return this.position;
    }

    /**
     * Возвращает текущее направление взгляда робота.
     *
     * @return направление взгляда в виде одного из перечислений {@link Direction}
     */
    public Direction getDirection(){
        return this.direction;
    }

    /**
     * Возвращает строку с информацией о роботе.
     *
     * @return текущие координаты(х, у) и направление взгляда робота.
     */
    public String toString() {
        return "Робот находится в координатах " + position.toString() + " и смотрит в направлении \"" + direction.toString() + "\".";
    }
}
