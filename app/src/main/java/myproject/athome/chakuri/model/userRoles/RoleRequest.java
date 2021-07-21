package myproject.athome.chakuri.model.userRoles;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoleRequest  {

    @SerializedName("gts_user_id")
    private Integer gtsUserId;
    @SerializedName("userRole")
    private List<UserRoleDTO> userRole;

    public Integer getGtsUserId() {
        return gtsUserId;
    }

    public void setGtsUserId(Integer gtsUserId) {
        this.gtsUserId = gtsUserId;
    }

    public List<UserRoleDTO> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRoleDTO> userRole) {
        this.userRole = userRole;
    }

    public RoleRequest(Integer gtsUserId, List<UserRoleDTO> userRole) {
        this.gtsUserId = gtsUserId;
        this.userRole = userRole;
    }
}