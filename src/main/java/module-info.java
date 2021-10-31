module com.svilen.unit4extensionkitliquidxmlwithnamespaceconverterjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.svilen.unit4extensionkitliquidxmlwithnamespaceconverterjavafx to javafx.fxml;
    exports com.svilen.unit4extensionkitliquidxmlwithnamespaceconverterjavafx;
}