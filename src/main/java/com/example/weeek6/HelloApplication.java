package com.example.weeek6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();
        Rectangle body = new Rectangle(100,100,146,40);
        Circle wheel1 = new Circle(17);
        Circle wheel2 = new Circle(17);
        Polygon roof = new Polygon();

        roof.getPoints().addAll(new Double[]{30.0,10.0, 0.0,40.0, 0.0,100.0, 30.0,130.0});
        roof.setRotate(90);

        body.setX(100);
        body.setY(93);

        wheel1.setLayoutX(142);
        wheel1.setLayoutY(145);

        wheel2.setLayoutX(205);
        wheel2.setLayoutY(145);

        roof.setLayoutX(158);
        roof.setLayoutY(8);

        wheel1.setFill(Color.BLACK);
        wheel2.setFill(Color.BLACK);
        body.setFill(Color.BLUEVIOLET);
        roof.setFill(Color.SKYBLUE);

        Line line = new Line(100,400,455,400);
        PathTransition transition = new PathTransition(Duration.millis(3000),line, pane);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.play();


        Button pause = new Button("Pause");
        pause.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transition.pause();
            }
        });

        Button resume = new Button("Resume");
        resume.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transition.play();
            }
        });

        Button increase = new Button("Increase");
        increase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transition.setRate(transition.getRate() * 2);
            }
        });

        Button decrease = new Button("Decrease");
        decrease.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transition.setRate(transition.getRate() * 0.5);
            }
        });


        pause.setLayoutX(0);
        pause.setLayoutY(0);

        resume.setLayoutX(48);
        resume.setLayoutY(0);

        increase.setLayoutX(107);
        increase.setLayoutY(0);

        decrease.setLayoutX(167);
        decrease.setLayoutY(0);

        Pane buttons = new Pane();
        buttons.getChildren().addAll(pause,resume,increase,decrease);

        pane.getChildren().addAll(body,wheel1,wheel2,roof);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(pane);
        borderPane.setTop(buttons);


        Scene scene = new Scene(borderPane,500,400);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}