package com.example.cvbuilderapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_contact, container, false)
        var layout1 = view?.findViewById<LinearLayout>(R.id.layout1)
        var layout2 = view?.findViewById<LinearLayout>(R.id.layout2)
        var layout3 = view?.findViewById<LinearLayout>(R.id.layout3)
        var layout4 = view?.findViewById<LinearLayout>(R.id.layout4)
        var layout5 = view?.findViewById<LinearLayout>(R.id.layout5)
        var layout6 = view?.findViewById<LinearLayout>(R.id.layout6)

        layout1?.setOnClickListener {
            call()
        }
        layout2?.setOnClickListener {
            email()
        }
        layout3?.setOnClickListener {
            linkedin()
        }
        layout4?.setOnClickListener {
            github()
        }
        layout5?.setOnClickListener {
            getPdf()
        }
        layout6?.setOnClickListener {
            location()
        }
        return view
    }

    fun call() {
        val uri = Uri.parse(getString(R.string.my_phone));
        val it = Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);
    }

    fun email() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse(getString(R.string.intent_filter))
        intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.my_email))
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body))
        startActivity(intent)
    }

    fun linkedin() {
        val uri = Uri.parse(getString(R.string.my_linkedin))
        val it = Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }

    fun github() {
        val uri = Uri.parse(getString(R.string.my_github));
        val it = Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }
    fun getPdf() {
        Toast.makeText(activity, "PDF couldn't open",Toast.LENGTH_LONG).show()
        //var intent = Intent(activity, PdfViewer::class.java)
        //startActivity(intent)
    }

    fun location(){
        var loc = getString(R.string.mylocation)
        val addressUri = Uri.parse("geo:0,0?q=$loc");

        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        startActivity(intent)
    }

}