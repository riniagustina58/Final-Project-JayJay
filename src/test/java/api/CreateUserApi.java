package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class CreateUserApi extends ApiKey{

    private BaseApiDto baseApiDto = new BaseApiDto();

    public BaseApiDto getBaseApiDto() {
        return baseApiDto;
    }

    public void createUsers() {

        JSONObject bodyObj = new JSONObject();
        bodyObj.put("firstName", baseApiDto.getUserDto().getFirstName());
        bodyObj.put("lastName", baseApiDto.getUserDto().getLastName());
        bodyObj.put("email", baseApiDto.getUserDto().getEmail());


        Response response = RestAssured.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("app-id", key)
                .header("Accept", "application/json")
                .body(bodyObj.toString())
                .when()
                .post(baseApiDto.getEndPoint());

        baseApiDto.setStatusCode(response.getStatusCode());

        /*Set Response body*/
        baseApiDto.getUserDto().setId(response.jsonPath().get("id"));
        baseApiDto.getUserDto().setFirstName(response.jsonPath().get("firstName"));
        baseApiDto.getUserDto().setLastName(response.jsonPath().get("lastName"));
        baseApiDto.getUserDto().setEmail(response.jsonPath().get("email"));
    }

    public void createUsersError() {

        JSONObject bodyObj = new JSONObject();
        bodyObj.put("firstName", baseApiDto.getUserDto().getFirstName());
        bodyObj.put("lastName", baseApiDto.getUserDto().getLastName());
        bodyObj.put("email", baseApiDto.getUserDto().getEmail());


        Response response = RestAssured.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("app-id", key)
                .header("Accept", "application/json")
                .body(bodyObj.toString())
                .when()
                .post(baseApiDto.getEndPoint());

        baseApiDto.setStatusCode(response.getStatusCode());

        /*Set Response body*/
        baseApiDto.setError(response.jsonPath().getString("error"));
        baseApiDto.setErrorMessage(response.jsonPath().getString("data.email"));
    }

}
