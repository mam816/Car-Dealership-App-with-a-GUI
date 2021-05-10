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
class Lamborghini extends Car {

    
    public Lamborghini() {
        // implement this constructor based on the information shown in the video
    price = 35000.00;
    factoryAccessories = new ArrayList();  
    photoList = new ArrayList(); 
    String[] lamboCarColors = {"Silver","Green"};
    availableColors = FXCollections.observableArrayList(lamboCarColors);
    String[] accessories = {"Power Windows", "Air Conditioner"};
    carGeneralDescription = "Lamborghini is an Italian brand and manufacturer of luxury sports cars and SUVs based in Sant'Agata Bolognese.\nThe company is owned by the Volkswagen Group through its subsidiary Audi.";
    
    for(String access:accessories){
        factoryAccessories.add(access);
    }
    String[] photo = {"lamborghini_silver.gif","lamborghini_green.gif"};
    
    for(String carPhoto: photo){
        photoList.add(carPhoto);
    }
    }
    
   
    public String getDescription(){
        return this.carGeneralDescription;
    }
    
   public List <String> getAccessories(){
       return factoryAccessories;
   }
   
  
   public List <String> getColors(){
    return availableColors;
   }
   
 public double getPrice(){
        return price;
    }
} 

