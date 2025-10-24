package api;

import config.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.User;

import static io.restassured.RestAssured.given;

public class UserApi {
    private final RequestSpecification request;

    public UserApi(RequestSpecification requestSpecification) {
        this.request = requestSpecification;
    }

    public void createUser(User user) {
        given()
            .contentType(ContentType.JSON)
            .body(user)
        .when()
            .post(Endpoints.USER.getValue())
        .then()
            .statusCode(200);
    }

    public User getUser(String username) {
        return given()
            .contentType(ContentType.JSON)
            .pathParam("username", username)
        .when()
            .get(Endpoints.USER.getValue() + "/{username}")
        .then()
            .statusCode(200)
            .extract().as(User.class);
    }

    public void updateUser(String username, User user) {
        given()
            .contentType(ContentType.JSON)
            .pathParam("username", username)
            .body(user)
        .when()
            .put(Endpoints.USER.getValue() + "/{username}")
        .then()
            .statusCode(200);
    }

    public void deleteUser(String username) {
        given()
            .contentType(ContentType.JSON)
            .pathParam("username", username)
        .when()
            .delete(Endpoints.USER.getValue() + "/{username}")
        .then()
            .statusCode(200);
    }
}
