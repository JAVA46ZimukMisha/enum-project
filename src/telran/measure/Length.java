package telran.measure;

public class Length implements Comparable<Length> {
	private final float amount;
	private final LengthUnit unit;
	
	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	@Override
	/**
	 * equals two Length objects according to LengthUnit
	 * 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		return obj.getClass() == this.getClass() 
				? this.amount*this.unit.value == ((Length) obj).amount*((Length) obj).unit.value 
				: false;
	}

	@Override
	public int compareTo(Length o) {
		return (int) (this.amount*this.unit.value - o.amount*o.unit.value);
	}
	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 * convert(LengthUnit.M) returns Length in meters 
	 */
	public Length convert(LengthUnit unit) {
		float newAmount = this.amount*this.unit.value/unit.value;
		return  new Length(newAmount, unit);
	}
	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20M (string expression of Length object designed 20 meters)
	 */
	public String toString() {
		return String.format("%.0f%s",this.amount, this.unit);
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}
	
	

}