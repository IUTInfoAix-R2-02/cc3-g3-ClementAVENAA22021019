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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    private Label LabelErreur1;
    @FXML
    private Label LabelErreur2;
    @FXML
    private Pane PToile;
    private Circle PComp1 = new Circle();
    private Circle PComp2 = new Circle();
    private Circle PComp3 = new Circle();
    private Circle PComp4 = new Circle();
    private Circle PComp5 = new Circle();
    private Circle PComp6 = new Circle();
    private TextField[] ListComp = {Comp1, Comp2, Comp3, Comp4, Comp5, Comp6};
    private Line LComp1 = new Line();
    private Line LComp2 = new Line();
    private Line LComp3 = new Line();
    private Line LComp4 = new Line();
    private Line LComp5 = new Line();
    private Line LComp6 = new Line();
    private Line[] ListLine = {LComp1, LComp2, LComp3, LComp4, LComp5, LComp6};
    private boolean[] LineOk = {false, false, false, false, false, false};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PToile.getChildren().addAll(PComp1, PComp2, PComp3, PComp4, PComp5, PComp6, LComp1, LComp2, LComp3, LComp4, LComp5, LComp6);
        LabelErreur1.setVisible(false);
        LabelErreur1.setTextFill(Color.RED);
        LabelErreur2.setVisible(false);
        LabelErreur2.setTextFill(Color.RED);

        //Taille et visibilité des points
        PComp1.setRadius(5);
        PComp1.setVisible(false);
        PComp2.setRadius(5);
        PComp2.setVisible(false);
        PComp3.setRadius(5);
        PComp3.setVisible(false);
        PComp4.setRadius(5);
        PComp4.setVisible(false);
        PComp5.setRadius(5);
        PComp5.setVisible(false);
        PComp6.setRadius(5);
        PComp6.setVisible(false);

        //Lignes en noir
        LComp1.setStyle("-fx-stroke: black;");
        LComp2.setStyle("-fx-stroke: black;");
        LComp3.setStyle("-fx-stroke: black;");
        LComp4.setStyle("-fx-stroke: black;");
        LComp5.setStyle("-fx-stroke: black;");
        LComp6.setStyle("-fx-stroke: black;");
        //Lignes inapparentes
        LComp1.setVisible(false);
        LComp2.setVisible(false);
        LComp3.setVisible(false);
        LComp4.setVisible(false);
        LComp5.setVisible(false);
        LComp6.setVisible(false);

    }

    public void TracerPoints() {
        if (Double.parseDouble(Comp1.getText()) >= 0 && Double.parseDouble(Comp1.getText()) <= 20) {
            PComp1.setCenterX(getXRadarChart(Double.parseDouble(Comp1.getText()), 1));
            PComp1.setCenterY(getYRadarChart(Double.parseDouble(Comp1.getText()), 1));
            LabelErreur1.setVisible(false);
            LabelErreur2.setVisible(false);
            PComp1.setVisible(true);

            LComp6.setEndX(getXRadarChart(Double.parseDouble(Comp1.getText()), 1));
            LComp6.setEndY(getYRadarChart(Double.parseDouble(Comp1.getText()), 1));
            LineOk[0] = true;
            LComp1.setStartX(getXRadarChart(Double.parseDouble(Comp1.getText()), 1));
            LComp1.setStartY(getYRadarChart(Double.parseDouble(Comp1.getText()), 1));
        } else {
            LabelErreur1.setVisible(true);
            LabelErreur2.setVisible(true);
            PComp1.setVisible(false);
            LineOk[0] = false;
        } if (Double.parseDouble(Comp2.getText()) >= 0 && Double.parseDouble(Comp2.getText()) <= 20) {
            //Placement du point
            PComp2.setCenterX(getXRadarChart(Double.parseDouble(Comp2.getText()), 2));
            PComp2.setCenterY(getYRadarChart(Double.parseDouble(Comp2.getText()), 2));
            LabelErreur1.setVisible(false);
            LabelErreur2.setVisible(false);
            PComp2.setVisible(true);

            //Placement des lignes
            LComp1.setEndX(getXRadarChart(Double.parseDouble(Comp2.getText()), 2));
            LComp1.setEndY(getYRadarChart(Double.parseDouble(Comp2.getText()), 2));
            LineOk[1] = true;
            LComp2.setStartX(getXRadarChart(Double.parseDouble(Comp2.getText()), 2));
            LComp2.setStartY(getYRadarChart(Double.parseDouble(Comp2.getText()), 2));
        } else {
            LabelErreur1.setVisible(true);
            LabelErreur2.setVisible(true);
            PComp2.setVisible(false);
            LineOk[1] = false;
        } if (Double.parseDouble(Comp3.getText()) >= 0 && Double.parseDouble(Comp3.getText()) <= 20) {
            PComp3.setCenterX(getXRadarChart(Double.parseDouble(Comp3.getText()), 3));
            PComp3.setCenterY(getYRadarChart(Double.parseDouble(Comp3.getText()), 3));
            LabelErreur1.setVisible(false);
            LabelErreur2.setVisible(false);
            PComp3.setVisible(true);

            //Placement des lignes
            LComp2.setEndX(getXRadarChart(Double.parseDouble(Comp3.getText()), 3));
            LComp2.setEndY(getYRadarChart(Double.parseDouble(Comp3.getText()), 3));
            LineOk[2] = true;
            LComp3.setStartX(getXRadarChart(Double.parseDouble(Comp3.getText()), 3));
            LComp3.setStartY(getYRadarChart(Double.parseDouble(Comp3.getText()), 3));
        } else {
            LabelErreur1.setVisible(true);
            LabelErreur2.setVisible(true);
            PComp3.setVisible(false);
            LineOk[2] = false;
        } if (Double.parseDouble(Comp4.getText()) >= 0 && Double.parseDouble(Comp4.getText()) <= 20) {
            PComp4.setCenterX(getXRadarChart(Double.parseDouble(Comp4.getText()), 4));
            PComp4.setCenterY(getYRadarChart(Double.parseDouble(Comp4.getText()), 4));
            LabelErreur1.setVisible(false);
            LabelErreur2.setVisible(false);
            PComp4.setVisible(true);

            //Placement des lignes
            LComp3.setEndX(getXRadarChart(Double.parseDouble(Comp4.getText()), 4));
            LComp3.setEndY(getYRadarChart(Double.parseDouble(Comp4.getText()), 4));
            LineOk[3] = true;
            LComp4.setStartX(getXRadarChart(Double.parseDouble(Comp4.getText()), 4));
            LComp4.setStartY(getYRadarChart(Double.parseDouble(Comp4.getText()), 4));
        } else {
            LabelErreur1.setVisible(true);
            LabelErreur2.setVisible(true);
            PComp4.setVisible(false);
            LineOk[3] = false;
        } if (Double.parseDouble(Comp5.getText()) >= 0 && Double.parseDouble(Comp5.getText()) <= 20) {
            PComp5.setCenterX(getXRadarChart(Double.parseDouble(Comp5.getText()), 5));
            PComp5.setCenterY(getYRadarChart(Double.parseDouble(Comp5.getText()), 5));
            LabelErreur1.setVisible(false);
            LabelErreur2.setVisible(false);
            PComp5.setVisible(true);

            //Placement des lignes
            LComp4.setEndX(getXRadarChart(Double.parseDouble(Comp5.getText()), 5));
            LComp4.setEndY(getYRadarChart(Double.parseDouble(Comp5.getText()), 5));
            LineOk[4] = true;
            LComp5.setStartX(getXRadarChart(Double.parseDouble(Comp5.getText()), 5));
            LComp5.setStartY(getYRadarChart(Double.parseDouble(Comp5.getText()), 5));
        } else {
            LabelErreur1.setVisible(true);
            LabelErreur2.setVisible(true);
            PComp5.setVisible(false);
            LineOk[4] = false;
        } if (Double.parseDouble(Comp6.getText()) >= 0 && Double.parseDouble(Comp6.getText()) <= 20) {
            PComp6.setCenterX(getXRadarChart(Double.parseDouble(Comp6.getText()), 6));
            PComp6.setCenterY(getYRadarChart(Double.parseDouble(Comp6.getText()), 6));
            LabelErreur1.setVisible(false);
            LabelErreur2.setVisible(false);
            PComp6.setVisible(true);

            //Placement des lignes
            LComp5.setEndX(getXRadarChart(Double.parseDouble(Comp6.getText()), 6));
            LComp5.setEndY(getYRadarChart(Double.parseDouble(Comp6.getText()), 6));
            LineOk[5] = true;
            LComp6.setStartX(getXRadarChart(Double.parseDouble(Comp6.getText()), 6));
            LComp6.setStartY(getYRadarChart(Double.parseDouble(Comp6.getText()), 6));
        } else {
            LabelErreur1.setVisible(true);
            LabelErreur2.setVisible(true);
            PComp6.setVisible(false);
            LineOk[5] = false;
        }
        for (int i = 0; i < LineOk.length-1; i+=1) {
            if (LineOk[i] && LineOk[i+1]) {
                ListLine[i].setVisible(true);
            } else {
                ListLine[i].setVisible(false);
            }
        }
        if (LineOk[5] && LineOk[0]) {
            ListLine[5].setVisible(true);
        } else {
            ListLine[5].setVisible(false);
        }
    }
    
    public void ViderPoints() {
        //Disparition du message d'erreur
        LabelErreur1.setVisible(false);
        LabelErreur2.setVisible(false);
        //Disparition des points
        PComp1.setVisible(false);
        PComp2.setVisible(false);
        PComp3.setVisible(false);
        PComp4.setVisible(false);
        PComp5.setVisible(false);
        PComp6.setVisible(false);
        //Disparition des lignes
        LComp1.setVisible(false);
        LComp2.setVisible(false);
        LComp3.setVisible(false);
        LComp4.setVisible(false);
        LComp5.setVisible(false);
        LComp6.setVisible(false);
        Comp1.setText("");
        Comp2.setText("");
        Comp3.setText("");
        Comp4.setText("");
        Comp5.setText("");
        Comp6.setText("");
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
