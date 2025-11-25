package vjezbeIX;

public interface Collidable {
    boolean intersects(Collidable other);
    void setPosition(int x, int y);
    String getDescription();
    int getX();
    int getY();
}