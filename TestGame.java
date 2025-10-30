package vjezbeVI;

import java.util.List;

public class TestGame {
    public static void main(String[] args) {
    	
        Player player = new Player("Pera Peric", 10, 5, 32, 32, 100);
        Game game = new Game(player);

        Enemy e1 = new Enemy("Vasilije", 50, 50, 16, 16, 15);
        game.addEnemy(e1);
        
        Enemy e2 = new Enemy("Goblin", 20, 15, 16, 16, 25);
        game.addEnemy(e2);


        // ispiši sve neprijatelje
        System.out.println("Svi neprijatelji:");
        for (Enemy e : game.getEnemies()) {
            System.out.println(e);
        }

        System.out.println("\nPlayer prije sudara: " + game.getPlayer());

        System.out.println("\nEnemy koji se sudaraju sa playerom:");
        List<Enemy> colliding = game.collidingWithPlayer();
        for (Enemy e : colliding) {
            System.out.println(e);
        }

        // smanji health i ispisi stanje poslije
        game.resolveCollisions();
        System.out.println("\nPlayer posle sudara: " + game.getPlayer());

        // ispisi event log
        System.out.println("\nEvent log:");
        for (String msg : game.getEventLog()) {
            System.out.println(msg);
        }
    }

}