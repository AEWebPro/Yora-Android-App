package com.example.ae.yora.dialogs;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ae.yora.R;
import com.example.ae.yora.services.Account;
import com.squareup.otto.Subscribe;

public class ChangePasswordDialog extends BaseDialogFragment implements View.OnClickListener {
    private EditText currentPassword;
    private EditText newPassword;
    private EditText confirmNewPassword;

    private static boolean isProgressBarVisible;
    private Dialog progressDialog;


    @Override
    public Dialog onCreateDialog(Bundle savedState){
        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_change_password, null, false);

        currentPassword = (EditText) dialogView.findViewById(R.id.dialog_change_password_currentPassword);
        newPassword = (EditText) dialogView.findViewById(R.id.dialog_change_password_newPassword);
        confirmNewPassword = (EditText) dialogView.findViewById(R.id.dialog_change_password_confirmNewPassword);

        if(!application.getAuth().getUser().isHasPassword()){
            currentPassword.setVisibility(View.GONE);
        }

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(dialogView)
                .setPositiveButton("Update", null)
                .setNegativeButton("Cancel", null)
                .setTitle("Change Password")
                .show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(this);
        if(isProgressBarVisible){
            setProgressBarVisible(true);
        }
        return dialog;
    }

    private void setProgressBarVisible(boolean visible) {
        if (visible) {
            progressDialog = new ProgressDialog.Builder(getActivity())
                    .setTitle("Changing Password")
                    .setCancelable(false)
                    .show();
        } else if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }

        isProgressBarVisible = visible;
    }

    @Override
    public void onClick(View view) {
        setProgressBarVisible(true);

        bus.post(new Account.ChangePasswordRequest(
                currentPassword.getText().toString(),
                newPassword.getText().toString(),
                confirmNewPassword.getText().toString()
        ));
    }

    @Subscribe
    public void passwordChange(Account.ChangePasswordResponse response){
        progressDialog.dismiss();
        progressDialog = null;

        if(response.didSucced()){
            setProgressBarVisible(false);
            Toast.makeText(getActivity(), "Password Updated", Toast.LENGTH_LONG).show();
            dismiss();
            application.getAuth().getUser().setHasPassword(true);
            return;
        }

        currentPassword.setError(response.getPropretyError("currentPassword"));
        newPassword.setError(response.getPropretyError("newPassword"));
        confirmNewPassword.setError(response.getPropretyError("confirmNewPassword"));

        response.showErrorToast(getActivity());
    }
}




