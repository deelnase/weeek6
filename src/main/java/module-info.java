module com.example.weeek6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.weeek6 to javafx.fxml;
    exports com.example.weeek6;
}