package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class TagApi extends ApiKey{
    private BaseApiDto baseApiDto = new BaseApiDto();

    public BaseApiDto getBaseApiDto() {
        return baseApiDto;
    }

    public void getListTag() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("app-id", key)
                .header("Accept", "application/json")
                .when()
                .get(baseApiDto.getEndPoint());

        baseApiDto.setStatusCode(response.getStatusCode());

        /*Set Response body*/
        baseApiDto.setListTag(response.jsonPath().getList("data"));
    }
}
