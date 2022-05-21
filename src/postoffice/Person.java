package postoffice;

public class Person {
    protected String address;
    protected String firstname;
    protected String phone;

    public Person(String address, String firstname, String phone){
        this.address = address;
        this.firstname = firstname;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void printInformation(){
        System.out.println(getAddress() + " " + getFirstname() + " " + getPhone());
    }
}

