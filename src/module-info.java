module Internet_CLafes {
	opens main;
	opens database;
	opens view;
	opens model;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.controls;
}