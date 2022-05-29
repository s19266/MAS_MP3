package MultiInheritance;

public class HybridCar extends GasCar implements iElectricCar{
    private float range;

    public HybridCar(String model, String brand, float volume, float tankCapacity, float range) {
        super(model, brand, volume, tankCapacity);
        this.range = range;
    }

    @Override
    public float getRange() {
        return range;
    }

    @Override
    public void setRange(float range) {
        this.range = range;
    }

    @Override
    public double getMileage() {
        return super.getMileage() + getRange();
    }
}
