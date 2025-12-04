package vjezbeXII;

public class Player extends GameObject {
    private String name;
    private int health; 

    public Player(String name, int x, int y, Collidable collider, int health) {
        super(x, y, collider);
        setName(name);
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) name = "";
        name = name.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name ne moze biti prazno");
        }
        // Capitalize first letter
        this.name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health mora biti izmedu 0 i 100");
        }
        this.health = health;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Player[name=%s, health=%d, pos=(%d,%d)]", name, health, getX(), getY());
    }
}
