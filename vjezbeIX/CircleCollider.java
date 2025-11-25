package vjezbeIX;

public class CircleCollider implements Collidable {
    private int x;
    private int y;
    private int radius;

    public CircleCollider(int x, int y, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius mora biti > 0");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public boolean intersects(Collidable other) {
        if (other == null) return false;
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            long dx = this.x - c.x;
            long dy = this.y - c.y;
            long r = this.radius + c.radius;
            return dx * dx + dy * dy <= (long) r * r;
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            int closestX = clamp(this.x, r.getX(), r.getX() + r.getWidth());
            int closestY = clamp(this.y, r.getY(), r.getY() + r.getHeight());
            long dx = this.x - closestX;
            long dy = this.y - closestY;
            return dx * dx + dy * dy <= (long) this.radius * this.radius;
        }
        return false;
    }

    private int clamp(int v, int a, int b) {
        if (v < a) return a;
        if (v > b) return b;
        return v;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getDescription() {
        return String.format("r=%d", radius);
    }

    @Override
    public int getX() { return x; }

    @Override
    public int getY() { return y; }

    public int getRadius() { return radius; }
}
