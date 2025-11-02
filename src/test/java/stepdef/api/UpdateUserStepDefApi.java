package stepdef.api;

import api.UpdateUserApi;
import api.UserDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class UpdateUserStepDefApi {

    private UpdateUserApi updateUserApi = new UpdateUserApi();

    @Given("insert end point to update user {string}")
    public void insertEndPointToUpdateUser(String endPoint){
        updateUserApi.getBaseApiDto().setEndPoint(endPoint);
    }

    @And("insert id {string}")
    public void insertId(String id) {
        updateUserApi.getBaseApiDto().setUserDto(new UserDto());
        updateUserApi.getBaseApiDto().getUserDto().setId(id);
    }

    @And("insert update first name {string}")
    public void insertUpdateFirstName(String firstName) {
        updateUserApi.getBaseApiDto().getUserDto().setFirstName(firstName);
    }

    @And("insert update last name {string}")
    public void insertUpdateLastName(String lastName) {
        updateUserApi.getBaseApiDto().getUserDto().setLastName(lastName);

    }

    @And("send request update user")
    public void sendRequestUpdateUser() {
        updateUserApi.updateUsers();
    }

    @And("response code update user {int}")
    public void responseCodeUpdateUser(int responseCode) {
        Assert.assertEquals(responseCode, updateUserApi.getBaseApiDto().getStatusCode());
    }

    @Then("user update first name = {string} and user last name {string}")
    public void userUpdateFirstNameAndUserLastName(String firstName, String lastName) {
        Assert.assertEquals(firstName, updateUserApi.getBaseApiDto().getUserDto().getFirstName());
        Assert.assertEquals(lastName, updateUserApi.getBaseApiDto().getUserDto().getLastName());
    }

    /*Invalid Id*/
    @And("send request update invalid user")
    public void sendRequestUpdateInvalidUser() {
        updateUserApi.updateUsersInvalid();
    }

    @And("response code update invalid user {int}")
    public void responseCodeUpdateInvalidUser(int responseCode) {
        Assert.assertEquals(responseCode, updateUserApi.getBaseApiDto().getStatusCode());
    }

    @Then("error update {string}")
    public void errorUpdate(String error) {
        Assert.assertEquals(error, updateUserApi.getBaseApiDto().getError());
    }

    /*update email*/

    @And("insert update email {string}")
    public void insertUpdateEmail(String email) {
        updateUserApi.getBaseApiDto().getUserDto().setEmail(email);
    }

    @And("send request update email")
    public void sendRequestUpdateEmail() {
        updateUserApi.updateUsers();
    }

    @Then("email should be not updated {string}")
    public void emailShouldBeNotUpdated(String email) {
        Assert.assertNotEquals(email, updateUserApi.getBaseApiDto().getUserDto().getEmail());
    }
}
