package myproject.athome.chakuri.model.userRoles;

import com.google.gson.annotations.SerializedName;

public class UserRoleDTO {
    @SerializedName("gts_role_id")
    private Integer gtsRoleId;
    @SerializedName("gts_user_role_is_primary")
    private Integer gtsUserRoleIsPrimary;
}
