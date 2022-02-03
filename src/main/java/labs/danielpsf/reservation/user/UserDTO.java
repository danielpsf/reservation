package labs.danielpsf.reservation.user;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserDTO {

    private UUID id;

    @NotNull
    @Size(max = 255)
    private String fisrtName;

    @NotNull
    @Size(max = 255)
    private String lastName;

    @NotNull
    @Size(max = 255)
    private String street;

    @NotNull
    @Size(max = 255)
    private String zipCode;

    @NotNull
    @Size(max = 255)
    private String state;

    @NotNull
    @Size(max = 3)
    private String country;

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(final String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

}
