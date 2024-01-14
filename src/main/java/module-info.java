module com.example.prog2_4ano {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prog2_4ano to javafx.fxml;
    exports com.example.prog2_4ano;
}