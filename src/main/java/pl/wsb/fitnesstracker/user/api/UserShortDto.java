package pl.wsb.fitnesstracker.user.api;

public class UserShortDto {
    public Long id;
    public String firstName;
    public String lastName;

    public UserShortDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
