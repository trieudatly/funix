import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {
    private long serialVersionUID = 1L;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String postcode;
    private String country;
    private Date createDate;


    public Company(String name, String email, String phone, String address, String postcode, String country) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                '}' + "\n";
    }
}
