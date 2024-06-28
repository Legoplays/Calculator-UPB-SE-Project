package de.upb.se.arithmetics;

public class Value extends Expression {
	Integer value;
	//Constructor for given initial integer Value
	public Value(int value)	{this.value = value;}
	
	//Second constructor for initial value 0
	public Value() { this.value = 0;}
	
	public String toString() {return value.toString();}

	public int getValue() {return value.intValue();}
	
	public static Value parseValue(String input) {return new Value(Integer.parseInt(input));}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Value))
			return false;
		Value other = (Value) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}	

	public String getOperationAsString() {return this.toString();}
	
	public Value evaluate() {return this;}

}
