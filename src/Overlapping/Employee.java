package Overlapping;

import java.util.Date;
import java.util.EnumSet;

public class Employee {
	private String firstName;

	private String lastName;
	
	private Date endOfTrainingDate;
	
	private String cookLicenseNumber;
	
	private EnumSet<EmployeeType> types = EnumSet.of(EmployeeType.Employee);
	
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void makeCook(String cookLicenseNumber) {
		this.cookLicenseNumber = cookLicenseNumber;
		this.types.add(EmployeeType.Cook);
	}
	
	public void removeCookType() {
		this.endOfTrainingDate = null;
		this.types.remove(EmployeeType.Cook);
	}
	
	public void makeSeller(Date dateOfTerminalTraining) {
		this.endOfTrainingDate = dateOfTerminalTraining;
		this.types.add(EmployeeType.Seller);
	}
	
	public void removeSellerType() {
		this.cookLicenseNumber = null;
		this.types.remove(EmployeeType.Seller);
	}

	public Date getEndOfTrainingDate() throws Exception {
		if (!this.types.contains(EmployeeType.Seller)) {
			throw new Exception("Employee is not a seller");
		}

		return endOfTrainingDate;
	}

	public void setEndOfTrainingDate(Date endOfTrainingDate) throws Exception  {
		if (!this.types.contains(EmployeeType.Seller)) {
			throw new Exception("Employee is not a seller");
		}

		this.endOfTrainingDate = endOfTrainingDate;
	}

	public String getCookLicenseNumber() throws Exception  {
		if (!this.types.contains(EmployeeType.Cook)) {
			throw new Exception("Employee is not a cook");
		}

		return cookLicenseNumber;
	}

	public void setCookLicenseNumber(String cookLicenseNumber) throws Exception {
		if (!this.types.contains(EmployeeType.Cook)) {
			throw new Exception("Employee is not a cook");
		}

		this.cookLicenseNumber = cookLicenseNumber;
	}

	public EnumSet<EmployeeType> getTypes() {
		return types;
	}
}
