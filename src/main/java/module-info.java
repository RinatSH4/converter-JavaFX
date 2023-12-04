module com.homework.hwfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.homework.hwfx to javafx.fxml;
    exports com.homework.hwfx;
}