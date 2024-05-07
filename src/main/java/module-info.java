module de.upb.se.profcalculator {
    requires transitive javafx.controls;
    requires javafx.fxml;


    opens de.upb.se.profcalculator to javafx.fxml;
    exports de.upb.se.profcalculator;
}