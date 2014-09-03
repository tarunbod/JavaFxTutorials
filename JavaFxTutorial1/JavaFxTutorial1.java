
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 Welcome! THis is JavaFx Tutorial 1.

 Every JavaFX application's main class must extend the class Application.
 It provides an abstract method start(), in which the stage (window) and scene (main background) will be initialized. Here is an example of a basic JavaFx application.
 */
public class JavaFxTutorial1 extends Application {

    @Override
    public void start(Stage stage) {
        // Create a new button
        final Button button = new Button();
        // set the text of the button to "Click me!"
        button.setText("Click Me!");
        // add an event handler for when an action is performed on the button.
        // Event handler is a functional interface, which means it can be used in lmbda expressions
        // if you are using Java 8.

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button.setText("Hello World!");
            }
        });

        // Here is an example of the above in Java 8 syntax.
        /*
         btn.setOnAction((event) -> System.out.println("Hello World!"))
         */
        // When we click the button, it sets the button's text to "Hello World!"
        
        // A stackpane is a basic container which centers it's children.
        StackPane root = new StackPane();
        // Now add the button to the StackPane's children.
        root.getChildren().add(button);

        // A scene is the main background for a JavaFx application.
        // Here we are making a new scene, with the root node as the stackpane, and
        // with a size of 300 x 300
        Scene scene = new Scene(root, 300, 300);

        // Set the title of the window.
        stage.setTitle("Hello World!");
        // Set the scene of the stage. All stages have a scene to show when application starts.
        stage.setScene(scene);
        // Show the stage, meaning open the window.
        stage.show();
    }

    // In JavaFx applications, the main method isn't used to launch the application.
    // Just in case something goes wrong (which it probably won't), You should call the 
    // launch(args)
    // method from the Application class in main.
    public static void main(String[] args) {
        launch(args);
    }

    /*
     This creates a basic JavaFx program.
     Note that if you are using Eclipse, you will need the e(fx)clipse plugin.
     If you are using netbeans, you can create a new JavaFx project from the new project window.
     I don't know about IntelliJ.
     */
}
