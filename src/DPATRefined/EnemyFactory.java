package DPATRefined;

import java.util.HashMap;

public class EnemyFactory {
    private static HashMap<String, Enemy> enemyByType = new HashMap<>();
    public static Enemy getEnemy(String enemyType) {
        Enemy enemy = enemyByType.get(enemyType);
        if(enemy == null) {
            switch(enemyType) {
                case "Zombie":
                    enemy = new Zombie(0, -10, 50);
                    break;
                case "Skeleton":
                    enemy = new Skeleton(0, -10, 50);
                    break;
            };
            enemyByType.put(enemyType, enemy);
        }
        return enemy;
    }
}
