package cardealerappwithgui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

class Porshe extends Car {

    public Porshe() {
        // implement this constructor based on the information shown in the video
    price = 55000.00;
    factoryAccessories = new ArrayList();  
    photoList = new ArrayList();  
    String[] porsheColors = {"White","Black","Blue"};
    availableColors = FXCollections.observableArrayList(porsheColors);
    String[] photo = {"porshe_white.gif","porshe_black.gif","porshe_blue.gif"};
    carGeneralDescription = "is a German automobile manufacturer specializing in high-performance sports cars, SUVs and sedans.";
    for(String carPhoto:photo){
        photoList.add(carPhoto);
    }
    }
    
   
    public String getDescription(){
        return this.carGeneralDescription;
    }
    
public List <String> getAccessories(){
       return this.factoryAccessories;
   }

  
    public ObservableList <String> getColors(){
    return this.availableColors;
}
  
    public double getPrice(){
        return price;
    }
   
    }  
    
   
    

    
   

