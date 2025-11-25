package vjezbeIX;

public class BossEnemy extends Enemy {
    public BossEnemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(type, x, y, collider, damage, health);
    }

    @Override
    public int getEffectiveDamage() {
        return Math.min(100, super.getEffectiveDamage() * 2);
    }

    @Override
    public String toString() {
        return String.format("BossEnemy[%s] @ (%d,%d) %s DMG=%dx2 HP=%d", getDisplayName(), getX(), getY(), getCollider().getDescription(),
        		getDamage(), getHealth());
    }
}
