package GUIProject.hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton pen;

    @FXML
    private RadioButton eraser;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Rectangle area = new Rectangle(0, 0, drawingAreaPane.getWidth(), drawingAreaPane.getHeight());
        drawingAreaPane.setClip(area);
        if (pen.isSelected() || eraser.isSelected()) {
            Color color;
            if (pen.isSelected()) {
                color = Color.BLACK;
            } else {
                color = Color.WHITE;
            }
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}