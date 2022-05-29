package MultiInheritance;

public abstract class Car {
    private String model;
    private String brand;
    private float volume;

    public Car (String model, String brand, float volume) {
        this.model = model;
        this.brand = brand;
        this.volume = volume;
    }

    public String getModel() {
        return model;
    }

    public void setName(String name) {
        this.model = name;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
}
