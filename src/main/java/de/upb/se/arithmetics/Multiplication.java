package de.upb.se.arithmetics;

public class Multiplication extends Operations{
	//Constructor
	public Multiplication(Expression l, Expression r) {
		this.leftExpr = l;
		this.rightExpr = r;
		this.operator = " * ";

	}
	

	
	//Returns Int-Value of the Multiplication
	public Value evaluate() {	
		return new Value(leftExpr.evaluate().getValue() * rightExpr.evaluate().getValue());
		}

	@Override
	public String addToExpression() {
		return " * " + rightExpr.toString() + " = " + evaluate(); 
	}
	

}

