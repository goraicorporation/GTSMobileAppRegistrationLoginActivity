package myproject.athome.chakuri.model.login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginResponse {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("gts_user_login_tries")
    @Expose
    private Integer gtsUserLoginTries;
    @SerializedName("status_code")
    @Expose
    private String statusCode;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getGtsUserLoginTries() {
        return gtsUserLoginTries;
    }

    public void setGtsUserLoginTries(Integer gtsUserLoginTries) {
        this.gtsUserLoginTries = gtsUserLoginTries;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "success='" + success + '\'' +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                ", gtsUserLoginTries=" + gtsUserLoginTries +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}