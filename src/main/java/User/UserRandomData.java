package User;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
public class UserRandomData {
    public static Faker faker = new Faker();

    @Step("Создание уникального юзера")
    public static User createRandomUser() {
        return new User(
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.internet().password());
    }

    @Step("Создание юзера без email")
    public static User createRandomUserWithoutEmail() {
        return new User(
                faker.name().firstName(),"",
                faker.internet().password());
    }

    @Step("Создание юзера без name")
    public static User createRandomUserWithoutName() {
        return new User("",
                faker.internet().emailAddress(),
                faker.internet().password());
    }

    @Step("Создание юзера без password")
    public static User createRandomUserWithoutPassword() {
        return new User(
                faker.name().firstName(),
                faker.internet().emailAddress(),"");
    }

    @Step("Создание юзера без name,email, password")
    public static User createNoDataUser() {
        return new User(
                "","","");
    }
}