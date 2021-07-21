package myproject.athome.chakuri.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import myproject.athome.chakuri.MainNavigationBarActivity;
import myproject.athome.chakuri.R;

public class AfterRegistration extends MainNavigationBarActivity {
      @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            LayoutInflater inflater = (LayoutInflater) this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View contentView = inflater.inflate(R.layout.activity_after_registration, null, false);
            dl.addView(contentView, 0);

            Toolbar tb = findViewById(R.id.toolbar_main);
            setSupportActionBar(tb);


            TextView textView = findViewById(R.id.textView2);
            String text = "Please CLICK HERE to Login.";
            SpannableString spannableString = new SpannableString(text);

            ClickableSpan clickableSpan1 = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent i = new Intent(AfterRegistration.this, LoginActivityMain.class);
                    startActivity(i);
                }
            };

            spannableString.setSpan(clickableSpan1, 7,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());

        }
    }


