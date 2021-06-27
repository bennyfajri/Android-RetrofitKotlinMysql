package com.benny.retrofitkotlinmysql

import android.app.ProgressDialog
import android.os.Bundle
import android.renderscript.Sampler
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    val URL = "http://192.168.43.82/crud/"
    private var progress: ProgressDialog? = null

    @BindView(R.id.etNama)
    var editTextID: EditText? = null

    @BindView(R.id.etAlamat)
    var editTextNama: EditText? = null

    @BindView(R.id.etNohp)
    var editTextEmail: EditText? = null

    @BindView(R.id.spinUkt)
    var editTextNomorHp: Spinner? = null

    @OnClick(R.id.btnSumbit)
    fun daftar() {
//membuat progress dialog
        progress = ProgressDialog(this)
        progress!!.setCancelable(false)
        progress!!.setMessage("Loading ...")
        progress!!.show()

//mengambil data dari edittext
        val id = editTextID!!.text.toString()
        val nama = editTextNama!!.text.toString()
        val email = editTextEmail!!.text.toString()
        val nomor = editTextNomorHp!!.text.toString()
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: InsertAPI = retrofit.create(InsertAPI::class.java)
        val call: Call<Sampler.Value> = api.insert(nama, alamat, nohp , ukt)
        call.enqueue(object : Callback<Value> {
            override fun onResponse(call: Call<Sampler.Value>, response: Response<Sampler.Value>) {
                val value: String = response.body().getValue()
                val message: String = response.body().getMessage()
                progress!!.dismiss()
                if (value == "1") {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Sampler.Value>, t: Throwable) {
                progress!!.dismiss()
                Toast.makeText(this@MainActivity, "Jaringan Error!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }
}