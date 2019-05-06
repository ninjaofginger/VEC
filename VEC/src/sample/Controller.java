package sample;
import javafx.scene.input.MouseEvent;
import sample.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private ColorPicker colourPicker;
    @FXML
    private Line line;

    @FXML
    private TextField bSize;

    @FXML
    Boolean toolSelected = false;
    @FXML
    Boolean lineActions = false;

    @FXML
    private Canvas canvas;

    private  double intialx , intialy;

    GraphicsContext brushtool;


    //Line line = new Line();
    private  void mousePressed(MouseEvent event){
        intialx = event.getX();
        intialy = event.getY();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brushtool = canvas.getGraphicsContext2D();

        /*
        System.out.println("pressed");
        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(bSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if (toolSelected && !bSize.getText().isEmpty()) {
                brushtool.setFill(colourPicker.getValue());
                brushtool.fillRoundRect(x, y, size, size, size, size);
            }
        });*/
// getting my head around it need to be finished

       // Line line = new Line();
       // if (lineActions && !bSize.getText().isEmpty()) {



            canvas.setOnMousePressed(f -> {
                System.out.println("pressed");
                mousePressed(f);
                double size = Double.parseDouble(bSize.getText());
                //double x = f.getX() - size / 2;
                //double y = f.getY() - size / 2;


                brushtool.setFill(colourPicker.getValue());
                //brushtool.fillRect(x,y,size,size);

               brushtool.setStroke(colourPicker.getValue());
               brushtool.beginPath();
               brushtool.stroke();

               // line.setStartX(x);
                //line.setStartY(y);



            });
            canvas.setOnMouseReleased(g -> {
                System.out.println("released");
                double size = Double.parseDouble(bSize.getText());
                double x1 = g.getX() - size / 2;
                double y1 = g.getY() - size / 2;
                //brushtool.moveTo(x1, y1);

                //brushtool.lineTo(x1,y1);
                brushtool.strokeLine(intialx,intialy,x1,y1);
                brushtool.stroke();

                //line.setEndX(x1);
                //line.setEndY(y1);

            });



    }
        @FXML
        public  void toolSelected (ActionEvent e){
            toolSelected = true;
            //if(lineActions ==true){toolSelected =false;}

        }
        @FXML
         public  void LineAction (ActionEvent e) {
            lineActions = true;
           // if(toolSelected== true){lineActions = false;}

        }
}

