package za.ac.sun.cs.green.expr;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IntVariable extends Variable {

	private final Integer lowerBound;

	private final Integer upperBound;
	
	@JsonCreator 
	public IntVariable(@JsonProperty("name")String name, @JsonProperty("lowerBound")Integer lowerBound, @JsonProperty("upperBound")Integer upperBound) {
		super(name);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public IntVariable(String name, Object original, Integer lowerBound, Integer upperBound) {
		super(name, original);
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public Integer getLowerBound() {
		return lowerBound;
	}

	public Integer getUpperBound() {
		return upperBound;
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.preVisit(this);
		visitor.postVisit(this);
	}

//	@Override
//	public int compareTo(Expression expression) {
//		IntVariable variable = (IntVariable) expression;
//		return getName().compareTo(variable.getName());
//	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof IntVariable) {
			IntVariable variable = (IntVariable) object;
			return getName().equals(variable.getName());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	@Override
	public String toString() {
		return getName();
	}

}
