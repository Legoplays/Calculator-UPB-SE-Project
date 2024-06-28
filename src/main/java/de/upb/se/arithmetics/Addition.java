package de.upb.se.arithmetics;

public class Addition extends Operations {
	//Constructor
	public Addition(Expression l, Expression r) {
		this.leftExpr = l;
		this.rightExpr = r;
		this.operator = " + ";
	}
	public String addToExpression() {
		return " + " + rightExpr.toString() + " = " + evaluate(); 
	}
	
	//Returns Int-Value of the Addition
	public Value evaluate() {	
		return new Value(leftExpr.evaluate().getValue()+ rightExpr.evaluate().getValue());
		}
}
