package Abstract;

public abstract class Delivery {
	protected String deliveryAddress;

	public Delivery(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public abstract float calculateDeliveryPrice();
}
