package eli.swimming_pool.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    @JsonProperty
    private String id;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private Date birthdate;
    @JsonProperty
    private String address;

    public User(String id, String firstName, String lastName, Date birthdate, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    private void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public static User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getString("id"), resultSet.getString("first_name"),
                resultSet.getString("last_name"), resultSet.getDate("birthdate"), resultSet.getString("address"));
    }
}
