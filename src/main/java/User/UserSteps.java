package User;

import Endpoints.API;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;



public class UserSteps {
    UserSteps userSteps;

    Response response;

    public static RequestSpecification requestSpecification() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(API.BASE_URL);
    }

    @Step("Регистрация нового пользователя")
    public Response userCreate(User user) {
        return requestSpecification()
                .body(user)
                .post(API.CREATE_USER);
    }

    @Step("Обновление информации о юзере")
    public Response userProfileChanging(User newUser, String accessToken) {
        return requestSpecification()
                .header("Authorization", accessToken)
                .body(newUser)
                .patch(API.USER);
    }

    @Step("Авторизация пользователя по логину")
    public Response userLogin(User user) {
        return requestSpecification()
                .body(user)
                .post(API.LOGIN_USER);
    }



    @Step("Удаление профиля пользователя")
    public Response userDelete(String accessToken) {
       return requestSpecification()
                .header("Authorization", accessToken)
                .delete(API.USER);
    }
    @Step("Получение токена")
    public String getToken(User user) {
        response = userLogin(user);
        return response.then().extract().body().path("accessToken");
    }
}

