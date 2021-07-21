package myproject.athome.chakuri.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import myproject.athome.chakuri.MainNavigationBarActivity;
import myproject.athome.chakuri.R;
import myproject.athome.chakuri.model.remote.APIUtils;
import myproject.athome.chakuri.model.userRoles.RoleRequest;
import myproject.athome.chakuri.model.userRoles.RoleResponse;
import myproject.athome.chakuri.model.userRoles.UserRoleDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RoleActivityMain extends MainNavigationBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_registration);

        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_role, null, false);
        dl.addView(contentView, 0);

        Toolbar tb = findViewById(R.id.toolbar_main);
        setSupportActionBar(tb);

        Button btn_save = findViewById(R.id.role_save_btn);

        mAPIService = APIUtils.getAPIService1();

        CheckBox cb1 = findViewById(R.id.role_1);
        CheckBox cb2 = findViewById(R.id.role_2);
        CheckBox cb3 = findViewById(R.id.role_3);
        CheckBox cb4 = findViewById(R.id.role_4);
        CheckBox cb5 = findViewById(R.id.role_5);


        RadioButton rb1 = findViewById(R.id.default_1);
        RadioButton rb2 = findViewById(R.id.default_2);
        RadioButton rb3 = findViewById(R.id.default_3);
        RadioButton rb4 = findViewById(R.id.default_4);
        RadioButton rb5 = findViewById(R.id.default_5);



        rb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cb1.setChecked(true);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cb2.setChecked(true);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cb3.setChecked(true);
            }
        });
        rb4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cb4.setChecked(true);
            }
        });
        rb5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cb5.setChecked(true);
            }
        });


        cb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!cb1.isChecked()){
                    rb1.setChecked(false);
                }
            }
        });

        cb2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!cb2.isChecked()){
                    rb2.setChecked(false);
                }
            }
        });
        cb3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!cb3.isChecked()){
                    rb3.setChecked(false);
                }
            }
        });
        cb4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!cb4.isChecked()){
                    rb4.setChecked(false);
                }
            }
        });
        cb5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!cb5.isChecked()){
                    rb5.setChecked(false);
                }
            }
        });





        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Integer user_Id = getIntent().getIntExtra("gts_user_id", 0);


                ArrayList<Integer> roleCheck = new ArrayList<>();

                if (cb1.isChecked()) {
                    roleCheck.add(2);
                }
                if (cb2.isChecked()) {
                    roleCheck.add(3);
                }
                if (cb3.isChecked()) {
                    roleCheck.add(5);
                }
                if (cb4.isChecked()) {
                    roleCheck.add(4);
                }
                if (cb5.isChecked()) {
                    roleCheck.add(6);
                }

                Log.d("", "CheckBox values" + roleCheck);

                Integer default_role = null;

                if (rb1.isChecked()) {
                    default_role = 2;

                }
                if (rb2.isChecked()) {
                    default_role = 3;
                }
                if (rb3.isChecked()) {
                    default_role = 5;
                }
                if (rb4.isChecked()) {
                    default_role = 4;
                }
                if (rb5.isChecked()) {
                    default_role = 6;
                }

                Log.d("", "Default Role " + default_role);


                JSONArray payLoad = new JSONArray();
                for (int i = 0; i < roleCheck.size(); i++) {
                    Integer role_id = roleCheck.get(i);
                    Integer isPrimary = 0;

                    if (role_id == default_role) {
                        isPrimary = 1;
                    }

                    JSONObject obj = new JSONObject();
                    try {
                        obj.put("gts_role_id", role_id);
                        obj.put("gts_user_role_is_primary", isPrimary);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    payLoad.put(obj);

                }

                Gson gson = new Gson();
                Type userListType = new TypeToken<List<UserRoleDTO>>() {
                }.getType();
                List<UserRoleDTO> userArray = gson.fromJson(String.valueOf(payLoad), userListType);

               if (userArray.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please select at least one role", Toast.LENGTH_SHORT).show();
                }

               if(default_role==null){
                    Toast.makeText(getApplicationContext(), "Please select one default role", Toast.LENGTH_SHORT).show();
                }
               else {
                    Log.d("", "AFTER FOR LOOP");
                    Log.d("", "PayLoad Value from JSON Array After for Loop" + payLoad);

                    mAPIService.createRole(new RoleRequest(user_Id,userArray))
                            .enqueue(new Callback<RoleResponse>() {
                                @Override
                                public void onResponse(Call<RoleResponse> call, Response<RoleResponse> response) {


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

                                        Log.d("", "post submitted to API." + response.body());
                                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                        finish();
                                        Intent i = new Intent(RoleActivityMain.this, AfterRegistration.class);
                                        startActivity(i);
                                    }

                                }

                                @Override
                                public void onFailure(Call<RoleResponse> call, Throwable t) {
                                    Log.d("", "post submission Fail!!!!!.");
                                }
                            });
                }

            }
        });
    }
}
