package de.upb.se.arithmetics;

import java.util.ArrayList;

public abstract class Expression {
	public Expression leftExpr, rightExpr;
	public String operator;
	public abstract Value evaluate();

	public String getOperationAsString() {return leftExpr.toString() + operator + rightExpr.toString();}
	
	//Returns a String representation of the Equation
	public String getEquationAsString()	{return getOperationAsString()+ " = " + evaluate();}
	public String toString() {
		return leftExpr.evaluate().toString() + " " + operator +" " + rightExpr.evaluate().toString();
	}
	
	public static String addParentheses(String expression) {
		//Split the expression, result part doesn't need Parentheses
		String equalsAndResult = "=" + expression.split("=")[1];
		ArrayList<String> input = new ArrayList<String>(splitExpression(expression.split(" =")[0]));
		StringBuilder builder = new StringBuilder();
		
		//Add the Parentheses
		//Last Operator + or -, remove the former last ")" and add a new on at the end
		if(input.get(input.size()-3).equals(")")) {
			String lastOperator = input.get(input.size()-2);
			if("+".equals(lastOperator) ||"-".equals(lastOperator)) {
				input.remove(input.size()-3);
				input.addLast(")");
			}
		} else { //Last operator * or /, add ( at the Front and ) at the end
			String lastOperator = input.get(input.size()-2);
			if("+".equals(lastOperator)||"-".equals(lastOperator)||"%".equals(lastOperator)||"^".equals(lastOperator)) {
				input.addFirst("(");
				input.addLast(")");
			}
		}	
		//Put the Expression String together
		for (String str : input) {
			builder.append(str);
			builder.append(" ");
		}
		//Append the "=" and the result
		builder.append(equalsAndResult);
		
		//Remove unnecessary blank spaces
		String resultString = builder.toString().replace("( ", "(");
		resultString = resultString.replace(" )", ")");
		
		return resultString;
	}
	
	//Splits the String after every Number or operator/sign
    public static ArrayList<String> splitExpression(String expression) {
		ArrayList<String> components = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        //Iterate over the chars in the input String
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')'|| ch == '%' || ch == '^') {
                // Add the previous number to the components list 
                if (number.length() > 0) {
                    components.add(number.toString());
                    number.setLength(0);
                }
                // Add the operator to the components list
                components.add(Character.toString(ch));
            }
        }
        // Add the last number to the components list if exists
        if (number.length() > 0) {
            components.add(number.toString());
        }
        
        return components;
    }

	
}
