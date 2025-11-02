package stepdef.api;

import api.GetUsersApi;
import api.UserDto;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GetUsersStepDefApi {

    private final GetUsersApi getUsersApi = new GetUsersApi();

    @Given("insert end point to get user {string}")
    public void insertEndPointToGetUser(String endPoint){
        getUsersApi.getBaseApiDto().setEndPoint(endPoint);
    }

    @And("send request")
    public void sendRequest() {
        getUsersApi.getUsers();
    }

    @Then("user received list data user with response {int} and total data more than {int}")
    public void userReceivedListDataUserWithResponseAndTotalDataMoreThan(int responseCode, int totalData) {
        Assert.assertEquals(responseCode, getUsersApi.getBaseApiDto().getStatusCode());
        Assert.assertTrue(totalData < getUsersApi.getBaseApiDto().getTotalData());
    }

    /*get user by id*/
    @And("insert id user {string}")
    public void insertIdUser(String userId) {
        getUsersApi.getBaseApiDto().setUserDto(new UserDto());
        getUsersApi.getBaseApiDto().getUserDto().setId(userId);
    }

    @And("send request by id")
    public void sendRequestById() {
        getUsersApi.getUsersById();
    }

    @And("user received list data user with response {int}")
    public void userReceivedListDataUserWithResponse(int responseCode) {
        Assert.assertEquals(responseCode, getUsersApi.getBaseApiDto().getStatusCode());
    }

    @Then("user first name = {string} and user last name {string}")
    public void userFirstNameAndUserLastName(String firstName, String lastName) {
        Assert.assertEquals(firstName, getUsersApi.getBaseApiDto().getUserDto().getFirstName());
        Assert.assertEquals(lastName, getUsersApi.getBaseApiDto().getUserDto().getLastName());
    }

    /*invalid id*/
    @And("send request by invalid id")
    public void sendRequestByInvalidId() {
        getUsersApi.getUsersByInvalidId();
    }

    @Then("error {string}")
    public void error(String error) {
        Assert.assertEquals(error, getUsersApi.getBaseApiDto().getError());
    }


}
