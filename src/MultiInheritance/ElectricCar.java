package MultiInheritance;

public class ElectricCar extends Car implements iElectricCar{
    private float range;

    public ElectricCar(String model, String brand, float volume, float range) {
        super(model, brand, volume);
        this.range = range;
    }
    @Override
    public float getRange() {
        return range;
    }

    @Override
    public void setRange(float range) {

    }
}
