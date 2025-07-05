module org.example.demo23 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demo23 to javafx.fxml;
    exports org.example.demo23;
}