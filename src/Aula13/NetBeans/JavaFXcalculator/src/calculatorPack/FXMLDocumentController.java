/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorPack;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

/**
 *
 * @author AJ
 */
public class FXMLDocumentController implements Initializable {
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }
  
  @FXML
  private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, buttonDecimal, btnCalculate;
  @FXML
  private TextField output;
  
  String operators[] = {"/", "*", "-", "+", "."};
  
  //numbers
  public void btn0(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("0");//@FXML
      output.setText(output.getText() + "0");
      
  }
  public void btn1(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("1");
      output.setText(output.getText() + "1");
  }
  public void btn2(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("2");
      output.setText(output.getText() + "2");
  }
  public void btn3(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("3");
      output.setText(output.getText() + "3");
  }
  public void btn4(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("4");
      output.setText(output.getText() + "4");
  }
  public void btn5(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("5");
      output.setText(output.getText() + "5");
  }
  public void btn6(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("6");
      output.setText(output.getText() + "6");
  }
  public void btn7(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("7");
      output.setText(output.getText() + "7");
  }
  public void btn8(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("8");
      output.setText(output.getText() + "8");
  }
  public void btn9(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("9");
      output.setText(output.getText() + "9");
  }
  
  //period sign
  public void btnDecimal(ActionEvent event) {
      // Button was clicked, do something...
    if(!verifyDecimalPlacement()) {
        return;
      }
      System.out.println(".");
      output.setText(output.getText() + ".");
  }
  
  //operators
  public void divide(ActionEvent event) {
      // Button was clicked, do something...
      if(!verifyOperatorPlacement()) {
        return;
      }
      System.out.println("/");
      output.setText(output.getText() + "/");
  }
  public void multiply(ActionEvent event) {
      // Button was clicked, do something...
      if(!verifyOperatorPlacement()) {
        return;
      }
      System.out.println("*");
      output.setText(output.getText() + "*");
  }
  public void minus(ActionEvent event) {
      // Button was clicked, do something...
      if(!verifyOperatorPlacement()) {
        return;
      }
      System.out.println("-");
      output.setText(output.getText() + "-");
  }
  public void plus(ActionEvent event) {
      // Button was clicked, do something...
      if(!verifyOperatorPlacement()) {
        return;
      }
      System.out.println("+");
      output.setText(output.getText() + "+");
  }
  
  //clearing
  public void clear(ActionEvent event) {
      // Button was clicked, do something...
      System.out.println("clear");
      output.clear();
  }
  
  //calculating
  public void btnCalculate(ActionEvent event) {
    Double result = eval(output.getCharacters()+ "");
    System.out.println(result);
    output.setText(result + "");
  }
  
  //custom methods
  private boolean verifyOperatorPlacement() {
    for(String operator : operators){
        if (output.getCharacters().toString().endsWith(operator) || output.getCharacters().length() == 0) {
          System.out.println("abort");
          return false;
        }
      }
    return true;
  }
  private boolean verifyDecimalPlacement() {
    if (output.getCharacters().toString().endsWith(".")) {
      System.out.println("abort");
      return false;
    }
    return true;
  }
  
  //http://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form
  public static double eval(final String str) {
    class Parser {
        int pos = -1, c;

        void eatChar() {
            c = (++pos < str.length()) ? str.charAt(pos) : -1;
        }

        void eatSpace() {
            while (Character.isWhitespace(c)) eatChar();
        }

        double parse() {
            eatChar();
            double v = parseExpression();
            if (c != -1) throw new RuntimeException("Unexpected: " + (char)c);
            return v;
        }

        // Grammar:
        // expression = term | expression `+` term | expression `-` term
        // term = factor | term `*` factor | term `/` factor | term brackets
        // factor = brackets | number | factor `^` factor
        // brackets = `(` expression `)`

        double parseExpression() {
            double v = parseTerm();
            for (;;) {
                eatSpace();
                if (c == '+') { // addition
                    eatChar();
                    v += parseTerm();
                } else if (c == '-') { // subtraction
                    eatChar();
                    v -= parseTerm();
                } else {
                    return v;
                }
            }
        }

        double parseTerm() {
            double v = parseFactor();
            for (;;) {
                eatSpace();
                if (c == '/') { // division
                    eatChar();
                    v /= parseFactor();
                } else if (c == '*' || c == '(') { // multiplication
                    if (c == '*') eatChar();
                    v *= parseFactor();
                } else {
                    return v;
                }
            }
        }

        double parseFactor() {
            double v;
            boolean negate = false;
            eatSpace();
            if (c == '(') { // brackets
                eatChar();
                v = parseExpression();
                if (c == ')') eatChar();
            } else { // numbers
                if (c == '+' || c == '-') { // unary plus & minus
                    negate = c == '-';
                    eatChar();
                    eatSpace();
                }
                StringBuilder sb = new StringBuilder();
                while ((c >= '0' && c <= '9') || c == '.') {
                    sb.append((char)c);
                    eatChar();
                }
                if (sb.length() == 0) throw new RuntimeException("Unexpected: " + (char)c);
                v = Double.parseDouble(sb.toString());
            }
            eatSpace();
            if (c == '^') { // exponentiation
                eatChar();
                v = Math.pow(v, parseFactor());
            }
            if (negate) v = -v; // exponentiation has higher priority than unary minus: -3^2=-9
            return v;
        }
    }
    return new Parser().parse();
  }
}
