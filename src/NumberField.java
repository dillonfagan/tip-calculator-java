import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

class NumberField extends TextField {

    private NumberFormat numberFormatter;
    private double numberValue;

    NumberField() {
        super();

        numberFormatter = NumberFormat.getNumberInstance(Locale.US);

        focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue && !getText().isEmpty()) {
                numberValue = Double.parseDouble(getText());

                if (numberValue > 999) {
                    setText(numberFormatter.format(numberValue));
                }
            } else {
                numberValue = 0;
                setText("");
            }
        });
    }

    Double getNumberValue() {
        return numberValue;
    }
}
