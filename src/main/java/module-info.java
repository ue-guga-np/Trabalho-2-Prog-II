module uenp.maquinacoxinhas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens uenp.maquinacoxinhas to javafx.fxml;
    exports uenp.maquinacoxinhas;
}
