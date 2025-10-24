package tests;

import api.UserApi;
import config.Settings;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    private UserApi userApi;
    private final String testUsername = "autoUser123";

    @BeforeClass
    public void setup() {
        RequestSpecification request = RestAssured.given().baseUri(Settings.getBaseUrl());
        userApi = new UserApi(request);
    }

    @Test(priority = 1)
    public void createUser() {
        User newUser = User.builder().username(testUsername).build();
        userApi.createUser(newUser);
    }

    @Test(priority = 2)
    public void getUser() {
        User fetchedUser = userApi.getUser(testUsername);
        Assert.assertEquals(fetchedUser.getUsername(), testUsername);
    }

    @Test(priority = 3)
    public void updateUser() {
        User updatedUser = User.builder()
                .username(testUsername)
                .firstName("UpdatedName")
                .build();
        userApi.updateUser(testUsername, updatedUser);
    }

    @Test(priority = 4)
    public void deleteUser() {
        userApi.deleteUser(testUsername);
    }
}
