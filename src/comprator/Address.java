package comprator;

public class Address {
private int addId;
private String address;
public Address(int addId, String address) {
	super();
	this.setAddId(addId);
	this.setAddress(address);
}

public int getAddId() {
	return addId;
}

public void setAddId(int addId) {
	this.addId = addId;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "Address [addId=" + addId + ", address=" + address + "]";
}

}
