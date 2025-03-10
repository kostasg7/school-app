package gr.aueb.cf.schoolapp.dto;

public class TeacherInsertDTO extends BaseDTO{

    public TeacherInsertDTO() {
    }

    public TeacherInsertDTO(String firstname, String lastname, String vat, String fatherName, String phoneNNum,
                            String email, String street, String streetNum, String zipCode, Integer cityId) {
        super(firstname, lastname, vat, fatherName, phoneNNum, email, street, streetNum, zipCode, cityId);
    }

}
