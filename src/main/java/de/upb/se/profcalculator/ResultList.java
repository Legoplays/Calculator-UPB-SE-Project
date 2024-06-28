package de.upb.se.profcalculator;

import java.util.List;

import de.upb.se.arithmetics.Value;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class ResultList {
	List<Value> results;
	List<String> expressions;
	public boolean boolShowExpressionList;

	public ResultList() {
		this.results = new ArrayList<Value>();
		this.expressions = new ArrayList<String>();
		this.boolShowExpressionList = false;
	}

	/*
	 * Checks if a result is already in the "result"-List
	 * and returns a corresponding Message:
	 * Value not in List: Returns "New Result"
	 * Value in List: Returns "Old Result" and the Number of operations since the Result last occurred
	 */
	public String handleResultList(Value result) {
		if (this.results.isEmpty()) {
			return "";
		} else if (this.results.contains(result)) {
			return "Old Result (Steps since last Occurrence: "
					+ (this.results.size() - this.results.lastIndexOf(result)) + ")";
		} else {
			return "New Result";
		}
	}

	// Adds the new Result to the results-List and the corresponding Equation to the
	// "expression"-List
	public void add(Value result, String expr) {
		this.results.add(result);
		this.expressions.add(expr);
	}

	// Returns the last Element of the "results"-List
	public Value getLast() {
		if (this.results.isEmpty()) {
			return new Value();
		} else {
			return this.results.getLast();
		}
	}

	public void clear() {
		this.results.clear();
		this.expressions.clear();
	}

	// Builds and Returns a String containing all unique Expressions in the
	// "expression"-List
	public String showExpressionList() {
		List<String> printed = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.expressions.size(); i++) {
			if (printed.contains(this.expressions.get(i))) {
				continue;
			} else {
				builder.append(this.expressions.get(i) + "\n");
				printed.add(this.expressions.get(i));
			}
		}
		return builder.toString();
	}
}
