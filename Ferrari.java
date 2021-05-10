package cardealerappwithgui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.image.Image;

/**
 *
 * @author Brenno
 */
class Ferrari extends Car {
    public Ferrari() {
        // implement this constructor based on the information shown in the video
    factoryAccessories = new ArrayList(); 
    photoList = new ArrayList(); 
    price = 45000.00;
    String[] colors = {"White","Red","Yellow"};
    availableColors = FXCollections.observableArrayList(colors);
    String[] photo = {"ferrari_white.gif","ferrari_red.gif","ferrari_yellow.gif"};
    for(String carPhoto:photo){
        photoList.add(carPhoto);
    }
    String[] accessories = {"Power Locks"};
    for(String access:accessories){
        factoryAccessories.add(access);
    }
   
    carGeneralDescription = "is an Italian luxury sports car manufacturer based in Maranello.\nFounded by Enzo Ferrari in 1939 out "
     + "of Alfa Romeo's race division as Auto Avio Costruzioni,"
     + "\nthe company built its first car in 1940.";
    }
    
   
    public String getDescription(){
        return this.carGeneralDescription;
    }
    
    public List <String> getAccessories(){
       return this.factoryAccessories;
   }
    
   
    public List <String> getColors(){
    return this.availableColors;
}
    
   public double getPrice(){
        return price;
    }
    }
   
    

