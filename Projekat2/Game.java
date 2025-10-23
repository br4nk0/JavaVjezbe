package vjezbeVI;
//Branko Pejanovic 24/028 
//Matija Vukovic 24/063

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private List<Enemy> enemies;
    private List<String> eventLog;

    public Game() {
        this(new Player("Player", 0, 0, 32, 32, 100));
    }

    public Game(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
        this.eventLog = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<String> getEventLog() {
        return eventLog;
    }

    // provjerava sudar pravougaonika
    public boolean checkCollision(Player p, Enemy e) {
        int px1 = p.getX();
        int py1 = p.getY();
        int px2 = px1 + p.getWidth();
        int py2 = py1 + p.getHeight();

        int ex1 = e.getX();
        int ey1 = e.getY();
        int ex2 = ex1 + e.getWidth();
        int ey2 = ey1 + e.getHeight();

        boolean overlapX = px1 < ex2 && ex1 < px2;
        boolean overlapY = py1 < ey2 && ey1 < py2;
        return overlapX && overlapY;
    }

    // smanjuje health igraca za damage neprijatelja
    public void decreaseHealth(Player p, Enemy e) {
        int oldHp = p.getHealth();
        int damage = e.getDamage();
        int newHp = oldHp - damage;
        if (newHp < 0) newHp = 0;
        p.setHealth(newHp);
        String msg = String.format("HIT: Player by %s for %d -> HP %d->%d",
                e.getType(), damage, oldHp, newHp);
        eventLog.add(msg);
    }

    // dodaje neprijatelja i upisuje dogadjaj u log
    public void addEnemy(Enemy e) {
        enemies.add(e);
        String msg = String.format("ADD: Enemy %s @ (%d,%d)", e.getType(), e.getX(), e.getY());
        eventLog.add(msg);
    }

    
    // lista neprijatelja koji se sudaraju sa igracem
    public List<Enemy> collidingWithPlayer() {
        List<Enemy> list = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) list.add(e);
        }
        return list;
    }

    // za svakog neprijatelja koji se sudara pozovi decreaseHealth
    public void resolveCollisions() {
        for (Enemy e : collidingWithPlayer()) {
            decreaseHealth(player, e);
        }
    }
}