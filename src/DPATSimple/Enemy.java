package DPATSimple;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public abstract class Enemy {
    private int ID;
    private float x, y;
    private int HP;
    private String enemyType;
    private float speed;
    private boolean alive;
    String model;
    BufferedImage modelImage;

    public Enemy(int ID, float x, float y, String enemyType, int HP, float speed, String model) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.enemyType = enemyType;
        this.HP = HP;
        this.speed = speed;
        this.alive = true;
        this.model = model;
        this.modelImage = draw(model);
    }

//    public int GenerateID() {
//        ArrayList<Integer> numList = new ArrayList<>();
//        for(int i = 1; i <= 200; i++) {
//            numList.add(i);
//        }
//        Random random = new Random();
//        while(numList.size() > 0) {
//            int index = random.nextInt(numList.size());
//            return numList.remove(index);
//        }
//    }

    public BufferedImage draw(String model) {
        //g.drawImage()
        BufferedImage image = null;
        try {
            File path = new File(System.getProperty("user.dir"));
            image = ImageIO.read(new File(path, model));
            System.out.println("Model " + model + " loaded successfully.");
        } catch(Exception ex) {
            System.out.println("Cannot find enemy model.");
        }
        return image;
    }

    public void move(float speed) {
        this.x += speed;
    }

    public int getID() {
        return ID;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getHP() {
        return HP;
    }

    public String getEnemyType() {
        return enemyType;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getModel() {
        return model;
    }
}
