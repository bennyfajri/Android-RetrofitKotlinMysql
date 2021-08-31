package com.benny.retrofitkotlinmysql


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var nama: String
    lateinit var nohp: String
    lateinit var email: String
    var ukt: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSumbit.setOnClickListener {
            if(validator()){
                 getDataFromAPI()
            }
        }

    }

    private fun getDataFromAPI() {
        nama = etNama.text.toString()
        nohp = etNohp.text.toString()
        email = etEmail.text.toString()
        ukt = spinUkt.selectedItem.toString().toInt()

        RetrofitInstance.endpoint.insert(
            ModelMahasiswa(
                nama,
                email,
                nohp,
                ukt
            )
        ).enqueue(object: Callback<CrudResponse>{
            override fun onResponse(call: Call<CrudResponse>, response: Response<CrudResponse>) {
                Log.d("response::", response.body()!!.message)
                if(response.body()!!.value){
                    Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<CrudResponse>, t: Throwable) {
                Log.d("error::", t.message!!)
            }
        })
    }

    private fun validator(): Boolean {
        var value = true

        nama = etNama.text.toString()
        nohp = etNohp.text.toString()
        email = etEmail.text.toString()
        ukt = spinUkt.selectedItem.toString().toInt()

        if(nama.isEmpty()){
            etNama.error = "Nama Kosong"
            etNama.requestFocus()
            value = false
        }
        if(nohp.isEmpty()){
            etNohp.error = "NoHP Kosong"
            etNohp.requestFocus()
            value = false
        }
        if(email.isEmpty()){
            etEmail.error = "Email Kosong"
            etEmail.requestFocus()
            value = false
        }
        return value
    }
}