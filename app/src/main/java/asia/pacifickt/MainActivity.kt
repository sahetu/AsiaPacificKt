package asia.pacifickt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var mainEmail : EditText
    lateinit var mainPass : EditText
    lateinit var loginButton : Button
    lateinit var new_user : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainEmail = findViewById(R.id.main_email)
        mainPass = findViewById(R.id.main_pass)
        loginButton = findViewById(R.id.login_btn)
        new_user = findViewById(R.id.new_user)

        loginButton.setOnClickListener {
            if(mainEmail.text.toString().trim().equals("")){
                mainEmail.setError("Email Id Required")
            }
            else if(mainPass.text.toString().trim().equals("")){
                mainPass.setError("Password Required")
            }
            else {
                if(mainEmail.text.toString().trim().equals("admin@gmail.com") && mainPass.text.toString().trim().equals("Admin@123",ignoreCase = true)){
                    System.out.println("Login Successfully")
                    Log.d("RESPONSE", "Login Successfully")
                    Toast.makeText(this@MainActivity, "Login Successfully", Toast.LENGTH_SHORT).show()
                    Snackbar.make(it, "Login Successfully", Snackbar.LENGTH_SHORT).show()
                    var intent : Intent = Intent(this@MainActivity,DashboardActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@MainActivity, "Login Unsuccessfully", Toast.LENGTH_SHORT).show()
                    Snackbar.make(it, "Login Unsuccessfully", Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        /*loginButton.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                //TODO("Not yet implemented")
            }
        })*/

    }
}