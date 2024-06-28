package de.upb.se.arithmetics;

public class Subtraction extends Operations {
	//Constructor
	public Subtraction(Expression l, Expression r) {
		this.leftExpr = l;
		this.rightExpr = r;
		this.operator = " - ";

	}
	
	//Returns String representation of the Subtraction
	public String getOperationAsString() {return leftExpr.toString() + " - " + rightExpr.toString();}
	
	//Returns Int-Value of the Subtraction
	public Value evaluate() {	
		return new Value(leftExpr.evaluate().getValue() - rightExpr.evaluate().getValue());
		}

	@Override
	public String addToExpression() {
		return " - " + rightExpr.toString() + " = " + evaluate(); 
	}

}
