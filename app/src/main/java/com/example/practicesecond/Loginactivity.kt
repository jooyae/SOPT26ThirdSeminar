package com.example.practicesecond

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.practicesecond.data.RequestLogin
import com.example.practicesecond.data.ResponseLogin
import com.example.practicesecond.network.RequestToServer
import kotlinx.android.synthetic.main.activity_loginactivity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Loginactivity : AppCompatActivity() {
    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginactivity)




        btn_login.setOnClickListener{
            if(et_id.text.isNullOrBlank()||ed_pwd.text.isNullOrBlank()){
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = ed_pwd.text.toString()
                    )
                ).enqueue(object : Callback<ResponseLogin>{
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        Log.d("로그인 실패", "${t}")
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        if(response.isSuccessful){
                            if(response.body()!!.success){
                                Log.d("로그인 성공", "id : ${et_id.text.toString()}, pw : ${ed_pwd.text.toString()}")
                                Toast.makeText(this@Loginactivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@Loginactivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(this@Loginactivity, "아이디/비밀번호를 확인하세요!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })

            }
        }
        tv_register.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, 1001)
        }
    }

}
