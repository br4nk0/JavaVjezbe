package vjezbeVI;

public class Player {
    private String name;
    private int x;
    private int y;
    private int width;
    private int height;
    private int health; // 0..100

    public Player(String name, int x, int y, int width, int height, int health) {
        setName(name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setHealth(health);
    }

    private String normalizeName(String s) {
        // ako je null ili prazan, setuj podrazumijevano ime
        if (s == null || s.isEmpty()) {
            return "Nepoznato";
        }
        return s;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = normalizeName(name);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) health = 0;
        if (health > 100) health = 100;
        this.health = health;
    }

    @Override
    public String toString() {
        return String.format("Player[%s] @ (%d,%d) %dx%d HP=%d",
                name, x, y, width, height, health);
    }
}