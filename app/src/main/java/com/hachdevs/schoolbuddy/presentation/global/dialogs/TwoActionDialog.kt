package com.hachdevs.schoolbuddy.presentation.global.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.hachdevs.schoolbuddy.R
import com.hachdevs.schoolbuddy.presentation.global.util.withArgs
import kotlinx.android.synthetic.main.dialog_two_action.view.*

class TwoActionDialog(
    var onNegativeClickListener: (() -> Unit)? = null,   // событие клика по кнопке слева
    var onPositiveClickListener: (() -> Unit)? = null    // событие клика по кнопке справа
) : DialogFragment() {

    private var title: String = ""                     // заголовок ошибки
    private var subtitle: String = ""               // текст ошибки
    private var textLeftButton: String = "Action left"      // текст на кнопке слева
    private var textRightButton: String = "Action right"    // текст на кнопке справа
    private var autoClose: Boolean = true                   // автозакрытие на клик за пределы алерта

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            title = getString(TITLE, "")
            subtitle = getString(SUBTITLE, "")
            textLeftButton = getString(TEXT_LEFT_BUTTON, "")
            textRightButton = getString(TEXT_RIGHT_BUTTON, "")
            autoClose = getBoolean(AUTO_CLOSE, true)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!, R.style.CustomAlertDialog)
        val inflater = activity!!.layoutInflater
        val view = inflater.inflate(R.layout.dialog_two_action, null)
        builder.setView(view)
        init(view)
        return builder.create()
    }

    private fun init(view: View) {
        isCancelable = autoClose

        view.alertTitle.isVisible = title.isNotEmpty()
        view.alertSubtitle.isVisible = subtitle.isNotEmpty()

        view.alertTitle.text = title
        view.alertSubtitle.text = subtitle

        view.cancelButton.text = textLeftButton
        view.cancelButton.setOnClickListener {
            onNegativeClickListener?.invoke()
            dialog?.let { if (it.isShowing) it.cancel() }
        }

        view.yesButton.text = textRightButton
        view.yesButton.setOnClickListener {
            onPositiveClickListener?.invoke()
            dialog?.let { if (it.isShowing) it.cancel() }
        }
    }

    companion object {
        fun newInstance(
            title: String = "",
            subtitle: String = "",
            texLeftButton: String,
            textRightButton: String,
            autoClose: Boolean = true,
            onNegativeClickListener: (() -> Unit)? = null,
            onPositiveClickListener: (() -> Unit)?
        ): TwoActionDialog {
            return TwoActionDialog(
                onNegativeClickListener = onNegativeClickListener,
                onPositiveClickListener = onPositiveClickListener
            ).withArgs {
                putString(TITLE, title)
                putString(SUBTITLE, subtitle)
                putString(TEXT_LEFT_BUTTON, texLeftButton)
                putString(TEXT_RIGHT_BUTTON, textRightButton)
                putBoolean(AUTO_CLOSE, autoClose)
            }
        }

        const val TITLE = "title"
        const val SUBTITLE = "subtitle"
        const val TEXT_LEFT_BUTTON = "action_left"
        const val TEXT_RIGHT_BUTTON = "action_right"
        const val AUTO_CLOSE = "auto_close"
    }
}