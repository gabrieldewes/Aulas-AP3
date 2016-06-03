package Aula13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
/**
 * Created by Dewes on 03/06/2016.
 */
public class Controller extends AnchorPane {
    @FXML
    Label displayField = new Label();

    private long currentNumber;
    private long newNumber;

    private double currentDoubleNumber;
    private double newDoubleNumber;

    private boolean flag = false;

    private String operation = "";

    @FXML
    void handleNumericButtonAction(ActionEvent event) {
        String currentText = displayField.getText();
        if (currentText.equals("0")) {
            currentText = "";
        }
        currentText += ((Button) event.getSource()).getText();
        //currentNumber = Integer.(currentText);
        displayField.setText(currentText);
    }

    @FXML
    void handleArithmeticButtonAction(ActionEvent event) {
        String currentText = displayField.getText();
        if (currentText.contains(".")) {
            flag = true;
            currentDoubleNumber = Double.parseDouble(currentText);
        } else {
            currentNumber = Long.parseLong(currentText);
        }
        operation = ((Button) event.getSource()).getText();
        displayField.setText("");
    }

    @FXML
    void handleEqualButtonAction(ActionEvent event) {
        String newText = displayField.getText();
        if (flag) {
            newDoubleNumber = Double.parseDouble(newText);
            switch (operation) {
                case "+":
                    currentDoubleNumber += newDoubleNumber;
                    break;
                case "-":
                    currentDoubleNumber -= newDoubleNumber;
                    break;
                case "*":
                    currentDoubleNumber *= newDoubleNumber;
                    break;
                case "/":
                    currentDoubleNumber /= newDoubleNumber;
                    break;
            }
            displayField.setText(Double.toString(currentDoubleNumber));
        } else {
            newNumber = Long.parseLong(newText);
            switch (operation) {
                case "+":
                    currentNumber += newNumber;
                    break;
                case "-":
                    currentNumber -= newNumber;
                    break;
                case "*":
                    currentNumber *= newNumber;
                    break;
                case "/":
                    currentNumber /= newNumber;
                    break;
            }
            displayField.setText(Long.toString(currentNumber));
        }
    }

    @FXML
    void handleCButtonAction(ActionEvent event) {
        displayField.setText("0");
    }

    @FXML
    void handlePointButtonAction(ActionEvent event) {
        String currentText = displayField.getText();
        if (currentText.equals("")) {
            currentText += ((Button) event.getSource()).getText();
            displayField.setText(currentText);
        } else {
            if (currentText.contains(".")) {
                //faz nada
            } else {
                currentText += ((Button) event.getSource()).getText();
                displayField.setText(currentText);
            }
        }
    }

    @FXML
    void handlePercentageButtonAction(ActionEvent event) {
        String currentText = displayField.getText();
        System.out.println(currentText);
        if (currentText.equals(".")) {
            currentDoubleNumber = Double.parseDouble(currentText);
            newDoubleNumber = currentDoubleNumber / 100D;
            displayField.setText(Double.toString(newDoubleNumber));
        } else {
            currentDoubleNumber = Double.parseDouble(currentText);
            newDoubleNumber = currentDoubleNumber / 100D;
            displayField.setText(Double.toString(newDoubleNumber));
        }
    }

    @FXML
    void handleAbsButtonAction(ActionEvent event) {
        String currentText = displayField.getText();
        if (currentText.isEmpty()) {
            //faz nada
        } else {
            if (currentText.contains(".")) {
                currentDoubleNumber = Double.parseDouble(currentText);
                newDoubleNumber = currentDoubleNumber * -1D;
                displayField.setText(Double.toString(newDoubleNumber));
            } else {
                currentNumber = Long.parseLong(currentText);
                newNumber = currentNumber * -1;
                displayField.setText(Long.toString(newNumber));
            }
        }
    }

    @FXML
    void handleKeyPressed(ActionEvent event) {

    }
}
