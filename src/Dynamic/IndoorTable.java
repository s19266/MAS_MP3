package Dynamic;

public class IndoorTable extends Table{
    private Boolean isInSmokingArea;

    public IndoorTable(int tableNumber, int numberOfChairs, Boolean isInSmokingArea) {
        super(tableNumber, numberOfChairs);
        this.isInSmokingArea = isInSmokingArea;
    }
    public IndoorTable(Table table, Boolean isInSmokingArea) {
        super(table.tableNumber, table.numberOfChairs);
        this.isInSmokingArea = isInSmokingArea;
    }
}
