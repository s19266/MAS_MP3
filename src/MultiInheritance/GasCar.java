package MultiInheritance;

public class GasCar extends Car {
    private float tankCapacity;

    public GasCar(String model, String brand, float volume, float tankCapacity) {
        super(model, brand, volume);
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(float tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getMileage() {return getTankCapacity() * 20 / getVolume();}

}
