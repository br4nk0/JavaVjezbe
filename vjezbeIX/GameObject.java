package vjezbeIX;

public abstract class GameObject {
    private int x;
    private int y;
    private Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        if (collider == null) {
            throw new IllegalArgumentException("collider ne moze biti null");
        }
        this.x = x;
        this.y = y;
        this.collider = collider;
        this.collider.setPosition(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        if (this.collider != null) {
            this.collider.setPosition(x, y);
        }
    }

    public Collidable getCollider() {
        return collider;
    }

    public void setCollider(Collidable collider) {
        this.collider = collider;
        this.collider.setPosition(this.x, this.y);
    }

    public boolean intersects(GameObject other) {
        if (this.collider == null || other.collider == null) return false;
        return this.collider.intersects(other.collider);
    }

    public abstract String getDisplayName();

    @Override
    public String toString() {
        return String.format("%s @ (%d,%d) %s", getDisplayName(), x, y, collider.getDescription());
    }
}