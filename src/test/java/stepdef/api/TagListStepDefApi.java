package stepdef.api;

import api.TagApi;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TagListStepDefApi {
    private TagApi tagApi = new TagApi();
    
    @Given("insert end point to get tag {string}")
    public void insertEndPointToGetTag(String endPoint){
        tagApi.getBaseApiDto().setEndPoint(endPoint);
    }

    @And("send request tag")
    public void sendRequestTag() {
        tagApi.getListTag();
    }

    @Then("user received list tag with response {int} and total data more than {int}")
    public void userReceivedListTagWithResponseAndTotalDataMoreThan(int responseCode, int totalData) {
        Assert.assertEquals(responseCode, tagApi.getBaseApiDto().getStatusCode());
        Assert.assertNotNull(tagApi.getBaseApiDto().getListTag());
        Assert.assertTrue(tagApi.getBaseApiDto().getListTag().size() > totalData);
    }
}
