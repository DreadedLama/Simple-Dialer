package com.simplemobiletools.dialer.activities

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AlertDialog
import com.simplemobiletools.commons.extensions.*
import com.simplemobiletools.dialer.R
import com.simplemobiletools.dialer.extensions.config
import kotlinx.android.synthetic.main.dialog_add_truecaller_token.view.*

@SuppressLint("InflateParams")
class SaveTrueCallerTokenActivity(val activity: Activity, val callback: () -> Unit)  {

    init {

        val truecallerToken:String? = activity.config.getTrueCallerToken()
        val truecallerCountryCode:String? = activity.config.getTrueCallerCountryCode()
        val view = activity.layoutInflater.inflate(R.layout.dialog_add_truecaller_token, null).apply {
            if (truecallerToken?.isNotEmpty() == true) {
                add_truecaller_token_edittext.setText(truecallerToken)
            }
            if (truecallerCountryCode?.isNotEmpty() == true) {
                add_truecaller_countryCode_edittext.setText(truecallerCountryCode)
            }
        }

        activity.getAlertDialogBuilder()
            .setPositiveButton(com.simplemobiletools.commons.R.string.ok, null)
            .setNegativeButton(com.simplemobiletools.commons.R.string.cancel, null)
            .apply {
                activity.setupDialogStuff(view, this) { alertDialog ->
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                        val newTrueCallerToken = view.add_truecaller_token_edittext.value
                        val newTruecallerCountryCode = view.add_truecaller_countryCode_edittext.value
                        activity.config.saveTrueCallerToken(newTrueCallerToken)
                        activity.config.saveTrueCallerCountryCode(newTruecallerCountryCode)
                        callback()
                        alertDialog.dismiss()
                    }
                }
            }
    }
}
