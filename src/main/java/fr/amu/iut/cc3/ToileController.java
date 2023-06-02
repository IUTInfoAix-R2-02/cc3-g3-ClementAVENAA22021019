package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    private TextField Comp1;
    @FXML
    private TextField Comp2;
    @FXML
    private TextField Comp3;
    @FXML
    private TextField Comp4;
    @FXML
    private TextField Comp5;
    @FXML
    private TextField Comp6;
    @FXML
    private HBox scene;
    @FXML
    private Pane PToile;
    private Circle PComp1 = new Circle();
    private Circle PComp2 = new Circle();
    private Circle PComp3 = new Circle();
    private Circle PComp4 = new Circle();
    private Circle PComp5 = new Circle();
    private Circle PComp6 = new Circle();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void TracerPoints() {
        PComp1.setCenterX(getXRadarChart(Double.parseDouble(Comp1.getText()), 1));
        PComp1.setCenterY(getYRadarChart(Double.parseDouble(Comp1.getText()), 1));
        PComp2.setCenterX(getXRadarChart(Double.parseDouble(Comp2.getText()), 2));
        PComp2.setCenterY(getYRadarChart(Double.parseDouble(Comp2.getText()), 2));
        PComp3.setCenterX(getXRadarChart(Double.parseDouble(Comp3.getText()), 3));
        PComp3.setCenterY(getYRadarChart(Double.parseDouble(Comp3.getText()), 3));
        PComp4.setCenterX(getXRadarChart(Double.parseDouble(Comp4.getText()), 4));
        PComp4.setCenterY(getYRadarChart(Double.parseDouble(Comp4.getText()), 4));
        PComp5.setCenterX(getXRadarChart(Double.parseDouble(Comp5.getText()), 5));
        PComp5.setCenterY(getYRadarChart(Double.parseDouble(Comp5.getText()), 5));
        PComp6.setCenterX(getXRadarChart(Double.parseDouble(Comp6.getText()), 6));
        PComp6.setCenterY(getYRadarChart(Double.parseDouble(Comp6.getText()), 6));

        PComp1.setRadius(5);
        PComp2.setRadius(5);
        PComp3.setRadius(5);
        PComp4.setRadius(5);
        PComp5.setRadius(5);
        PComp6.setRadius(5);
        PComp1.setVisible(false);
        PComp2.setVisible(false);
        PComp3.setVisible(false);
        PComp4.setVisible(false);
        PComp5.setVisible(false);
        PComp6.setVisible(false);
        

        PToile.getChildren().addAll(PComp1, PComp2, PComp3, PComp4, PComp5, PComp6);
    }
    
    public void ViderPoints() {
        PComp1.setVisible(false);
        PComp2.setVisible(false);
        PComp3.setVisible(false);
        PComp4.setVisible(false);
        PComp5.setVisible(false);
        PComp6.setVisible(false);
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

}
