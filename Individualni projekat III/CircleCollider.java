package vjezbeXII;

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

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other == null) return false;
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            long dx = (long) this.x - c.x;
            long dy = (long) this.y - c.y;
            long dist2 = dx * dx + dy * dy;
            long rsum = this.radius + c.radius;
            return dist2 <= (long) rsum * rsum;
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            double halfW = r.getWidth() / 2.0;
            double halfH = r.getHeight() / 2.0;
            double left = r.getX() - halfW;
            double right = r.getX() + halfW;
            double top = r.getY() - halfH;
            double bottom = r.getY() + halfH;

            double closestX = clamp(this.x, left, right);
            double closestY = clamp(this.y, top, bottom);

            double dx = this.x - closestX;
            double dy = this.y - closestY;
            double dist2 = dx * dx + dy * dy;
            return dist2 <= (double) this.radius * this.radius;
        }
        return false;
    }

    private double clamp(double val, double min, double max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }
}
