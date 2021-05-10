package cardealerappwithgui;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Car {
    // class fields
    protected ObservableList<String> availableColors;
    protected List<String> factoryAccessories;
    protected String carGeneralDescription;
    protected List<String> photoList;
    protected double price;
   
    
    public Image getCarPhotoForColor(String color) {
        int counter = 0;
        for (String currentColor : availableColors) {
            if (color.equalsIgnoreCase(currentColor)) {
                Image image = new Image(getClass().getResourceAsStream(
                        "/resources/images/" + photoList.get(counter)));
                return image;
            }
            counter++;
        }
        return null;
    }
}
    
   