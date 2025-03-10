package gr.aueb.cf.schoolapp.dto;

public abstract class BaseDTO {


    private String firstname;
    private String lastname;
    private String vat;
    private String fatherName;
    private String phoneNNum;
    private String email;
    private String street;
    private String streetNum;
    private String zipCode;
    private Integer cityId;

    public BaseDTO() {
    }

    public BaseDTO(String firstname, String lastname, String vat, String fatherName, String phoneNNum,
                   String email, String street, String streetNum, String zipCode, Integer cityId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.vat = vat;
        this.fatherName = fatherName;
        this.phoneNNum = phoneNNum;
        this.email = email;
        this.street = street;
        this.streetNum = streetNum;
        this.zipCode = zipCode;
        this.cityId = cityId;
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

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPhoneNNum() {
        return phoneNNum;
    }

    public void setPhoneNNum(String phoneNNum) {
        this.phoneNNum = phoneNNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
