package com.example.cvbuilderapplication

import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class PdfViewer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)
        CopyReadAssets();

    }

   fun CopyReadAssets()
    {
        var assetManager: AssetManager = getAssets();

        var inn:InputStream? = null
        var out:OutputStream? = null
        val file:File? = File(getFilesDir(), "100241BR.pdf");

        try
        {
            inn = assetManager.open("100241BR.pdf");
            out = openFileOutput(file?.name, Context.MODE_WORLD_READABLE);
            copyFile(inn, out);
            inn.close();
            inn = null;
            out.flush();
            out.close();
            out = null;
        } catch (e:Exception)
        {
           Toast.makeText(this, "PDF couldn't open",Toast.LENGTH_LONG).show()
        }

        var intent = Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
            Uri.parse("file://" + getFilesDir() + "/100241BR.pdf"),
            "application/pdf");

        startActivity(intent);
    }

    @Throws(IOException::class)
    fun copyFile(inn: InputStream, out: OutputStream) {
        val buffer = ByteArray(1024)
        var read: Int
        while (inn.read(buffer).also { read = it } != -1) {
            out.write(buffer, 0, read)
        }
    }

}
