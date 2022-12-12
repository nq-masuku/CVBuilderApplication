package com.example.cvbuilderapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

class WorkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)
        var linkedinImg = view?.findViewById<ImageView>(R.id.imageView7)
        linkedinImg?.setOnClickListener {
            linkedin()
        }
    }

    fun linkedin() {
        val intent= Intent(context,WebView::class.java)
        intent.putExtra("url","linkedin")
        startActivity(intent)
    }

}