package vjezbeXII;

public class BossEnemy extends Enemy {
    public BossEnemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(type, x, y, collider, damage, health);
    }

    @Override
    public int getEffectiveDamage() {
        return super.getEffectiveDamage() * 2;
    }

    @Override
    public String toString() {
        return String.format("BossEnemy[type=%s, damage=%d, health=%d, pos=(%d,%d)]", getType(), getDamage(), getHealth(), getX(), getY());
    }
}
