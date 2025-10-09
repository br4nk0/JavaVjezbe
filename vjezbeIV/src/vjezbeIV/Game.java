package vjezbeIV;

public class Game {
    static class Player {
        private int x;
        private int y;
        private int health;
        private int width;
        private int height;

        // Getters
        public int getX() { return x; }
        public int getY() { return y; }
        public int getHealth() { return health; }
        public int getWidth() { return width; }
        public int getHeight() { return height; }

        // Setters
        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }
        public void setHealth(int health) {
            if (health < 0) {
                this.health = 0;
            } else if (health > 100) {
                this.health = 100;
            } else {
                this.health = health;
            }
        }
        public void setWidth(int width) { this.width = width; }
        public void setHeight(int height) { this.height = height; }
    }

    static class Enemy {
        private int x;
        private int y;
        private int damage;
        private int width;
        private int height;

        // Getters
        public int getX() { return x; }
        public int getY() { return y; }
        public int getDamage() { return damage; }
        public int getWidth() { return width; }
        public int getHeight() { return height; }

        // Setters
        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }
        public void setDamage(int damage) {
            if (damage < 0) {
                this.damage = 0;
            } else if (damage > 100) {
                this.damage = 100;
            } else {
                this.damage = damage;
            }
        }
        public void setWidth(int width) { this.width = width; }
        public void setHeight(int height) { this.height = height; }
    }

    static class CheckCollision {
        // Provjera da li je doslo do kolizije izmedju igraca i neprijatelja
        public static boolean checkCollision(Player p, Enemy e) {
            return (p.getX() < e.getX() + e.getWidth() &&
                    p.getX() + p.getWidth() > e.getX() &&
                    p.getY() < e.getY() + e.getHeight() &&
                    p.getY() + p.getHeight() > e.getY());
        }
        // Ako ima kolizije smanji zdravlje igraca za vrijednost damage neprijatelja
        public static void resolveCollision(Player p, Enemy e) {
            if (checkCollision(p, e)) {
                int noviHealth = p.getHealth() - e.getDamage();
                if (noviHealth < 0) noviHealth = 0;
                p.setHealth(noviHealth);
                System.out.println("Kolizija! Zdravlje igraca: " + p.getHealth());
            }
        }
    }

    // Testiranje sa jednim igracem i dva neprijatelja
    public static void main(String[] args) {
        Player p = new Player();
        p.setX(50);
        p.setY(50);
        p.setWidth(30);
        p.setHeight(30);
        p.setHealth(100);

        Enemy e1 = new Enemy();
        e1.setX(60);
        e1.setY(60);
        e1.setWidth(30);
        e1.setHeight(30);
        e1.setDamage(20);

        Enemy e2 = new Enemy();
        e2.setX(200);
        e2.setY(200);
        e2.setWidth(30);
        e2.setHeight(30);
        e2.setDamage(30);

        CheckCollision.resolveCollision(p, e1); // ocekivana kolizija
        CheckCollision.resolveCollision(p, e2); // ne ocekivana kolizija
    }
}