package com.simplemobiletools.dialer.helpers

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.simplemobiletools.commons.extensions.*
import com.simplemobiletools.dialer.R
import com.simplemobiletools.dialer.activities.DialpadActivity
import com.simplemobiletools.dialer.activities.SimpleActivity
import com.simplemobiletools.dialer.extensions.config
import com.simplemobiletools.dialer.truecaller.MainViewModel
import com.simplemobiletools.dialer.truecaller.MainViewModelFactory
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
            networkConnectionInterceptor.let { viewModel.getResponse(activity.config.getTrueCallerCountryCode()!!, number, "Bearer " + activity.config.getTrueCallerToken(), it) }

            viewModel.trueCallerResponse.observe(activity) { response ->

                if ((null != response && response.isNotEmpty()) && (response[0].name != NO_INTERNET)) {
                    val truecallerResponse = response[0]
                    val view = activity.layoutInflater.inflate(R.layout.activity_view_number_truecaller_info, null).apply {
                        truecaller_name.text = if (null == truecallerResponse.name) "Unknown" else truecallerResponse.name
                        val imageView: ImageView = findViewById<View>(R.id.truecaller_image) as ImageView
                        Glide
                            .with(activity)
                            .load(truecallerResponse.image)
                            .placeholder(imageView.drawable)
                            .into(imageView)

                        if(null != truecallerResponse.addresses) {
                            val city = truecallerResponse.addresses[0].city
                            if (null != city) {
                                truecaller_city.text = city
                                truecaller_city.beVisible()
                            }
                        }
                        if(null != truecallerResponse.phones) {
                            val carrier = truecallerResponse.phones[0].carrier
                            if (null != carrier) {
                                truecaller_carrier.text = carrier
                                truecaller_carrier.beVisible()
                            }
                        }
                    }

                    activity.getAlertDialogBuilder()
                        .setPositiveButton(com.simplemobiletools.commons.R.string.ok, null)
                        .setNegativeButton(null, null)
                        .apply {
                            activity.setupDialogStuff(view, this) { alertDialog ->
                                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                                    alertDialog.dismiss()
                                    activity.viewModelStore.clear()
                                }
                            }
                        }
                }
            }
        }
    }
}
