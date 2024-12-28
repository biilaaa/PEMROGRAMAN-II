module PRAKTIKUM07 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	
	opens mainApp to javafx.graphics, javafx.fxml;
	opens controller to javafx.fxml;
}