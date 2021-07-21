package myproject.athome.chakuri.model.api;


import myproject.athome.chakuri.model.login.LoginRequest;
import myproject.athome.chakuri.model.login.LoginResponse;
import myproject.athome.chakuri.model.registration.RegistrationRequest;
import myproject.athome.chakuri.model.registration.RegistrationResponse;
import myproject.athome.chakuri.model.userRoles.RoleRequest;
import myproject.athome.chakuri.model.userRoles.RoleResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface APIService {

    @Headers({"Content-Type: application/json;charset=utf-8"})

    @POST("email")
    Call<RegistrationResponse>
    createUser(@Body RegistrationRequest registrationRequest);

    @PUT("login/email")
    Call<LoginResponse>
    loginUser(@Body LoginRequest loginRequest);

    @POST("role")
    Call<RoleResponse>
    createRole(@Body RoleRequest roleRequest);


}
