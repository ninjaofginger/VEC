package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextField bSize;

    @FXML
    Boolean toolSelected = false;
    @FXML
    Boolean lineAction = false;

    @FXML
    private Canvas canvas;


    GraphicsContext brushtool;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brushtool = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(bSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if (toolSelected && !bSize.getText().isEmpty()) {
                brushtool.setFill(colourPicker.getValue());
                brushtool.fillRoundRect(x, y, size, size, size, size);
            }
        });
/* getting my head around it need to be finished
        brushtool = canvas.getGraphicsContext2D();
        canvas.setOnMousePressed(e->{
            double size = Double.parseDouble(bSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            canvas.setOnDragDropped(f-> {

                double x1 = f.getX() - size / 2;
                double y1 = f.getY() - size / 2;

                if (lineAction && !bSize.getText().isEmpty()) {
                    Line line = new Line(x, y, x1, y1);
                    line.onMouseReleasedProperty();
                }
            }

        });
        */

    }
        @FXML
        public  void toolSelected (ActionEvent e){
            toolSelected = true;
        }
        @FXML
         public  void line (ActionEvent e){
            lineAction = true;
    }

}

