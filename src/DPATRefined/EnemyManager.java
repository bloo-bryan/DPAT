package DPATRefined;

import java.util.ArrayList;

public class EnemyManager {
    ArrayList<Enemy> enemies = new ArrayList<>();
    int counter = 0;

    public EnemyManager() {
    }

    public void update() {
        for(Enemy e: enemies) {
            if(e.isAlive()) {
                e.move(e.getSpeed());
            }
        }
    }

    public void spawnEnemies() {
        for(int i = 0; i < 15; i++) {
            addEnemy("Zombie");
        }
        System.out.println("15 Zombies spawned");
        for(int i = 0; i < 5; i++) {
            addEnemy("Skeleton");
        }
        System.out.println("5 Skeletons spawned");
    }

    public void addEnemy(String enemyType) {
        enemies.add(EnemyFactory.getEnemy(enemyType));
    }

//    public BufferedImage draw() {
//        //g.drawImage()
//        BufferedImage image = null;
//        try {
//            image = ImageIO.read(new File());
//        } catch(Exception ex) {
//            System.out.println("Cannot find enemy model.");
//        }
//        return image;
//    }

    public boolean areThereMoreEnemies() {
        //System.out.println(enemies.size());
        return enemies.size() < 200;
    }

    public boolean isTimeToSpawn() {
        if(enemies.size() % 20 == 0) {
            for (int i = enemies.size() - 1; i >= enemies.size() - 20; i--) {
                if(enemies.get(i).getX() > 1) {
                    //System.out.println("1 enemy entered");
                    counter++;
                }
            }
            if(counter == 20)  {
                counter = 0;
                System.out.println("20 enemies spawned");
                return true;
            }
        }
        counter = 0;
        //System.out.println("counter reset.");
        return false;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
