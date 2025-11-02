package stepdef.api;

import api.CreateUserApi;
import api.UserDto;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import tools.Generator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CrateUserStepDefApi {

    private CreateUserApi createUserApi = new CreateUserApi();

    @Given("insert end point to create user {string}")
    public void insertEndPointToCreateUser(String endPoint){
        createUserApi.getBaseApiDto().setEndPoint(endPoint);
    }

    @And("insert first name {string}")
    public void insertFirstName(String firstName) {
        createUserApi.getBaseApiDto().setUserDto(new UserDto());
        createUserApi.getBaseApiDto().getUserDto().setFirstName(firstName);
    }

    @And("insert last name {string}")
    public void insertLastName(String lastName) {
        createUserApi.getBaseApiDto().getUserDto().setLastName(lastName);
    }

    @And("insert email {string}")
    public void insertEmail(String email) {
        /*Avoid email duplicate create unique val*/
        String uniqueVal = Generator.getUniqueVal();
        email = email.replace("???", uniqueVal);

        createUserApi.getBaseApiDto().getUserDto().setEmail(email);
    }

    @And("send request create user")
    public void sendRequestCreateUser() {
        createUserApi.createUsers();
    }

    @And("response code create user {int}")
    public void responseCodeCreateUser(int responseCode) {
        Assert.assertEquals(responseCode, createUserApi.getBaseApiDto().getStatusCode());
    }

    @Then("user first name = {string} and user last name {string} and have id")
    public void userFirstNameAndUserLastNameAndHaveId(String firstName, String lastName) {
        Assert.assertEquals(firstName, createUserApi.getBaseApiDto().getUserDto().getFirstName());
        Assert.assertEquals(lastName, createUserApi.getBaseApiDto().getUserDto().getLastName());
        Assert.assertFalse(createUserApi.getBaseApiDto().getUserDto().getId().isBlank());

    }

    @And("send request create duplicate user")
    public void sendRequestCreateDuplicateUser() {
        createUserApi.createUsersError();
    }

    @Then("error {string} and error body message {string};")
    public void errorAndErrorBodyMessage(String error, String message) {
        Assert.assertEquals(error, createUserApi.getBaseApiDto().getError());
        Assert.assertEquals(message, createUserApi.getBaseApiDto().getErrorMessage());
    }
}
