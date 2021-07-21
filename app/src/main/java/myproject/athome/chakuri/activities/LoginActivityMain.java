package myproject.athome.chakuri.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Base64;

import myproject.athome.chakuri.MainNavigationBarActivity;
import myproject.athome.chakuri.R;
import myproject.athome.chakuri.WelcomePageActivityMain;
import myproject.athome.chakuri.model.login.LoginRequest;
import myproject.athome.chakuri.model.login.LoginResponse;
import myproject.athome.chakuri.model.remote.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivityMain extends MainNavigationBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_login, null, false);
        dl.addView(contentView, 0);

        Toolbar tb = findViewById(R.id.toolbar_main);
        setSupportActionBar(tb);

        final EditText log_email = findViewById(R.id.login_edit_email);
        final EditText log_password = findViewById(R.id.login_edit_pass);
        final TextView register = findViewById(R.id.register_now);

        Button btn_login = findViewById(R.id.btn_login);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Register", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivityMain.this, RegistrationActivityMain.class);
                startActivity(intent);
            }
        });


        mAPIService = APIUtils.getAPIService1();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = log_email.getText().toString().trim();
                String password = log_password.getText().toString().trim();

                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    log_email.setError("Enter Email", null);
                    log_email.requestFocus();
                    log_password.setError("Enter Password", null);
                    Toast.makeText(getApplicationContext(), "Please Enter Email & Password ", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    log_email.setError("Enter valid Email", null);
                    log_email.requestFocus();
                    Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    log_password.setError("Enter Password", null);
                    log_password.requestFocus();
                    Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();
                } else {

                    mAPIService.loginUser(new LoginRequest(email, password))
                            .enqueue(new Callback<LoginResponse>() {
                                @RequiresApi(api = Build.VERSION_CODES.O)
                                @Override
                                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                                    Log.d("", "post submitted to API." + response.body());

                                    if (response.body() == null) {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response.errorBody().string());

                                            Log.d("", "Error Response Body" + jsonObject);
                                            Log.d("", "Error Response Body" + jsonObject.optString("message"));

                                            String message = jsonObject.optString("message");
                                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                                        } catch (IOException | JSONException e) {
                                            e.printStackTrace();
                                        }
                                    } else {

                                        String token = response.body().getToken();
                                        String token1 = "Bearer " + token;
                                        Log.d("", "My Token Value:  " + token);

                                        ///Storing Token in Shared Preferences/////////////////
                                        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = shared.edit();
                                        editor.putString("TOKEN", token1);
                                        editor.commit();

                                        String[] split_string = token.split("\\.");
                                        String base64EncodedBody = split_string[1];
                                        //  Log.d("", "Body Part:  " + base64EncodedBody);

                                        // Base64 base64Url = new Base64(true);
                                        Base64.Decoder base64Url = Base64.getDecoder();
                                        String payload = new String(base64Url.decode(base64EncodedBody));


                                        try {
                                            JSONObject jsonObject = new JSONObject(payload);
                                            Log.d("", "Json Payload:  " + jsonObject);

                                            Object getSth = jsonObject.getString("sub");

                                            JSONObject jsonObject2 = new JSONObject((String) getSth);
                                            Object userId = jsonObject2.get("user_id");
                                            Log.d("", "User ID:  " + userId);
                                            Object primary_role = jsonObject2.get("primary_role");
                                            Log.d("", "Primary Role:  " + primary_role);

                                            rolesMethod(userId, primary_role);


                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }


                                    }
                                }

                                @Override
                                public void onFailure(Call<LoginResponse> call, Throwable t) {

                                    Log.d("", "post submission Fail!!!!!.");
                                }
                            });

                }
            }
        });


    }

    private void rolesMethod(Object userId, Object primary_role) {


        int i = (int) userId;
        Log.d("", "Converting to Int  " + i);

////////////////////storing USER_ID int Shared Preference////////////////////////////////////
        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putInt("USERID", i);
        editor.commit();


        String p = primary_role.toString();

        String s2 = "SERVICE_PROVIDER";
        String s3 = "SERVICE_CONSUMER";
        String s4 = "TRAINER";
        String s5 = "RECRUITER";
        String s6 = "TRAINEE";
        String s7 = "EMPLOYEE";


        Log.d("", "Converting to String  " + p);
        ////////////////////////Logging As SERVICE PROVIDER///////////////////////////////////////
        if (p.equals(s2)) {

            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivityMain.this, WelcomePageActivityMain.class);
            startActivity(intent);
        }
        ////////////////////////Logging As SERVICE CONSUMER///////////////////////////////////////
        if (p.equals(s3)) {

            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivityMain.this, WelcomePageActivityMain.class);
            startActivity(intent);
        }
        ////////////////////////Logging As TRAINER///////////////////////////////////////
        if (p.equals(s4)) {

            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivityMain.this, WelcomePageActivityMain.class);
            startActivity(intent);
        }
        ////////////////////////Logging As RECRUITER///////////////////////////////////////
        if (p.equals(s5)) {

            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivityMain.this, WelcomePageActivityMain.class);
            startActivity(intent);
        }
        ////////////////////////Logging As TRAINEE///////////////////////////////////////
        if (p.equals(s6)) {

            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivityMain.this, WelcomePageActivityMain.class);
            startActivity(intent);
        }
////////////////////////Logging As EMPLOYEE///////////////////////////////////////
        if (p.equals(s7)) {

            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivityMain.this, WelcomePageActivityMain.class);
            startActivity(intent);
        } else if (p.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please select roles", Toast.LENGTH_SHORT).show();
            finish();
            Intent intent = new Intent(LoginActivityMain.this, RoleActivityMain.class);
            intent.putExtra("gts_user_id", i);
            startActivity(intent);
        }

    }


}
