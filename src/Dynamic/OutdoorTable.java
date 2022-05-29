package Dynamic;

public class OutdoorTable extends Table{
    private Boolean isUnderUmbrella;

    public OutdoorTable(int tableNumber,int numberOfChairs, Boolean isUnderUmbrella){
        super(tableNumber, numberOfChairs);
        this.isUnderUmbrella = isUnderUmbrella;
    }

    public OutdoorTable(Table table, Boolean isUnderUmbrella){
        super(table.tableNumber, table.numberOfChairs);
        this.isUnderUmbrella = isUnderUmbrella;
    }
}
