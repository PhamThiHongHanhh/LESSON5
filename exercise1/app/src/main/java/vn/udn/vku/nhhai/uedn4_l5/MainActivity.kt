package vn.udn.vku.nhhai.uedn4_l5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val PROFILE_ACTIVITY_CODE = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.loginBtn).setOnClickListener{
            val username = findViewById<EditText>(R.id.usernameET).text.toString()
            val password = findViewById<EditText>(R.id.passwordET).text.toString()
            if(username.indexOf("a")==0 && password == "123"){
                val profileIntent = Intent(this,ProfileActivity::class.java)
                profileIntent.putExtra("usernameValue",username)
                startActivityForResult(profileIntent,PROFILE_ACTIVITY_CODE)
            }
            else{
                findViewById<TextView>(R.id.pleaseLoginTV).text = "Wrong password, try again"
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==PROFILE_ACTIVITY_CODE){
            val imgURI = data?.getStringExtra("imgURIValue")
            if(imgURI != "")
                findViewById<ImageView>(R.id.mainActivityIV)
                    .setImageURI(Uri.parse(imgURI))
        }
    }

    override fun onResume() {
        super.onResume()
        findViewById<EditText>(R.id.usernameET).setText("")
        findViewById<EditText>(R.id.passwordET).setText("")
        findViewById<TextView>(R.id.pleaseLoginTV).text = "Please login"
    }
}