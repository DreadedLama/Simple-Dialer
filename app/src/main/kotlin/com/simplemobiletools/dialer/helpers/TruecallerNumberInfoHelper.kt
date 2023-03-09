package com.simplemobiletools.dialer.helpers

import android.annotation.SuppressLint
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.simplemobiletools.commons.extensions.*
import com.simplemobiletools.dialer.R
import com.simplemobiletools.dialer.activities.DialpadActivity
import com.simplemobiletools.dialer.activities.SimpleActivity
import com.simplemobiletools.dialer.extensions.config
import com.simplemobiletools.dialer.models.MainViewModel
import com.simplemobiletools.dialer.models.MainViewModelFactory
import com.simplemobiletools.dialer.services.TrueCallerService
import kotlinx.android.synthetic.main.activity_dialpad.*
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.activity_view_number_truecaller_info.*
import kotlinx.android.synthetic.main.activity_view_number_truecaller_info.view.*
import kotlinx.android.synthetic.main.dialog_add_truecaller_token.*
import kotlinx.android.synthetic.main.dialog_add_truecaller_token.view.*

class TruecallerNumberInfoHelper : SimpleActivity() {

    @SuppressLint("SetTextI18n")
    fun initTruecallerNumberInfo(number: String, activity: DialpadActivity) {
        if (number.isNotEmpty()) {
            val networkConnectionInterceptor = NetworkConnectionInterceptor(activity)
            val viewModel: MainViewModel = ViewModelProvider(activity, MainViewModelFactory(TrueCallerService()))[MainViewModel::class.java]
            networkConnectionInterceptor.let { viewModel.getResponse(number, "Bearer " + activity.config.getTrueCallerToken(), it) }
            viewModel.trueCallerResponse.observe(activity) { response ->
                if (null != response && response.isNotEmpty()) {
                    if (response[0].name != NO_INTERNET) {
                        val view = activity.layoutInflater.inflate(R.layout.activity_view_number_truecaller_info, null).apply {
                            truecaller_number_info.setText("Name: "+response[0].name)
                        }
                        activity.getAlertDialogBuilder()
                            .setPositiveButton(com.simplemobiletools.commons.R.string.ok, null)
                            .setNegativeButton(null, null)
                            .apply {
                                activity.setupDialogStuff(view, this) { alertDialog ->
                                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                                        alertDialog.dismiss()
                                    }
                                }
                            }
                    }
                }
            }
        }
    }
}
