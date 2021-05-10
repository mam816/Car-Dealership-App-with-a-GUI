package cardealerappwithgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Brenno
 */
public class FXMLDocumentController implements Initializable {

    private Lamborghini lamborghini;
    private Ferrari ferrari;
    private Porshe porshe;
    private Car selectedCar;
    
    private Lamborghini newLambo;
    private Ferrari newFerrari;
    private Porshe newPorshe; 
    
    
    @FXML
    private Label invoiceLB;

    @FXML
    private Button resetBT;

    @FXML
    private Button exitBT;

    @FXML
    private CheckBox optionalPowerLocksCB;

    @FXML
    private CheckBox optionalPowerWindowsCB;

    @FXML
    private CheckBox optionalAirConditionerCB;

    @FXML
    private ImageView carPhotoIW;

    @FXML
    private TextArea orderDescriptionTA;

    @FXML
    private ChoiceBox<String> carTypeCB;

    @FXML
    private ChoiceBox<String> carColorCB;

    @FXML
    private RadioButton insurance3yearsRB;

    @FXML
    private ToggleGroup insurance;

    @FXML
    private RadioButton insurance1yearRB;

    @FXML
    private RadioButton insuranceNoWarrantyRB;

    @FXML
    private BorderPane borderPaneID;

    @FXML
    private ImageView dealerShipLogoIV;

    private double price;
    private double price1;
    private double price2;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addDealershipLogo();
        addListenersToChoiceBoxes();
        createCars();
        initializeCarTypeChoiceBox();
    }

    private void addDealershipLogo() {
    
    Image image = new Image(getClass().getResourceAsStream("/resources/images/dealershipLogo.jpg"));
    dealerShipLogoIV.setImage(image);    

    }

    private void addListenersToChoiceBoxes() {
        carTypeCB.valueProperty().addListener((observable) -> {
            setSelectedCar();
            setCarColorsChoiceBox();
            setOptionals();
            setImageDisplay();
            setWarrantyToDefault();
            uncheckPreviouslySelectedOptionals();
            setOrderTextArea();
            recalculateOrderPrice();

        });
        carColorCB.valueProperty().addListener((observable) -> {
            setImageDisplay();
            setOrderTextArea();
        });
    }

    private void uncheckPreviouslySelectedOptionals() {
        // when you select a new car type, set all the optional checkboxes
        // to false as a starting point
        optionalPowerLocksCB.setSelected(false);
        optionalPowerWindowsCB.setSelected(false);
        optionalAirConditionerCB.setSelected(false); 
    }

    private void setWarrantyToDefault() {
        // set the 1 year warranty as default when selecting a new car type
        insurance1yearRB.setSelected(true);
        insurance1yearRB.requestFocus();
    }

    @FXML
    void onRadioButtonChange(ActionEvent event) {
        setOrderTextArea();
        recalculateOrderPrice();
    }

    @FXML
    void onOptionalsChanged(ActionEvent event) {
        setOrderTextArea();
        recalculateOrderPrice();
    }

    private void recalculateOrderPrice() {
        // calculate the price to be paid based on the selections made
        // try to use the next methods to get the prices for optionals and
        // warranty, and car type.
        
        // and then set the price label to that value
        newLambo = new Lamborghini();
        newFerrari = new Ferrari();
        newPorshe = new Porshe();
        //double options = getOptionalsPrice();
        //double totalWarranty = getSelectedWarrantyPrice();
       if(carTypeCB.getValue().equals("Lamborghini")){
       //     double carPrice1 = newLambo.getPrice();
            //double options = getOptionalsPrice();
            //double totalWarranty = getSelectedWarrantyPrice();
         //   System.out.println(newLambo.getPrice()+getOptionalsPrice());
            price = getOptionalsPrice()+getSelectedWarrantyPrice() + 35000.0;//+carPrice1;
            
            invoiceLB.setText(Double.toString(price));
        }
        else if(carTypeCB.getValue().equals("Ferrari")){
          //  double carPrice2 = newFerrari.getPrice();
           // double options = getOptionalsPrice();
           // double totalWarranty = getSelectedWarrantyPrice();
            
            price1 = getOptionalsPrice()+getSelectedWarrantyPrice()+45000.0;//+carPrice2;
            invoiceLB.setText(Double.toString(price1));
        }
       else{
       if(carTypeCB.getValue().equals("Porshe")){
          //  double carPrice3 = newPorshe.getPrice();
            //double options = getOptionalsPrice();
            //double totalWarranty = getSelectedWarrantyPrice();
          
            price2 = getOptionalsPrice()+getSelectedWarrantyPrice()+55000.0;//+carPrice3;
            invoiceLB.setText(Double.toString(price2));
        }
        }
            
       }

    private double getOptionalsPrice() {
        double optionals = 0.0;
        if(optionalPowerLocksCB.isSelected()){
            optionals += 3000.0;
            //return optionals;
        }
        if(optionalPowerWindowsCB.isSelected()){
             optionals += 2500.0;
             //return optionals;
        }
        if(optionalAirConditionerCB.isSelected()){
             optionals += 4000.0;
             //return optionals;
        }
        return optionals;
    }

    private double getSelectedWarrantyPrice() {
        double carWarranty = 0.0;
        if(insurance1yearRB.isSelected()){
            carWarranty += 0.0;
            //return carWarranty;
        }
        if(insurance3yearsRB.isSelected()){
           carWarranty += 7000.0 ;
           //return carWarranty;
        }
        if(insuranceNoWarrantyRB.isSelected()){
            carWarranty += -5000.0;
            //return carWarranty;
        }
      return carWarranty;
    }

    private void setOrderTextArea() {
        // put general car description
          lamborghini = new Lamborghini();
          porshe = new Porshe();
          ferrari = new Ferrari();
          if(carTypeCB.getValue().equals("Lamborghini")){
             orderDescriptionTA.setText("Description: "+lamborghini.getDescription()+"\nChosen Color: "+carColorCB.getValue()+"\nWarranty Selected: "+getChosenWarranty()
          +"\nOptionals Chosen: "+getOptionalAccessories());
            // invoiceLB.setText(Double.toString(lamborghini.getPrice()));
          }
          if(carTypeCB.getValue().equals("Ferrari")){
             orderDescriptionTA.setText("Description: "+ferrari.getDescription()+"\nChosen Color: "+carColorCB.getValue()+"\nWarranty Selected: "+getChosenWarranty()
          +"\nOptionals Chosen: "+getOptionalAccessories());
            // invoiceLB.setText(Double.toString(ferrari.getPrice()));
          }
          if(carTypeCB.getValue().equals("Porshe")){
             orderDescriptionTA.setText("Description: "+porshe.getDescription()+"\nChosen Color: "+carColorCB.getValue()+"\nWarranty Selected: "+getChosenWarranty()
          +"\nOptionals Chosen: "+getOptionalAccessories());
             //invoiceLB.setText(Double.toString(porshe.getPrice()));
          }
           
        // get car color
        // get chosen warranty text
        // get chosen optionals
        // set order text area with the text from above get statements
    }

    private String getOptionalAccessories() {
      String selectedAccess = "No optional have been selected";
      
      if(optionalPowerWindowsCB.isSelected()&& optionalPowerLocksCB.isSelected() && optionalAirConditionerCB.isSelected() ){
          selectedAccess = "";
          selectedAccess += optionalPowerWindowsCB.getText()+" "+optionalPowerLocksCB.getText()+" "+optionalAirConditionerCB.getText();  
          return selectedAccess;
           }
      if(optionalPowerWindowsCB.isSelected() && optionalAirConditionerCB.isSelected()){
          selectedAccess ="" ;
          selectedAccess += optionalPowerWindowsCB.getText()+" "+optionalAirConditionerCB.getText();
          return selectedAccess;
      }
       if(optionalPowerWindowsCB.isSelected() && optionalPowerLocksCB.isSelected()){
          selectedAccess ="" ;
          selectedAccess += optionalPowerWindowsCB.getText()+" "+optionalPowerLocksCB.getText();
          return selectedAccess;
           }
         if(optionalPowerLocksCB.isSelected() && optionalAirConditionerCB.isSelected()){
          selectedAccess ="" ;
          selectedAccess += optionalPowerLocksCB.getText()+" "+optionalAirConditionerCB.getText();
          return selectedAccess;
           }
          if(optionalAirConditionerCB.isSelected()){
          selectedAccess = "";
          selectedAccess += optionalAirConditionerCB.getText();
           }
          if(optionalPowerWindowsCB.isSelected()){
          selectedAccess = "";
          selectedAccess += optionalPowerWindowsCB.getText();
           }
           if(optionalPowerLocksCB.isSelected()){
          selectedAccess = "";
          selectedAccess += optionalPowerLocksCB.getText();
          return selectedAccess;
      }
          
         
          //if(optionalPowerLocksCB.isSelected()&& optionalPowerWindowsCB.isSelected() && optionalAirConditionerCB.isSelected() ){
          //selectedAccess = "";
          //selectedAccess += optionalPowerLocksCB.getText()+" "+optionalPowerWindowsCB.getText()+" "+optionalAirConditionerCB.getText();  
          //return selectedAccess;
          // }
          //if(optionalAirConditionerCB.isSelected()&& optionalPowerLocksCB.isSelected() && optionalPowerWindowsCB.isSelected() ){
          //selectedAccess = "";
          //selectedAccess += optionalAirConditionerCB.getText()+" "+optionalPowerLocksCB.getText()+" "+optionalPowerWindowsCB.getText();  
          //return selectedAccess;
           //}
          //if(optionalPowerWindowsCB.isSelected()&& optionalAirConditionerCB.isSelected() && optionalPowerLocksCB.isSelected() ){
          //selectedAccess = "";
          //selectedAccess += optionalPowerWindowsCB.getText()+" "+optionalAirConditionerCB.getText()+" "+optionalPowerLocksCB.getText();  
          //return selectedAccess;
           //}
          //if(optionalAirConditionerCB.isSelected()&& optionalPowerWindowsCB.isSelected() && optionalPowerLocksCB.isSelected() ){
          //selectedAccess = "";
          //selectedAccess += optionalAirConditionerCB.getText()+" "+optionalPowerWindowsCB.getText()+" "+optionalPowerLocksCB.getText();  
          //return selectedAccess;
           //}
          //if(optionalPowerLocksCB.isSelected()&& optionalAirConditionerCB.isSelected() && optionalPowerWindowsCB.isSelected() ){
          //selectedAccess = "";
          //selectedAccess += optionalPowerLocksCB.getText()+" "+optionalAirConditionerCB.getText()+" "+optionalPowerWindowsCB.getText();  
          //return selectedAccess;
          // 
      return selectedAccess;
    }
    

    private String getChosenWarranty() {
        String warranty = "1 year";
      if(insurance1yearRB.isSelected()){
          warranty = "";
         warranty += insurance1yearRB.getText();
      }
      if(insurance3yearsRB.isSelected()){
         warranty = "";
         warranty += insurance3yearsRB.getText();
      }
      if(insuranceNoWarrantyRB.isSelected()){
          warranty = "";
         warranty += insuranceNoWarrantyRB.getText();
      }
      return warranty;
    }

    private void initializeCarTypeChoiceBox() {
        String[] items = {"Lamborghini","Ferrari","Porshe"};
        ObservableList<String> list = FXCollections.observableArrayList(items);
        carTypeCB.setItems(list);
        carTypeCB.getSelectionModel().selectFirst();
    }

    private void setSelectedCar() {
        newLambo = new Lamborghini();
        newFerrari = new Ferrari();
        newPorshe = new Porshe();
        String carName = carTypeCB.getValue();
        if(carName.equals("Lamborghini")){
            selectedCar = lamborghini;
           // invoiceLB.setText(Double.toString(newLambo.getPrice()));
        }
        if(carName.equals("Ferrari")){
            selectedCar = ferrari;
          // invoiceLB.setText(Double.toString(newFerrari.getPrice()));
        }
        if(carName.equals("Proshe")){
            selectedCar = porshe;
            //invoiceLB.setText(Double.toString(newPorshe.getPrice()));
    }
         //get the car string name from the choicebox and then set
         //the class field "selectedCar" with the specific car object 
        // such as lamborghini or ferrari object.
    }

    private void setOptionals() {
        if(carTypeCB.getValue().equals("Lamborghini")){   
            optionalPowerWindowsCB.setDisable(false);
            optionalPowerLocksCB.setDisable(false);
            optionalAirConditionerCB.setDisable(false);
           
            optionalPowerWindowsCB.setDisable(true);
            optionalAirConditionerCB.setDisable(true);
            optionalPowerLocksCB.setDisable(false);
        }
        else if(carTypeCB.getValue().equals("Ferrari")){
            optionalPowerWindowsCB.setDisable(false);
            optionalPowerLocksCB.setDisable(false);
            optionalAirConditionerCB.setDisable(false);
            
            optionalPowerLocksCB.setDisable(true);
            optionalAirConditionerCB.setDisable(false);
            optionalPowerWindowsCB.setDisable(false);
        }
        else{
            if(carTypeCB.getValue().equals("Porshe")){
            optionalPowerWindowsCB.setDisable(false);
            optionalPowerLocksCB.setDisable(false);
            optionalAirConditionerCB.setDisable(false);  
                
            optionalPowerLocksCB.setDisable(false);
            optionalAirConditionerCB.setDisable(false);
            optionalPowerWindowsCB.setDisable(false);
            }
        }
        }  
    

    private void setImageDisplay() {
        // get car color from choicebox
        // get image of the car for that given color. The list of car images
        // are given in the car object.
        // set the car photo image view to display that image
       // String color = carColorCB.getValue();
        if(carTypeCB.getValue().equals("Lamborghini")){ 
        String color = carColorCB.getValue();
            if(color.equals("Silver")){
            Image image = new Image(getClass().getResourceAsStream("/resources/images/lamborghini_silver.gif"));
            carPhotoIW.setImage(image); 
            }
            if(color.equals("Green")){
            Image image = new Image(getClass().getResourceAsStream("/resources/images/lamborghini_green.gif"));
            carPhotoIW.setImage(image); 
            }
        }
        else if(carTypeCB.getValue().equals("Ferrari")){
        String color = carColorCB.getValue();
             if(color.equals("White")){
              Image image = new Image(getClass().getResourceAsStream("/resources/images/ferrari_white.gif"));
              carPhotoIW.setImage(image); 
                }
             if(color.equals("Red")){
            Image image = new Image(getClass().getResourceAsStream("/resources/images/ferrari_red.gif"));
            carPhotoIW.setImage(image); 
               }
            if(color.equals("Yellow")){
            Image image = new Image(getClass().getResourceAsStream("/resources/images/ferrari_yellow.gif"));
            carPhotoIW.setImage(image); 
              }
        
        }
        else{
            if(carTypeCB.getValue().equals("Porshe")){
                String color = carColorCB.getValue();
                if(color.equals("White")){
                Image image = new Image(getClass().getResourceAsStream("/resources/images/porshe_white.gif"));
                carPhotoIW.setImage(image); 
                }
                if(color.equals("Black")){
            Image image = new Image(getClass().getResourceAsStream("/resources/images/porshe_black.gif"));
            carPhotoIW.setImage(image); 
            }
                if(color.equals("Blue")){
            Image image = new Image(getClass().getResourceAsStream("/resources/images/porshe_blue.gif"));
            carPhotoIW.setImage(image); 
            }
            }
        }
    }
    

    private void setCarColorsChoiceBox() {
      
        if(carTypeCB.getValue().equals("Lamborghini")){
        String[] lamboColors = {"Silver", "Green"};
        ObservableList<String> listTwo = FXCollections.observableArrayList(lamboColors);
        carColorCB.setItems(listTwo);
        carColorCB.getSelectionModel().selectFirst();
        //Image image = new Image(getClass().getResourceAsStream("/resources/images/lamborghini_silver.gif"));
        //carPhotoIW.setImage(image);
        }
        else if(carTypeCB.getValue().equals("Ferrari")){
        String[] ferrariColors = {"White","Red","Yellow"};
        ObservableList<String> listThree = FXCollections.observableArrayList(ferrariColors);
        carColorCB.setItems(listThree);
        carColorCB.getSelectionModel().selectFirst();
        }
        else{
        if(carTypeCB.getValue().equals("Porshe")){
        String[] porsheColors = {"White", "Black","Blue"};
        ObservableList<String> listFour = FXCollections.observableArrayList(porsheColors);
        carColorCB.setItems(listFour);
        carColorCB.getSelectionModel().selectFirst();
        }
        }
    }

    private void createCars() {
        // just set class fiels like lamborghini to a new Lamborghini car
        // same for the other cars. These objects will be used in your code later
        lamborghini = new Lamborghini();
        ferrari = new Ferrari();
        porshe = new Porshe();
        
      //  newLambo = new Lamborghini();
        //newFerrari = new Ferrari();
        //newPorshe = new Porshe();
    }

    @FXML
    void onExitButtonClicked(ActionEvent event) {
       
       int answer = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit");
       if(answer == JOptionPane.YES_OPTION){
          System.exit(0);
       }
    }

    @FXML
    void onSaveOrderButtonClicked(ActionEvent event) throws FileNotFoundException {
       JFileChooser j = new JFileChooser("d:"); 
       j.showSaveDialog(null); 
       String completeOrder = invoiceLB.getText()+"\n"+orderDescriptionTA.getText();
       //String descriptionBox = orderDescriptionTA.getText();
       PrintWriter writer;
        try {
            writer = new PrintWriter("myOrder.txt", "UTF-8");
            writer.println(completeOrder);
            writer.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
}
