package de.upb.se.arithmetics;

public class Exponentiation extends Operations {
	public Exponentiation(Expression l, Expression r) {
		this.leftExpr = l;
		this.rightExpr = r;
		this.operator = " ^ ";

	}

	public Value evaluate() {	
		return new Value(pow(leftExpr.evaluate().getValue(), rightExpr.evaluate().getValue()));
		}

	@Override
	public String addToExpression() {
		return " ^ " + rightExpr.toString() + " = " + evaluate(); 
	}

	public int pow(int l, int r) {
		int res = l;
		for(int i = 1; i < r;i++) {
			res *= l;
		}
		return res;
	}

}
