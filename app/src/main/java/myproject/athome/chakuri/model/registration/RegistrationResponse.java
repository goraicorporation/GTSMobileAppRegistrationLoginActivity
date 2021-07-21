package myproject.athome.chakuri.model.registration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RegistrationResponse {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("gts_user_id")
    @Expose
    private Integer gtsUserId;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

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

    public Integer getGtsUserId() {
        return gtsUserId;
    }

    public void setGtsUserId(Integer gtsUserId) {
        this.gtsUserId = gtsUserId;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "success='" + success + '\'' +
                ", message='" + message + '\'' +
                ", gtsUserId=" + gtsUserId +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}