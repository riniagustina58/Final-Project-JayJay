package stepdef.api;

import api.DeleteUserApi;
import api.UserDto;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DeleteUserStepDefApi {

    private DeleteUserApi deleteUserApi = new DeleteUserApi();

    @Given("insert end point to create delete user {string}")
    public void insertEndPointToCreateDeleteUser(String endPoint) {
        deleteUserApi.getBaseApiDto().setEndPoint(endPoint);
    }

    @And("create user with first name {string} and last name {string} and email {string}")
    public void createUserWithFirstNameAndLastNameAndEmail(String firstName, String lastName, String email) {
        deleteUserApi.getBaseApiDto().setUserDto(new UserDto());
        deleteUserApi.getBaseApiDto().getUserDto().setFirstName(firstName);
        deleteUserApi.getBaseApiDto().getUserDto().setLastName(lastName);
        deleteUserApi.getBaseApiDto().getUserDto().setEmail(email);
    }

    @And("send request create delete user")
    public void sendRequestCreateDeleteUser() {
        deleteUserApi.createUsers();
    }

    @And("response code create delete user {int}")
    public void responseCodeCreateDeleteUser(int responseCode) {
        Assert.assertEquals(responseCode, deleteUserApi.getBaseApiDto().getStatusCode());
    }

    @And("insert end point to delete user {string}")
    public void insertEndPointToDeleteUser(String endPoint) {
        deleteUserApi.getBaseApiDto().setEndPoint(endPoint);
    }

    @And("send request delete user")
    public void sendRequestDeleteUser() {
       deleteUserApi.deleteUsers();
    }

    @Then("response code delete user {int}")
    public void responseCodeDeleteUser(int responseCode) {
        Assert.assertEquals(responseCode, deleteUserApi.getBaseApiDto().getStatusCode());
    }


    @And("send request delete user again")
    public void sendRequestDeleteUserAgain() {
        deleteUserApi.deleteUsersAgain();
    }

    @Then("response message {string}")
    public void responseMessage(String messageError) {
        Assert.assertEquals(messageError, deleteUserApi.getBaseApiDto().getError());
    }

    @And("insert delete user id {string}")
    public void insertDeleteUserId(String id) {
        deleteUserApi.getBaseApiDto().setUserDto(new UserDto());
        deleteUserApi.getBaseApiDto().getUserDto().setId(id);
    }
}
