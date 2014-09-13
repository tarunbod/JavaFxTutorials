package javafxapplication26;

import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 Welcome! This is JavaFx Tutorial 2.

 In the last tutorial, we covered a button that when clicked, changed it's text to "Hello World!".
 This tutorial, we will be learning more about buttons.
 */
public class JavaFxTutorial2 extends Application {

    @Override
    public void start(Stage stage) {
        
        // Buttons are very easy to create. The button class has 3 constructors.
        // Constructor 1, creates an empty button.
        Button btn1 = new Button();
        // We will make this button change some text.
        btn1.setText("This button will change the text's color.");
        // Constructor 2, create a button with the specified text. We will add a tooltip to this button.
        Button btn2 = new Button("Hover your mouse over me!");
        // Constructor 3, create a button with text and a graphic. (We'll cover images later, but I'm using a smiley.jpg as the graphic.)
        Button btn3 = new Button("I have an image!", new ImageView(new Image(getClass().getResourceAsStream("smiley.jpg"))));
        
        
        // Here's how to set the code that runs when a button is pressed.
        // Anything that can trigger code when activated (such as a button) has a specific event handler called
        // an ActionEvent. There are also many types of events, such as keydown, keyup, dragstart, etc.
        // Today, we'll be using ActionEvents for the buttons.
        
        // Create an empty text node. Text is what you use to display, well, text.
        // We will change the this text when btn1 is clicked.
        final Text text = new Text("");
        // Have to make it final since we will be accessing it in an inner class.
        
        // Set the event handler for when button action is performed.
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Method that handles the event.
            public void handle(ActionEvent event) {
                // Put your code in here.
                
                // Set the text to "Buttons are cool!"
                text.setText("Buttons are cool!");
                Random rand = new Random();
                // Change the color of the text to a random color.
                text.setFill(Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            }
        });
        
        // You can set tooltips on buttons and pretty much everything in JavaFX.
        btn2.setTooltip(new Tooltip("This is a button with a tooltip!"));
        
        // And set the font of the button.
        Font font = Font.loadFont(getClass().getResourceAsStream("Minecraftia.ttf"), 12);
        btn3.setFont(font);
        // Create a new VBox (A container with vertical layout)
        // With 10 pixels of spacing in between the buttons, and our 3 buttons and the text as it's children.
        VBox root = new VBox(10, btn1, text, btn2, btn3);
        // Center the buttons
        root.setAlignment(Pos.CENTER);
        // New scene with stackpane as it's root.
        Scene scene = new Scene(root, 300, 300);

        // Set the title of the window.
        stage.setTitle("Hello World!");
        // Set the scene of the stage. All stages have a scene to show when application starts.
        stage.setScene(scene);
        // Stop user from resizing window
        stage.setResizable(false);
        // Show the stage, meaning open the window.
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
