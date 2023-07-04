package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Obstacle extends SuperObj {
    public Obj_Obstacle(){
    name = "Obstacle";
        try {
        img = ImageIO.read(getClass().getResourceAsStream("/objs/obstacle.png"));

    }catch (
    IOException e){
        e.printStackTrace();
    }
    collision = true;
}
}
