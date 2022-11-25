package com.example.misrecetasapplication.dialogs

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.misrecetasapplication.R
import com.example.misrecetasapplication.utils.Utils
import com.example.misrecetasapplication.utils.loadReceiptImg
import kotlinx.android.synthetic.main.dialog_view_pics.view.*

class ViewPicDialog : DialogFragment() {
    companion object {
        fun newInstance(pic_url: String, title: String): ViewPicDialog {
            val args = Bundle()
            val fragment = ViewPicDialog()
            args.putString("pic", pic_url)
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }
    }

    var pic: String = ""
    var title: String = ""

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            pic = arguments?.getString("pic").toString()

            title = arguments?.getString("title").toString()
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.dialog_view_pics, container, false)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable = true
        view.driver_title.text = title
        view.payment_pic.loadReceiptImg(pic)
        var scaleFactor = 1f
        val scaleGestureDetector = ScaleGestureDetector(
            requireContext(),
            object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    scaleFactor *= detector.scaleFactor
                    scaleFactor = scaleFactor.coerceIn(0.1f, 10.0f)

                    view.payment_pic.scaleX = scaleFactor
                    view.payment_pic.scaleY = scaleFactor
                    return super.onScale(detector)
                }
            }
        )
        view.payment_pic.setOnTouchListener { _, event ->
            scaleGestureDetector.onTouchEvent(event)
        }
        return view
    }


}