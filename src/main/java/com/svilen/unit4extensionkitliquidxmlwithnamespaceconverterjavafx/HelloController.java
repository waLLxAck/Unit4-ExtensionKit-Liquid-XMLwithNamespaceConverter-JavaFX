package com.svilen.unit4extensionkitliquidxmlwithnamespaceconverterjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.stream.Collectors;

public class HelloController {

    @FXML
    public TextField txtVariableName;
    public TextArea txtAreaOutput;
    public SplitPane splitPane;
    @FXML
    private TextArea txtArea;

    @FXML
    protected void onConvertButtonClick() {
        String variable = txtVariableName.getText();
        txtAreaOutput.setText(txtArea.getText().lines().map(line -> {
            if (line.contains("{{") && line.contains("}}")) {
                if (!line.substring(line.indexOf("{{") + 2).startsWith(variable)) return line + "\n";
                else return MessageConverter2.convert(line, variable) + "\n";
            } else return line + "\n";
        }).collect(Collectors.joining()).replace("#", "."));
    }

    public void onBtnTestDataClicked(ActionEvent actionEvent) {
        txtVariableName.setText("step11");
        txtArea.setText("[\n" +
                "  {\n" +
                "    \"op\": \"add\",\n" +
                "    \"path\": \"/customFieldGroups/blp_ves_resp/-\",\n" +
                "    \"value\": {\n" +
                "      \"rowId\": 0,\n" +
                "      \"handelsnaam_fx\": \"{{step11.ParsedContent[\"soapenv: Envelope\"][\"soapenv: Body\"][\"BG: vesLa01\"][\"BG: antwoord\"][\"BG: object\"][\"BG: handelsnaam\"]}}\",\n" +
                "\"kvknummer_fx\": \"{{step11.ParsedContent[\"Envelope\"][\"Body\"][\"vesLa01\"][\"antwoord\"][\"object\"][\"oefentActiviteitenUitVoor\"][\"gerelateerde\"][\"kvkNummer\"]}}\",\n" +
                "\"vestigingsnummer_fx\": \"{{step11.ParsedContent.Envelope.Body.vesLa01.antwoord.object.vestigingsNummer}}\",\n" +
                "      \"datumaanvang_fx\": \"{{date.parse step11.ParsedContent[\"soapenv: Envelope\"][\"soapenv: Body\"][\"BG: vesLa01\"][\"BG: antwoord\"][\"BG: object\"][\"BG: datumAanvang\"] | date.to_string '%a, %b %d, %y'}}\",\n" +
                "      \"straatnaam_fx\": \"{{step11.ParsedContent.Envelope.Body.vesLa01.antwoord.object.verblijfsadres.gor.straatnaam}}\",\n" +
                "      \"datumeinde_fx\": \"1900-01-01T00:00:00.000\",\n" +
                "      \"huisletter_fx\": \"{{step11.ParsedContent.Envelope.Body.vesLa01.antwoord.object.verblijfsadres.aoa.huisletter}}\",\n" +
                "      \"huis_nr_fx\": \"{{step11.ParsedContent.Envelope.Body.vesLa01.antwoord.object.verblijfsadres.aoa.huisnummer}}\",\n" +
                "      \"huisnummertoevoeging_fx\": \"{{step11.ParsedContent.Envelope.Body.vesLa01.antwoord.object.verblijfsadres.aoa.huisnummertoevoeging}}\",\n" +
                "      \"postcode_fx\": \"{{step11.ParsedContent.Envelope.Body.vesLa01.antwoord.object.verblijfsadres.aoa.postcode}}\",\n" +
                "      \"woonplaatsnaam_fx\": \"{{step11.ParsedContent[\"Envelope\"][\"Body\"][\"vesLa01\"][\"antwoord\"][\"object\"][\"verblijfsadres\"][\"wpl\"][\"woonplaatsNaam\"]}}\",\n" +
                "      \"stuf_bericht_fx\": \"\",\n" +
                "      \"ubw_proces_datum_fx\": \"{{tijdstipBericht}}\",\n" +
                "      \"ubw_proces_status_fx\": \"N\",\n" +
                "      \"ubw_proces_fx\": \"LA01\",\n" +
                "      \"ubw_proces_no_fx\": 0,\n" +
                "      \"correlation_id_fx\": \"\"\n" +
                "    }\n" +
                "  }\n" +
                "]");
    }
}