package com.dovydenko.mymessenger.chat.activities;

import static com.dovydenko.mymessenger.chat.activities.constants.IConstants.ZERO;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dovydenko.mymessenger.chat.activities.R;
import com.dovydenko.mymessenger.chat.activities.managers.Utils;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends BaseActivity implements View.OnClickListener {

    private EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        backButton();
        txtEmail = findViewById(R.id.txtEmail);

        final Button btnSend = findViewById(R.id.btnSend);

        auth = FirebaseAuth.getInstance();

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnSend) {
            final String strEmail = txtEmail.getText().toString().trim();

            if (Utils.isEmpty(strEmail)) {
                screens.showToast(R.string.strAllFieldsRequired);
            } else if (!Utils.isValidEmail(strEmail)) {
                screens.showToast(R.string.strInvalidEmail);
            } else {
                showProgress();
                auth.sendPasswordResetEmail(strEmail).addOnCompleteListener(task -> {
                    hideProgress();

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Перегляньте пошту яку ви вказали",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    //if (task.isSuccessful()) {
                    //    Utils.showOKDialog(mActivity, ZERO, R.string.lblSendYouForgetEmail,
                                screens.showClearTopScreen(LoginActivity.class);
                    //}
                });
            }
        }
    }

}
