package DPATSimple;

import javax.swing.*;

public class Game extends JPanel {
    static EnemyManager em = new EnemyManager();
    public Game() {
        setSize(640, 640);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
        //em.spawnEnemy("Zombie");
        while (em.areThereMoreEnemies()) {
            if (em.getEnemies().size() == 0) em.spawnEnemies();
            if (em.isTimeToSpawn()) {
                em.spawnEnemies();
            }
            em.update();
        }
    }

}