/*Tri Angle program
   2 star program for Chapter 15
   Compute inside angles of a triangle, based on new position of triangle points.
   Joe Eckstein
   Advanced Java
   7/23/2018
*/   



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;


public class TriAngle extends Application{
   private final double radius = 15;
   private double x1 = radius, y1 = radius;
   private String test = "Testing...";
   private double [] xyz;
         
         
   public double[] angles(double x1, double y1, double x2, double y2, double x3, double y3){
         double[] ABC = new double[] {0.0, 0.0, 0.0};
         
         // Compute three sides
    double a = Math.sqrt((x2 - x3) * (x2 - x3) 
      + (y2 - y3) * (y2 - y3));
    double b = Math.sqrt((x1 - x3) * (x1 - x3) 
      + (y1 - y3) * (y1 - y3));
    double c = Math.sqrt((x1 - x2) * (x1 - x2) 
      + (y1 - y2) * (y1 - y2));
    
    // Compute three angles
    double A = Math.toDegrees(Math.acos((a * a - b * b - c * c) 
      / (-2 * b * c)));
    double B = Math.toDegrees(Math.acos((b * b - a * a - c * c) 
      / (-2 * a * c)));
    double C = Math.toDegrees(Math.acos((c * c - b * b - a * a) 
      / (-2 * a * b)));

      ABC[0] = Math.round(A * 100) / 100.0;
      ABC[1] = Math.round(B * 100) / 100.0;
      ABC[2] = Math.round(C * 100) / 100.0;
      
      return ABC;
   }   
   @Override
   public void start(Stage primaryStage){
   
      Pane pane = new Pane();
      
      //create a circle
      Circle circ1 = new Circle(200, 40, radius);
      Circle circ2 = new Circle(100, 300, radius);
      Circle circ3 = new Circle(340, 250, radius);
      Text txt1 = new Text(circ1.getCenterX()-20,circ1.getCenterY()-25, test);
      Text txt2 = new Text(circ2.getCenterX()-20,circ2.getCenterY()+30, test);
      Text txt3 = new Text(circ3.getCenterX()+20,circ3.getCenterY(), test);
      Line line12 = new Line();
      Line line23 = new Line();
      Line line31 = new Line();
      
      //initialize lines
      line12.setStartX(circ1.getCenterX());
      line12.setStartY(circ1.getCenterY());
      line12.setEndX(circ2.getCenterX());
      line12.setEndY(circ2.getCenterY());
      line23.setStartX(circ2.getCenterX());
      line23.setStartY(circ2.getCenterY());
      line23.setEndX(circ3.getCenterX());
      line23.setEndY(circ3.getCenterY()); 
      line31.setStartX(circ3.getCenterX());
      line31.setStartY(circ3.getCenterY());
      line31.setEndX(circ1.getCenterX());
      line31.setEndY(circ1.getCenterY());    

      
            
      circ2.setFill(Color.GREEN);
      circ1.setFill(Color.GREEN);
      circ3.setFill(Color.GREEN);
      circ1.setStroke(Color.BLACK);
      circ2.setStroke(Color.BLACK);
      circ3.setStroke(Color.BLACK);
      
      //Mouse Drag Event
      circ1.setOnMouseDragged(e -> { 
         circ1.setCenterX(e.getX());
         circ1.setCenterY(e.getY());
         txt1.setX(e.getX()-20);
         txt1.setY(e.getY()-25);
         line12.setStartX(circ1.getCenterX());
      line12.setStartY(circ1.getCenterY());
      line12.setEndX(circ2.getCenterX());
      line12.setEndY(circ2.getCenterY());
       line31.setStartX(circ3.getCenterX());
      line31.setStartY(circ3.getCenterY());
      line31.setEndX(circ1.getCenterX());
      line31.setEndY(circ1.getCenterY()); 
      xyz = angles(circ1.getCenterX(), circ1.getCenterY(), circ2.getCenterX(), circ2.getCenterY(),
      circ3.getCenterX(), circ3.getCenterY()); 
      txt1.setText(String.valueOf(xyz[0]));
      txt2.setText(String.valueOf(xyz[1]));  
      txt3.setText(String.valueOf(xyz[2]));

      });
      
      //Mouse Drag Event      
      circ2.setOnMouseDragged(e -> { 
         circ2.setCenterX(e.getX());
         circ2.setCenterY(e.getY());
         txt2.setX(e.getX()-20);
         txt2.setY(e.getY()+30);
         line12.setStartX(circ1.getCenterX());
      line12.setStartY(circ1.getCenterY());
      line12.setEndX(circ2.getCenterX());
      line12.setEndY(circ2.getCenterY());
      line23.setStartX(circ2.getCenterX());
      line23.setStartY(circ2.getCenterY());
      line23.setEndX(circ3.getCenterX());
      line23.setEndY(circ3.getCenterY()); 
     
      xyz = angles(circ1.getCenterX(), circ1.getCenterY(), circ2.getCenterX(), circ2.getCenterY(),
      circ3.getCenterX(), circ3.getCenterY()); 
      txt1.setText(String.valueOf(xyz[0]));
      txt2.setText(String.valueOf(xyz[1]));  
      txt3.setText(String.valueOf(xyz[2]));

       });
      //Mouse Drag Event
      circ3.setOnMouseDragged(e -> { 
         circ3.setCenterX(e.getX());
         circ3.setCenterY(e.getY());
         txt3.setX(e.getX()+20);
         txt3.setY(e.getY());
         line23.setStartX(circ2.getCenterX());
      line23.setStartY(circ2.getCenterY());
      line23.setEndX(circ3.getCenterX());
      line23.setEndY(circ3.getCenterY()); 
      line31.setStartX(circ3.getCenterX());
      line31.setStartY(circ3.getCenterY());
      line31.setEndX(circ1.getCenterX());
      line31.setEndY(circ1.getCenterY()); 
       xyz = angles(circ1.getCenterX(), circ1.getCenterY(), circ2.getCenterX(), circ2.getCenterY(),
      circ3.getCenterX(), circ3.getCenterY()); 
      txt1.setText(String.valueOf(xyz[0]));
      txt2.setText(String.valueOf(xyz[1]));  
      txt3.setText(String.valueOf(xyz[2]));

      });

      /*
      //construct a polygon
      poly.getPoints().addAll(new Double[]{
         circ1.getCenterX(), circ1.getCenterY(),
         circ2.getCenterX(), circ2.getCenterY(),
         circ3.getCenterX(), circ3.getCenterY()} );
      poly.setFill(Color.TRANSPARENT); 
      poly.setStroke(Color.BLACK);  
      */
      
      //add circle to pane
      pane.getChildren().addAll(circ1, txt1, circ2, txt2, circ3, txt3,
         line12, line23, line31);
      
      //Create a scene and place it in the stage
      Scene scene = new Scene(pane, 400, 400);
      primaryStage.setTitle("Tri Angle Demo");
      primaryStage.setScene(scene);
      primaryStage.show();
      

   }
}      
   