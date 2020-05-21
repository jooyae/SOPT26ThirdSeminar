package com.example.practicesecond

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicesecond.data.RequestRegister
import com.example.practicesecond.data.ResponseLogin
import com.example.practicesecond.data.ResponseRegister
import com.example.practicesecond.network.RequestToServer
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_finish_btn.setOnClickListener{
            if(register_id.text.isNullOrBlank()||register_pw.text.isNullOrBlank() ||editText3.text.isNullOrBlank() || register_email.text.isNullOrBlank()){
                Toast.makeText(this, "해당사항을 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                requestToServer.service.requestRegister(
                    RequestRegister(
                        id = register_id.text.toString(),
                        password = register_pw.text.toString(),
                        name = register_name.text.toString(),
                        email =register_email.text.toString(),
                        phone =register_phone.text.toString()

                    )
                ).enqueue(object : Callback<ResponseRegister> {
                    override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {

                    }

                    override fun onResponse(
                        call: Call<ResponseRegister>,
                        response: Response<ResponseRegister>
                    ) {
                        if(response.isSuccessful){
                            if(response.body()!!.success){
                                Toast.makeText(this@RegisterActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@RegisterActivity, Loginactivity::class.java)
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(this@RegisterActivity, "아이디/비밀번호를 확인하세요!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })

            }
        }

    }
}
