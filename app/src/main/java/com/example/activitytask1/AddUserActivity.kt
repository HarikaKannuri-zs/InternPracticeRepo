package com.example.activitytask1
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
class AddUserActivity : AppCompatActivity() {
    private val userList = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_user)
        var userIdEditText: EditText = findViewById(R.id.userIdEditText)
        var userNameEditText: EditText = findViewById(R.id.userNameEditText)
        var userPhoneEditText: EditText = findViewById(R.id.userPhoneEditText)
        var idEnterEdittext: EditText = findViewById(R.id.idEnterEditText)
        var addButton: Button = findViewById(R.id.addButton)
        var viewButton: Button = findViewById(R.id.view)
        fun addUser() {
            val userId = userIdEditText.text.toString().trim()
            val userName = userNameEditText.text.toString().trim()
            val userPhone = userPhoneEditText.text.toString().trim()
            if (userId.isNotBlank() && userName.isNotBlank() && userPhone.isNotBlank()) {
                val user = User(userId, userName, userPhone)
                userList.add(user)
                Toast.makeText(this, "User added Successfully", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Enter all the details", Toast.LENGTH_SHORT).show()
            }
        }
        fun viewUser() {
            val idToView = idEnterEdittext.text.toString()
            if (idToView.isEmpty()) {
                Toast.makeText(this@AddUserActivity, "Enter Id Details", Toast.LENGTH_SHORT).show()
                return
            }
            val foundUser = userList.find { it.id == idToView }
            if (foundUser == null) {
                Toast.makeText(this@AddUserActivity, "Missing User Details", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, ViewUserActivity::class.java).apply {
                    putExtra("USERNAME", foundUser.userName)
                    putExtra("USERPHONE", foundUser.userPhone)
                    putExtra("USERID", foundUser.id)
                }
                startActivity(intent)
            }
        }
        addButton.setOnClickListener{
            addUser()
        }
        viewButton.setOnClickListener{
            viewUser()
        }
    }
}
data class User(val id: String, val userName: String, val userPhone: String)








