package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class User {
    @Builder.Default
    private long id = 1001;
    @Builder.Default
    private String username = "testUser";
    @Builder.Default
    private String firstName = "John";
    @Builder.Default
    private String lastName = "Doe";
    @Builder.Default
    private String email = "john.doe@test.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "1234567890";
    @Builder.Default
    private int userStatus = 1;
}
