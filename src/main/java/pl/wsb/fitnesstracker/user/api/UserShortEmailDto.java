package pl.wsb.fitnesstracker.user.api;

public class UserShortEmailDto {
    public Long id;
    public String email;

    public UserShortEmailDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
