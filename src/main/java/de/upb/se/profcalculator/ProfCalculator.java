package de.upb.se.profcalculator;

import de.upb.se.arithmetics.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProfCalculator extends Application implements EventHandler<ActionEvent> {

	private final static String DEFAULTEXPRESSION = "0 + 0 = 0";

	private TextField textInput = new TextField("");

	private Button buttonAdd = new Button("+");
	private Button buttonSub = new Button("-");
	private Button buttonMult = new Button("*");
	private Button buttonDiv = new Button("/");
	private Button buttonMod = new Button("%");
	private Button buttonExp = new Button("^");
	private Button buttonReset = new Button("C");
	private Button buttonPrintList = new Button("PRINT");

	private Label labelResult = new Label(DEFAULTEXPRESSION);
	private Label labelPriorResults = new Label();
	private Label labelExpressionList = new Label();
	private Label labelError = new Label("");

	private ResultList resultList = new ResultList();
	private Expression lastResult = new Value();
	
	private String lastExpression = DEFAULTEXPRESSION;
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Professorial Calculator");
		GridPane grid = new GridPane();
		
		setGrid(grid);
		setLayoutComponents();
		
		VBox layout = new VBox(10);
		layout.setPrefSize(400, 500);
		layout.getChildren().addAll(labelError, labelPriorResults, textInput, grid, labelResult, labelExpressionList);
		layout.setPadding(new Insets(20, 40, 20, 40));
		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();
		
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			if (event.getSource() == buttonReset) {
				labelResult.setText(DEFAULTEXPRESSION);
				resultList.clear();
				labelPriorResults.setText("");
				labelExpressionList.setText("");
				lastExpression = DEFAULTEXPRESSION;
			} else if (event.getSource() == buttonPrintList) {
				if (!resultList.boolShowExpressionList) {
					resultList.boolShowExpressionList = true;
					labelExpressionList.setText(resultList.showExpressionList());
				} else {
					resultList.boolShowExpressionList = false;
					labelExpressionList.setText("");
				}

			} else {
				//Value newValue = Value.parseValue(textInput.getText());
				Expression newValue = Value.parseValue(textInput.getText());
				Operations operation;
				if(event.getSource()== buttonAdd) { operation = new Addition(lastResult,newValue); }
				else if(event.getSource()== buttonMult) { operation = new Multiplication(lastResult, newValue); }
				else if(event.getSource()== buttonSub) { operation = new Subtraction(lastResult, newValue); }
				else if(event.getSource()== buttonDiv) { operation = new Division(lastResult, newValue); }
				else if (event.getSource() == buttonMod) { operation = new Modulo(lastResult, newValue); }
				else if (event.getSource() == buttonExp) { operation = new Exponentiation(lastResult, newValue); }
				else {
					// Throw Exception if Function checks for a not processed Button
					labelError.setText("Illegal Button, Button: " + event.getSource() + " not implemented");
					throw new IllegalArgumentException(
							"Illegal Button, Button: " + event.getSource() + " not implemented"); }
				
				if(lastExpression.equals(DEFAULTEXPRESSION))	{
					labelResult.setText(operation.getEquationAsString());
					lastExpression = Expression.addParentheses(operation.getEquationAsString());
				} else {
					labelResult.setText(labelResult.getText().split(" =")[0] + operation.addToExpression());
					lastExpression = Expression.addParentheses(lastExpression.split(" =")[0] + operation.addToExpression());
				}
				lastResult = operation;
				labelPriorResults.setText(resultList.handleResultList(lastResult.evaluate()));
				resultList.add(lastResult.evaluate(), lastExpression);

				// Update ExpressionList if buttonPrint is active
				if (resultList.boolShowExpressionList) {
					labelExpressionList.setText(resultList.showExpressionList());
				}
			}
			textInput.setText("");
			labelError.setText("");
			textInput.requestFocus();
		} catch (NumberFormatException e) {
			labelError.setText("\"" + textInput.getText() + "\" is not a valid integer");
		}
	}

	
	/*
	 * Grid layout for Buttons
	 * Layout:
	 * 		0	1	2	3	4
	 * 	0	+	*	%	C	PRINT
	 * 	1	-	/	^	
	 */
	private void setGrid(GridPane grid) {
		grid.setHgap(10);
		grid.setVgap(10);
		grid.add(buttonAdd, 0, 0);
		grid.add(buttonSub, 0, 1);
		grid.add(buttonMult, 1, 0);
		grid.add(buttonDiv, 1, 1);
		grid.add(buttonMod, 2, 0);
		grid.add(buttonExp, 2, 1);
		grid.add(buttonReset, 3, 0);
		grid.add(buttonPrintList, 4, 0);
	}

	private void setLayoutComponents() {
		labelError.setTextFill(Color.web("#FF0000"));
		labelPriorResults.setMinHeight(30);
		
		buttonAdd.setOnAction(this);
		buttonSub.setOnAction(this);
		buttonMult.setOnAction(this);
		buttonDiv.setOnAction(this);
		buttonReset.setOnAction(this);
		buttonPrintList.setOnAction(this);
		buttonMod.setOnAction(this);
		buttonExp.setOnAction(this);

		buttonAdd.setMinSize(30, 30);
		buttonSub.setMinSize(30, 30);
		buttonMult.setMinSize(30, 30);
		buttonDiv.setMinSize(30, 30);
		buttonReset.setMinSize(30, 30);
		buttonPrintList.setMinSize(30, 30);
		buttonMod.setMinSize(30, 30);
		buttonExp.setMinSize(30, 30);
	}

	public static void main(String[] args) {launch(args);}

}
