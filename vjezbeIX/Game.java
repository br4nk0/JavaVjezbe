package vjezbeIX;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> eventLog = new ArrayList<>();

    public Game(Player player) {
        this.player = player;
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        eventLog.add(String.format("ADD: Neprijatelj %s dodat", e.getType()));
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int dmg = e.getEffectiveDamage();
        int old = p.getHealth();
        int neu = Math.max(0, old - dmg);
        p.setHealth(neu);
        eventLog.add(String.format("HIT: Player by %s za %d -> HP %d -> %d", e.getType(), dmg, old, neu));
    }

    public List<Enemy> findByType(String query) {
        ArrayList<Enemy> res = new ArrayList<>();
        if (query == null) return res;
        String q = query.toLowerCase();
        for (Enemy en : enemies) {
            if (en.getType().toLowerCase().contains(q)) res.add(en);
        }
        return res;
    }

    public List<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> res = new ArrayList<>();
        for (Enemy en : enemies) {
            if (checkCollision(player, en)) res.add(en);
        }
        return res;
    }

    public void resolveCollisions() {
        for (Enemy en : enemies) {
            try {
                if (checkCollision(player, en)) {
                    decreaseHealth(player, en);
                }
            } catch (IllegalArgumentException ex) {
                eventLog.add("ERROR in resolveCollisions: " + ex.getMessage());
            }
        }
    }

    public ArrayList<String> getEventLog() {
        return eventLog;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Player getPlayer() {
        return player;
    }

    public static Enemy parseEnemy(String line) {
        String[] parts = line.split(";");
        String type = parts[0];
        String coord = parts[1];
        String size = parts[2];
        String dmgToken = parts[3];
        String kind = parts.length >= 5 ? parts[4] : "";

        String[] xy = coord.split(",");
        try {
            int x = Integer.parseInt(xy[0].trim());
            int y = Integer.parseInt(xy[1].trim());
            Collidable col;
            if (size.contains("x")) {
                String[] wh = size.split("x");
                int w = Integer.parseInt(wh[0].trim());
                int h = Integer.parseInt(wh[1].trim());
                col = new RectangleCollider(x, y, w, h);
            } else if (size.startsWith("r=")) {
                int r = Integer.parseInt(size.substring(2).trim());
                col = new CircleCollider(x, y, r);
            } else {
                // fallback: treat as radius if single number
                if (size.matches("\\d+")) {
                    int r = Integer.parseInt(size);
                    col = new CircleCollider(x, y, r);
                } else {
					throw new IllegalArgumentException("Nepoznat format kolizije: " + size);
				}
            }
            int dmg = Integer.parseInt(dmgToken.trim());
            Enemy en;
            if ("boss".equalsIgnoreCase(kind)) {
                en = new BossEnemy(type, x, y, col, dmg, 100);
            } else {
                en = new MeleeEnemy(type, x, y, col, dmg, 100);
            }
            return en;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Broj koji se ocekuje: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Player p = new Player(" Petar Petrović ", 10, 5, new RectangleCollider(10, 5, 32, 32), 85);
        Game game = new Game(p);

        Enemy e1 = new MeleeEnemy("Goblin", 12, 5, new RectangleCollider(12, 5, 16, 16), 20, 60);
        game.addEnemy(e1);

        try {
            Enemy e2 = parseEnemy("Orc;20,10;8x8;15;boss");
            game.addEnemy(e2);
        } catch (IllegalArgumentException ex) {
			System.out.println("Greska pri parsiranju enemy-ja: " + ex.getMessage());
		}

        System.out.println("Svi enemies:");
        for (Enemy en : game.getEnemies()) System.out.println(en);

        System.out.println("Pronadji po tipu 'gob':");
        for (Enemy en : game.findByType("gob")) System.out.println(en);

        System.out.println("Player prije kolizija: " + game.getPlayer());
        System.out.println("Kolizija sa playerom:");
        for (Enemy en : game.collidingWithPlayer()) System.out.println(en);

        game.resolveCollisions();

        System.out.println("Player posle kolizija: " + game.getPlayer());

        System.out.println("Event log:");
        for (String s : game.getEventLog()) System.out.println(s);
    }
}
