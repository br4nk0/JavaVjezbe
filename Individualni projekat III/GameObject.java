package vjezbeXII;

public abstract class GameObject {
    private int x;
    private int y;
    private Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        setX(x);
        setY(y);
        if (collider == null) {
            throw new IllegalArgumentException("Collider ne moze biti null");
        }
        this.collider = collider;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        syncColliderPosition();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        syncColliderPosition();
    }

    public Collidable getCollider() {
        return collider;
    }

    public void setCollider(Collidable collider) {
        if (collider == null) {
            throw new IllegalArgumentException("Collider ne moze biti null");
        }
        this.collider = collider;
        syncColliderPosition();
    }

    private void syncColliderPosition() {
        if (this.collider == null) return;
        if (this.collider instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) this.collider;
            r.setX(this.x);
            r.setY(this.y);
        } else if (this.collider instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) this.collider;
            c.setX(this.x);
            c.setY(this.y);
        }
    }

    public boolean intersects(GameObject other) {
        if (other == null) return false;
        return this.collider.intersects(other.getCollider());
    }

    public abstract String getDisplayName();

    @Override
    public String toString() {
        return String.format("%s at (%d,%d)", getDisplayName(), x, y);
    }
}