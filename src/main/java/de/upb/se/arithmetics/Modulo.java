package de.upb.se.arithmetics;

public class Modulo extends Operations {
	//Constructor
	public Modulo(Expression l, Expression r) {
		this.leftExpr = l;
		this.rightExpr = r;
		this.operator = " % ";

	}
	//Returns String representation of the Modulo operation
	public Value evaluate() {	
		return new Value(leftExpr.evaluate().getValue() % rightExpr.evaluate().getValue());
		}

	@Override
	public String addToExpression() {
		return " % " + rightExpr.toString() + " = " + evaluate(); 
	}
}
