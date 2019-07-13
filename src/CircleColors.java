import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import java.util.Random;
import javafx.scene.effect.Reflection;

public class CircleColors extends Application
{
	Circle circle1 = new Circle(250, 250, 200, Color.DEEPPINK);			//instance of object
	
	public static void main(String[] args)
	{	
		Application.launch(args);
	}
	
	public void randomColor()		//method to generate random rgb values
	{
		Random rand = new Random();		//creating random object
		int random1 = rand.nextInt(255);		//sets variable to random value from 0 - 255
		int random2 = rand.nextInt(255);
		int random3 = rand.nextInt(255);
		circle1.setFill(Color.rgb(random1, random2, random3));		//fills object with 3 random rbg values
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("Logan's Event App");
		primaryStage.setResizable(false);		//cannot change size of the app
		
		BorderPane bp = new BorderPane();
		
		Reflection reflect = new Reflection();			//creating reflection effect instance
		reflect.setTopOpacity(0.2);
		reflect.setFraction(0.2);
		circle1.setEffect(reflect);			//sets the effect in the circle object
		
		circle1.setOnMouseEntered(e -> 
		{
			circle1.setScaleX(1.05);			//if the mouse overlaps with the object, change the size
			circle1.setScaleY(1.05);
		});
		
		circle1.setOnMouseExited(e -> 
		{
			circle1.setScaleX(1);			//if the mouse leaves the object, return object size to normal
			circle1.setScaleY(1);
		});
		
		circle1.setOnMouseClicked(e -> 
		{
			randomColor();				//if clicked, the object changes color
		});
		
		bp.getChildren().add(circle1);			//add a circle to the pane
		
		Scene scene = new Scene(bp, 500, 500, Color.BLACK);			//create new scene instance, including the pane with the object
		
		primaryStage.setScene(scene);		//set the scene in the stage
		primaryStage.show();			//allow the screen to appear
	}
	
}