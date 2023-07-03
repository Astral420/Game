package main;
import entity.Entity;
public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity){

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;

        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.TileSize;
        int entityRightCol = entityRightWorldX/gp.TileSize;

        int entityTopRow = entityTopWorldY/gp.TileSize;
        int entityBottomRow = entityBottomWorldY/gp.TileSize;

        int tileNum1, tileNum2;

        switch(entity.Direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.TileSize;
                tileNum1 = gp.TileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.TileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.TileM.tile[tileNum1].collision == true || gp.TileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.TileSize;
                tileNum1 = gp.TileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.TileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.TileM.tile[tileNum1].collision == true || gp.TileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.TileSize;
                tileNum1 = gp.TileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.TileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.TileM.tile[tileNum1].collision == true || gp.TileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.TileSize;
                tileNum1 = gp.TileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.TileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.TileM.tile[tileNum1].collision == true || gp.TileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;

        }
    }
    public int checkObj(Entity entity, boolean player){
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++){
            if (gp.obj[i] != null){

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;

                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;



                switch (entity.Direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            System.out.println("up");
                            if (gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            System.out.println("down");
                            if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                                if (gp.obj[i].collision == true) {
                                    entity.collisionOn = true;
                                }
                                if (player == true) {
                                    index = i;
                                }

                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            System.out.println("left");
                            if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                                if (gp.obj[i].collision == true) {
                                    entity.collisionOn = true;
                                }
                                if (player == true) {
                                    index = i;
                                }
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            System.out.println("right");
                            if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                                if (gp.obj[i].collision == true) {
                                    entity.collisionOn = true;
                                }
                                if (player == true) {
                                    index = i;
                                }
                            }
                            break;
                        }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }

        }

        return index;
    }
    
    public int checkEntity(Entity entity, Entity[] target){
        int index = 999;
        for (int i = 0; i < target.length; i++){
            if (target[i] != null){

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;

                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;



                switch (entity.Direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            System.out.println("up");
                                entity.collisionOn = true;
                                index = i;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)) {
                            System.out.println("down");
                                    entity.collisionOn = true;
                                    index = i;
                            }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            System.out.println("left");
                                    entity.collisionOn = true;
                                    index = i;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(target[i].solidArea)){
                            System.out.println("right");
                                    entity.collisionOn = true;
                                    index = i;
                            break;
                        }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }

        }

        return index;
    }
    
    public void checkPlayer(Entity entity){

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.player.solidArea.x = gp.player.solidAreaDefaultX;
                gp.player.solidArea.y = gp.player.solidAreaDefaultY;

                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
                gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;



                switch (entity.Direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.player.solidArea)){
                            System.out.println("up");
                                entity.collisionOn = true;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.player.solidArea)) {
                            System.out.println("down");
                                    entity.collisionOn = true;
                            }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.player.solidArea)){
                            System.out.println("left");
                                    entity.collisionOn = true;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.player.solidArea)){
                            System.out.println("right");
                                    entity.collisionOn = true;
                            break;
                        }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.player.solidArea.x = gp.player.solidAreaDefaultX;
                gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            
    }
    
}
