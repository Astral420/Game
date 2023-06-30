package objects;

import javax.imageio.ImageIO;

public class Obj_Kweba extends SuperObj{
    public Obj_Kweba() {
        name = "Cave";

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/kweba_entry/kweba4.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }


}
