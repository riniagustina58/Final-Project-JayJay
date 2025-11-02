package api;

public class BaseApiDto {


    private String endPoint;
    private int statusCode;
    private int totalData;
    private String error;
    private String errorMessage;


    private UserDto UserDto;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public UserDto getUserDto() {
        return UserDto;
    }

    public void setUserDto(UserDto userDto) {
        UserDto = userDto;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
