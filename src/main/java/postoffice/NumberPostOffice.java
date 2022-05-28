package postoffice;

public class NumberPostOffice {
    private int postid;
    private String city;

    public NumberPostOffice(int postid, String city){
        this.postid = postid;
        this.city = city;
    }

    public int getPostid() {
        return postid;
    }

    public String getCity() {
        return city;
    }
}

