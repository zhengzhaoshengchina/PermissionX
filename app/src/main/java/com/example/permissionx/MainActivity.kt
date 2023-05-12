package com.example.permissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.permissionx.zzsdev.PermissionX
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCallBtn.setOnClickListener {

            PermissionX.request(this,
            Manifest.permission.CALL_PHONE){
                allGranted,deniedList ->
                if(allGranted){
                    Toast.makeText(this,"All permissions are granted",
                        Toast.LENGTH_SHORT).show()
                    Log.d("qaq","拨打电话前")
                    call()
                    Log.d("qaq","拨打电话后")
                }else{
                    Toast.makeText(this,"You denied $deniedList",
                        Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun call(){
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }catch(e:SecurityException){
            e.printStackTrace()
        }
    }

}