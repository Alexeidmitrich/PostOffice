package postoffice;

public class Person {
    protected int id;
    protected String city;
    protected String street;
    protected String numberhouse;
    protected String housebuilding;
    protected  String flat;
    protected String firstname;
    protected String lastname;
    protected String phone;
    //protected int postid;
    protected NumberPostOffice numberPostOffice;

    public Person(int id, String city,String street, String numberhouse, String housebuilding,String flat,String firstname, String lastname, String phone, NumberPostOffice numberPostOffice){
        this.id = id;
        this.city = city;
        this.street = street;
        this.numberhouse = numberhouse;
        this.housebuilding = housebuilding;
        this.flat = flat;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.numberPostOffice = numberPostOffice;
    }

    public Person(String city,String street, String numberhouse, String housebuilding,String flat,String firstname, String lastname, String phone){
        this.city = city;
        this.street = street;
        this.numberhouse = numberhouse;
        this.housebuilding = housebuilding;
        this.flat = flat;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberhouse() {
        return numberhouse;
    }

    public void setNumberhouse(String numberhouse) {
        this.numberhouse = numberhouse;
    }

    public String getHousebuilding() {
        return housebuilding;
    }

    public void setHousebuilding(String housebuilding) {
        this.housebuilding = housebuilding;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public NumberPostOffice getNumberPostOffice() {
        return numberPostOffice;
    }

    public void setNumberPostOffice(NumberPostOffice numberPostOffice) {
        this.numberPostOffice = numberPostOffice;
    }

    public void printInformation(){

        System.out.println(getId() + " " + getCity() + " " + getStreet() + " " + getNumberhouse() + " " + getHousebuilding() + " " + getFlat() + " " + getFirstname() + " " + getLastname() + " " + getPhone() + " " + getNumberPostOffice());
    }
}

