package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class GetUsersApi extends ApiKey {

    private BaseApiDto baseApiDto = new BaseApiDto();

    public BaseApiDto getBaseApiDto() {
        return baseApiDto;
    }

    public void getUsers() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("app-id", key)
                .header("Accept", "application/json")
                .when()
                .get(baseApiDto.getEndPoint());

        baseApiDto.setStatusCode(response.getStatusCode());

        /*Set Response body*/
        baseApiDto.setTotalData(response.jsonPath().get("total"));
    }

    public void getUsersById() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("app-id", key)
                .header("Accept", "application/json")
                .when()
                .get(baseApiDto.getEndPoint() + "/" + baseApiDto.getUserDto().getId());

        baseApiDto.setStatusCode(response.getStatusCode());

        /*Set Response body*/
        baseApiDto.getUserDto().setFirstName(response.jsonPath().get("firstName"));
        baseApiDto.getUserDto().setLastName(response.jsonPath().get("lastName"));
    }

    public void getUsersByInvalidId() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("app-id", key)
                .header("Accept", "application/json")
                .when()
                .get(baseApiDto.getEndPoint() + "/" + baseApiDto.getUserDto().getId());

        baseApiDto.setStatusCode(response.getStatusCode());

        /*Set Response body*/
        baseApiDto.setError(response.jsonPath().getString("error"));
    }
}
