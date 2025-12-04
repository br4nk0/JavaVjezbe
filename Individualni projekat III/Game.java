package vjezbeXII;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> log = new ArrayList<>();

    public Game(Player player) {
        this.player = player;
        log.add("Game created with player: " + player.getDisplayName());
    }

    public Player getPlayer() {
        return player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<String> getLog() {
        return log;
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int dmg = e.getEffectiveDamage();
        int old = p.getHealth();
        int updated = Math.max(0, old - dmg);
        p.setHealth(updated);
        log.add(String.format("%s was hit by %s for %d damage. Health %d -> %d", p.getDisplayName(), e.getDisplayName(), dmg, old, updated));
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        log.add("Added enemy: " + e.toString());
    }

    public List<Enemy> findByType(String query) {
        List<Enemy> result = new ArrayList<>();
        if (query == null) return result;
        String q = query.toLowerCase();
        for (Enemy e : enemies) {
            if (e.getType() != null && e.getType().toLowerCase().contains(q)) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Enemy> collidingWithPlayer() {
        List<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) result.add(e);
        }
        return result;
    }

    public void resolveCollisions() {
        for (Enemy e : new ArrayList<>(enemies)) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }
 // Predvidjeni CSV format:
    // type,class,x,y,collider_type,collider_params...,damage,health
    public static ArrayList<Enemy> loadEnemiesFromCSV(String filePath) throws IOException {
        File f = new File(filePath);
        if (!f.exists()) throw new IllegalArgumentException("CSV file not found: " + filePath);
        ArrayList<Enemy> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                
                String[] parts = line.split(",");
                if (parts.length < 7) {
                    throw new IllegalArgumentException("Nevazeci CSV format " + lineNo);
                }
                try {
                    String type = parts[0].trim();
                    String cls = parts[1].trim().toLowerCase();
                    int x = Integer.parseInt(parts[2].trim());
                    int y = Integer.parseInt(parts[3].trim());
                    String colliderType = parts[4].trim().toLowerCase();
                    Collidable collider = null;
                    int index = 5;
                    if (colliderType.equals("rect") || colliderType.equals("rectangle")) {
                        int width = Integer.parseInt(parts[index++].trim());
                        int height = Integer.parseInt(parts[index++].trim());
                        collider = new RectangleCollider(x, y, width, height);
                    } else if (colliderType.equals("circle")) {
                        int radius = Integer.parseInt(parts[index++].trim());
                        collider = new CircleCollider(x, y, radius);
                    } 
                    int damage = Integer.parseInt(parts[index++].trim());
                    int health = Integer.parseInt(parts[index++].trim());

                    Enemy e;
                    if (cls.equals("melee")) {
                        e = new MeleeEnemy(type, x, y, collider, damage, health);
                    } else if (cls.equals("boss")) {
                        e = new BossEnemy(type, x, y, collider, damage, health);
                    } else {
						e = new Enemy(type, x, y, collider, damage, health);
					}
                    list.add(e);
                } catch (Exception ex) {
					throw new IllegalArgumentException("Greska pri parsiranju linije " + lineNo + ": " + ex.getMessage());
                }
            }
        }
        return list;
    }
}