class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction dX = robot.getX() > toX ? Direction.LEFT : Direction.RIGHT;
        int turnDirectionX = dX == Direction.LEFT && robot.getDirection() == Direction.UP ? -1 : 1; 
        // -1 - left, 1 - right
        while (robot.getX() != toX) {
            while (dX != robot.getDirection()) {
                if (turnDirectionX == 1) {
                    robot.turnRight();
                } else {
                    robot.turnLeft();
                }
            }
            robot.stepForward();
        }
        Direction dY = robot.getY() > toY ? Direction.DOWN : Direction.UP;
        int turnDirectionY = dY == Direction.DOWN && robot.getDirection() == Direction.LEFT ? -1 : 1; 
        // -1 - left, 1 - right
        while (robot.getY() != toY) {
            while (dY != robot.getDirection()) {
                if (turnDirectionY == 1) {
                    robot.turnRight();
                } else {
                    robot.turnLeft();
                }
            }
            robot.stepForward();
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
