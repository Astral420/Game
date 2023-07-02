package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Question extends SuperObj{

    public Obj_Question(){
        name = "Question";
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/objs/questionmark.png"));
        }catch (IOException e){
        e.printStackTrace();
        }
        collision = true;
    }
}
