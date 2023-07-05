
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Config {
    
    GamePanel gp;
    
    public Config(GamePanel gp){
        this.gp = gp;   
    }
    
  public void saveConfig(){
      try {
          BufferedWriter bw = new BufferedWriter(new FileWriter("res/config/config.txt"));
        bw.newLine();
        bw.write(String.valueOf(gp.music.volumeScale));
        bw.newLine();
        
        bw.write(String.valueOf(gp.SFX.volumeScale));
        bw.newLine();
        
        bw.close();
        
      } catch (Exception e) {
          e.printStackTrace();
      }
       
  } 
  public void loadConfig(){
      try {
            BufferedReader br = new BufferedReader(new FileReader("res/config/config.txt"));
            String s = br.readLine();
        
       s = br.readLine();
       gp.music.volumeScale = Integer.parseInt(s);
        
       s = br.readLine();
       gp.SFX.volumeScale = Integer.parseInt(s);
        
       
       br.close();
       
      } catch (Exception e) {
           e.printStackTrace();
      }
       
     
  }
    
}
