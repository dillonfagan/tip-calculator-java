import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

public class Tips extends Application {

    private NumberField billField;
    private NumberField tipPercentageField;
    private Button calculateButton;
    private Label tipLabel;
    private Label totalLabel;

    public Tips() {
        billField = new NumberField();
        billField.setPromptText("Bill");

        tipPercentageField = new NumberField();
        tipPercentageField.setPromptText("Tip Percentage");

        calculateButton = new Button("Calculate Tip");
        calculateButton.setOnAction(a -> {
            calculateTip();
        });

        tipLabel = new Label();
        tipLabel.setFont(new Font("Verdana", 14));

        totalLabel = new Label();
        totalLabel.setFont(new Font("Verdana", 18));
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setPadding(new Insets(14, 14, 14, 14));
        root.setSpacing(10);
        root.getChildren().addAll(billField, tipPercentageField, calculateButton, tipLabel, totalLabel);

        stage.setTitle("Tips");
        stage.setScene(new Scene(root, 220, 300));
        stage.show();
    }

    private void calculateTip() {
        double bill = billField.getNumberValue();
        double tipPercentage = tipPercentageField.getNumberValue() * 0.01;

        double tip = bill * tipPercentage;
        double total = bill + tip;

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        tipLabel.setText("Tip: " + formatter.format(tip));
        totalLabel.setText(formatter.format(total));
    }
}
