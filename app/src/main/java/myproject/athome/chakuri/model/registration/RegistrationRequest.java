package myproject.athome.chakuri.model.registration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RegistrationRequest {

    @SerializedName("gts_user_email")
    @Expose
    private String gtsUserEmail;
    @SerializedName("gts_user_password")
    @Expose
    private String gtsUserPassword;

    public RegistrationRequest(String gtsUserEmail, String gtsUserPassword) {
        this.gtsUserEmail = gtsUserEmail;
        this.gtsUserPassword = gtsUserPassword;
    }

    public String getGtsUserEmail() {
        return gtsUserEmail;
    }

    public void setGtsUserEmail(String gtsUserEmail) {
        this.gtsUserEmail = gtsUserEmail;
    }

    public String getGtsUserPassword() {
        return gtsUserPassword;
    }

    public void setGtsUserPassword(String gtsUserPassword) {
        this.gtsUserPassword = gtsUserPassword;
    }

}
