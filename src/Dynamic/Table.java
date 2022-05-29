package Dynamic;

public abstract class Table {

	protected int tableNumber;
	protected int numberOfChairs;

	public Table(int tableNumber, int numberOfChairs) {
		this.tableNumber = tableNumber;
		this.numberOfChairs = numberOfChairs;
	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " number: " + this.tableNumber + "; Number of chairs: " + this.numberOfChairs;
	}
}
