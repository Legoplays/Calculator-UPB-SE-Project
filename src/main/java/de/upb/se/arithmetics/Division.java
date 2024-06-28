package de.upb.se.arithmetics;

public class Division extends Operations {
	//Constructor

	public Division(Expression l, Expression r) {
		this.leftExpr = l;
		this.rightExpr = r;
		this.operator = " / ";

	}
	
	//Returns Int-Value of the Division
	public Value evaluate() {	
		return new Value(leftExpr.evaluate().getValue() / rightExpr.evaluate().getValue());
		}

	@Override
	public String addToExpression() {
		return " / " + rightExpr.toString() + " = " + evaluate(); 
	}
}

