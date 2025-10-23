package vjezbeVI;

public class Enemy {
    private String type;
    private int x;
    private int y;
    private int width;
    private int height;
    private int damage; // 0 - 100	

    public Enemy(String type, int x, int y, int width, int height, int damage) {
        setType(type);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setDamage(damage);
    }

    private String normalizeType(String s) {
        // ako je null ili prazan, setuj podrazumijevano ime
        if (s == null || s.isEmpty()) {
            return "Nepoznato";
        }
        return s;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = normalizeType(type);
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0) damage = 0;
        if (damage > 100) damage = 100;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return String.format("Enemy[%s] @ (%d,%d) %dx%d DMG=%d",
                type, x, y, width, height, damage);
    }
}