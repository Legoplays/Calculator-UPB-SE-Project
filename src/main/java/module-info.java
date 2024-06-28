module de.upb.se.profcalculator {
    requires transitive javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;


    opens de.upb.se.profcalculator to javafx.fxml;
    exports de.upb.se.profcalculator;
    exports de.upb.se.arithmetics;
}