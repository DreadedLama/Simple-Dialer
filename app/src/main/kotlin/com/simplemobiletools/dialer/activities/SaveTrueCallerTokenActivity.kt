package com.simplemobiletools.dialer.activities

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AlertDialog
import com.simplemobiletools.commons.extensions.setupDialogStuff
import com.simplemobiletools.commons.extensions.showKeyboard
import com.simplemobiletools.commons.extensions.value
import com.simplemobiletools.dialer.R
import com.simplemobiletools.dialer.extensions.config
import kotlinx.android.synthetic.main.dialog_add_truecaller_token.view.*

@SuppressLint("InflateParams")
class SaveTrueCallerTokenActivity(val activity: Activity, val callback: () -> Unit)  {

    init {

        val originalToken:String? = activity.config.getTrueCallerToken()
        val view = activity.layoutInflater.inflate(R.layout.dialog_add_truecaller_token, null).apply {
            if (originalToken?.isNotEmpty() == true) {
                add_truecaller_token_edittext.setText(originalToken)
            }
        }

        AlertDialog.Builder(activity)
            .setPositiveButton(com.simplemobiletools.commons.R.string.ok, null)
            .setNegativeButton(com.simplemobiletools.commons.R.string.cancel, null)
            .create().apply {
                activity.setupDialogStuff(view, this) {
                    showKeyboard(view.add_truecaller_token_edittext)
                    getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                        val newTrueCallerToken = view.add_truecaller_token_edittext.value
                        activity.config.saveTrueCallerToken(newTrueCallerToken)
                        callback()
                        dismiss()
                    }
                }
            }
    }
}
