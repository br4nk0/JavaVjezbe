package vjezbeXII;

public class RectangleCollider implements Collidable {
    private int x; 
    private int y; 
    private int width;
    private int height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(" Width i height moraju biti pozitivni brojevi");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public int getHeight() {
        return height;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other == null) return false;
        if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            int halfW = this.width / 2;
            int halfH = this.height / 2;
            int otherHalfW = r.width / 2;
            int otherHalfH = r.height / 2;
            int dx = Math.abs(this.x - r.x);
            int dy = Math.abs(this.y - r.y);
            return dx <= (halfW + otherHalfW) && dy <= (halfH + otherHalfH);
        } else if (other instanceof CircleCollider) {
            // dodijeli na CircleCollider i iskoristi njegovu metodu
            return other.intersects(this);
        }
        return false;
    }
}