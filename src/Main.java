import java.util.Date;

import Abstract.*;
import Dynamic.IndoorTable;
import Dynamic.OutdoorTable;
import Dynamic.Table;
import MultiAspect.Order;
import MultiAspect.OrderWithDelivery;
import MultiAspect.OrderWithSelfPickup;
import MultiAspect.PaymentMethod;
import MultiInheritance.GasCar;
import MultiInheritance.ElectricCar;
import MultiInheritance.HybridCar;
import Overlapping.Employee;
import utils.Exceptions;

public class Main {

	public static void main(String[] args) throws Exception {
		// ==== Abstract / polimorfizm ====
		System.out.println("Abstract / polimorfizm");
		var ed = new ExpressDelivery("Address 1", 30);
		var sd = new StandardDelivery("Address 1", 3);


		System.out.println("Express delivery price: " + ed.calculateDeliveryPrice());
		System.out.println("Standard delivery price: " + sd.calculateDeliveryPrice());
		System.out.println("\n------------------------------------------------------------\n");
		
		// ==== Overlapping ====
		System.out.println("Overlapping");
		var cook = new Employee("CookName", "CookSurname");
		cook.makeCook("00001");
		
		var seller = new Employee("SellerName", "SellerSurname");
		seller.makeSeller(new Date());

		var sellerAndCook = new Employee("OverlappingName", "OverlappingSurname");
		sellerAndCook.makeCook("00002");
		sellerAndCook.makeSeller(new Date(1623409980000l));
		
		System.out.println("Cook license number:");
		System.out.println(cook.getCookLicenseNumber());
		System.out.println("Seller end of training date:");
		System.out.println(seller.getEndOfTrainingDate().toString());
		
		System.out.println("Cook and Seller license and end of training date:");
		System.out.println(sellerAndCook.getCookLicenseNumber());
		System.out.println(sellerAndCook.getEndOfTrainingDate().toString());
		
		System.out.println("Cook try to access end of training date:");
		Exceptions.printExpectedException(() -> cook.getEndOfTrainingDate().toString());

		System.out.println("Seller try to access cook license:");
		Exceptions.printExpectedException(() -> seller.getCookLicenseNumber());
		System.out.println("\n------------------------------------------------------------\n");
		
		// ==== Dynamic ====
		System.out.println("Dynamic");
		Table table = new OutdoorTable(1,2, true);
		System.out.println(table);

		System.out.println("Changing table type");
		table = new IndoorTable(table, true);
		System.out.println(table);

		System.out.println("\n------------------------------------------------------------\n");

		// ==== Multi Inheritance ====
		System.out.println("Multi Inheritance");
		System.out.println("Hybrid Car: Volume 2.0, Tank capacity 50, electric range 250");
		var hybridCar = new HybridCar("Yaris", "Toyota", 2.0f,50, 250.00f);
		System.out.println("HybridCar mileage:");
		System.out.println(hybridCar.getMileage());

		System.out.println("Gas Car: Volume 1.8, Tank capacity 70");
		var gasCar = new GasCar("Yaris", "Toyota", 1.8f,70);
		System.out.println("GasCar mileage:");
		System.out.println(gasCar.getMileage());
		System.out.println("\n------------------------------------------------------------\n");

		// ==== Multi Aspect Inheritance ====
		System.out.println("Multi Aspect Inheritance");
		var deliveryOnPickupOrder = new OrderWithDelivery(
			Order.createPaymentOnPickupOrder(100, PaymentMethod.Card),
			"address"
		);
		
		System.out.println("WithDelivery and PaymentOnPickup details:");
		System.out.println(deliveryOnPickupOrder.getAddress());
		System.out.println(deliveryOnPickupOrder.getPaymentMethod().toString());
		Exceptions.printExpectedException(() -> deliveryOnPickupOrder.getCardNumber());
		
		var deliveryPrepaymentOrder = new OrderWithDelivery(
			Order.createPrepaymentOrder(100, "6789987612344321"),
			"address"
		);
		
		System.out.println("WithDelivery and Prepayment details:");
		System.out.println(deliveryPrepaymentOrder.getAddress());
		System.out.println(deliveryPrepaymentOrder.getCardNumber());
		Exceptions.printExpectedException(() -> deliveryPrepaymentOrder.getPaymentMethod());
		
		var selfPickupOnPickupOrder = new OrderWithSelfPickup(
			Order.createPaymentOnPickupOrder(100, PaymentMethod.Card),
			new Date()
		);
		
		System.out.println("WithDelivery and PaymentOnPickup details:");
		System.out.println(selfPickupOnPickupOrder.getPickupDate().toString());
		System.out.println(selfPickupOnPickupOrder.getPaymentMethod().toString());
		Exceptions.printExpectedException(() -> selfPickupOnPickupOrder.getCardNumber());
		
		var selfPickupPrepaymentOrder = new OrderWithSelfPickup(
			Order.createPrepaymentOrder(100, "1234432167899876"),
			new Date()
		);
		
		System.out.println("WithDelivery and Prepayment details:");
		System.out.println(selfPickupPrepaymentOrder.getPickupDate().toString());
		System.out.println(selfPickupPrepaymentOrder.getCardNumber());
		Exceptions.printExpectedException(() -> selfPickupPrepaymentOrder.getPaymentMethod());
	}
}
