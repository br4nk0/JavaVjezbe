package vjezbeIX;

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
        String cleaned = name.trim().replaceAll("\\s+", " ");
        if (cleaned.isEmpty()) throw new IllegalArgumentException("Ime ne moze biti prazno");
        String[] parts = cleaned.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String p = parts[i];
            if (p.isEmpty()) continue;
            String cap = p.substring(0,1).toUpperCase() + (p.length() > 1 ? p.substring(1).toLowerCase() : "");
            if (i > 0) sb.append(' ');
            sb.append(cap);
        }
        String result = sb.toString();
        this.name = result;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) throw new IllegalArgumentException("Health mora biti izmedju 0 i 100");
        this.health = health;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Player [%s] @ (%d,%d) %s HP=%d", name, getX(), getY(), getCollider().getDescription(), health);
    }
}
