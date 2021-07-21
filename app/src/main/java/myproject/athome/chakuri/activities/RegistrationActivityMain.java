package myproject.athome.chakuri.activities;

import android.content.Context;
import android.content.Intent;
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

import androidx.appcompat.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Pattern;

import myproject.athome.chakuri.MainNavigationBarActivity;
import myproject.athome.chakuri.R;
import myproject.athome.chakuri.model.api.APIService;
import myproject.athome.chakuri.model.registration.RegistrationRequest;
import myproject.athome.chakuri.model.registration.RegistrationResponse;
import myproject.athome.chakuri.model.remote.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivityMain extends MainNavigationBarActivity {

    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_registration, null, false);
        dl.addView(contentView, 0);

        Toolbar tb = findViewById(R.id.toolbar_main);
        setSupportActionBar(tb);

        final EditText reg_email = findViewById(R.id.edit_email);
        final EditText reg_password = findViewById(R.id.edit_pass);
        final EditText confirm_password = findViewById(R.id.edit_confirm_pass);
        Button btn_submit = findViewById(R.id.btn_register);
        final TextView haveAcc = findViewById(R.id.have_acc);

        final TextView pass_warning = findViewById(R.id.pass_warning);

        pass_warning.setVisibility(View.GONE);


        haveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrationActivityMain.this, LoginActivityMain.class);
                startActivity(intent);
            }
        });

        mAPIService = APIUtils.getAPIService1();

        btn_submit.setOnClickListener(new View.OnClickListener() {

                                          @Override
                                          public void onClick(View v) {
                                              String email = reg_email.getText().toString().trim();
                                              String password = reg_password.getText().toString().trim();
                                              String confirmPass = confirm_password.getText().toString().trim();

                                              pass_warning.setVisibility(View.GONE);

                                              String passPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
                                              Pattern pattern = Pattern.compile(passPattern);

                                              if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(confirmPass)) {
                                                  reg_email.setError("Enter Email", null);
                                                  reg_email.requestFocus();
                                                  reg_password.setError("Enter Password", null);
                                                  confirm_password.setError("Confirm Password", null);
                                                  Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
                                              } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                                                  reg_email.setError("Enter Valid Email", null);
                                                  Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_SHORT).show();
                                              } else if (TextUtils.isEmpty(password)) {
                                                  reg_password.requestFocus();
                                                  reg_password.setError("Enter Password", null);
                                                  Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();
                                              } else if (!pattern.matcher(password).matches()) {
                                                  reg_password.requestFocus();
                                                  reg_password.setError("Enter valid Password", null);
                                                  pass_warning.setVisibility(View.VISIBLE);
                                                  Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();
                                              }
//
                                              else if (TextUtils.isEmpty(confirmPass)) {
                                                  confirm_password.requestFocus();
                                                  confirm_password.setError("Confirm Password", null);
                                                  Toast.makeText(getApplicationContext(), "Please confirm password", Toast.LENGTH_SHORT).show();
                                              } else if (!password.equals(confirmPass)) {
                                                  confirm_password.setError("Passwords not matching", null);
                                                  Toast.makeText(getApplicationContext(), "Passwords not matching", Toast.LENGTH_SHORT).show();
                                              } else {

                                                  Log.d("", "Email" + email);
                                                  Log.d("", "Password" + password);
                                                  mAPIService.createUser(new RegistrationRequest(email, password))
                                                          .enqueue(new Callback<RegistrationResponse>() {
                                                              @Override
                                                              public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                                                                  Log.d("", "post submitted to API." + response.body());
                                                                  if ((response.body() == null)) {
                                                                      try {
                                                                          JSONObject jsonObject = new JSONObject(response.errorBody().string());

                                                                          Log.d("", "Error Response Body" + jsonObject);
                                                                          Log.d("", "Error Response Body" + jsonObject.optString("message"));

                                                                          String message = jsonObject.optString("message");
                                                                          Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                                                                      } catch (IOException | JSONException e) {
                                                                          e.printStackTrace();
                                                                      }

                                                                  } else if (response.body().getStatusCode() == 400) {

                                                                      Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                                                                  } else if (response.body().getStatusCode() == 200) {
                                                                      Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                                                      reg_email.setError("Email Exist Already !", null);
                                                                      reg_email.requestFocus();

                                                                  } else {
                                                                      Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                                                      finish();
                                                                      Intent i = new Intent(RegistrationActivityMain.this, RoleActivityMain.class);
                                                                      i.putExtra("gts_user_id", response.body().getGtsUserId());
                                                                      startActivity(i);
                                                                  }

                                                              }

                                                              @Override
                                                              public void onFailure(Call<RegistrationResponse> call, Throwable t) {

                                                                  Log.d("", "post submission Fail!!!!!.");
                                                              }
                                                          });

                                              }
                                          }
                                      }

        );

    }
}
