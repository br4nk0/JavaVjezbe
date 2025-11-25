package vjezbeIX;

public class RectangleCollider implements Collidable {
    private int x;
    private int y;
    private int width;
    private int height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Rectangle dimenzije moraju biti > 0");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other == null) return false;
        if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;
            return this.x < r.x + r.width && this.x + this.width > r.x
                    && this.y < r.y + r.height && this.y + this.height > r.y;
        } else if (other instanceof CircleCollider) {
        	
            return other.intersects(this);
        }
        return false;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getDescription() {
        return String.format("%dx%d", width, height);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
