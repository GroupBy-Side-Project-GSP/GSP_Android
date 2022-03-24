package com.gsps.gsp_android.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivitySignUpBinding
import com.gsps.gsp_android.ui.base.BaseActivity
import java.util.regex.Pattern

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(
    R.layout.activity_sign_up
) {


    override fun initView() {




        binding.TietSignUpEmail.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkemail()
                certificationbtn()
                nextbtn()
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.TietSignUpId.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkid()
                nextbtn()

            }
            override fun afterTextChanged(p0: Editable?) {}

        })

        binding.TietSignUpPw.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkpw()
                nextbtn()

            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.TietSignUpRePw.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkrepw()
                nextbtn()
            }
            override fun afterTextChanged(p0: Editable?) {checkrepw()}

        })



        binding.BtnCertification.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.BtnSignUpNext.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.BtnSignUpLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }



    fun checkemail():Boolean{
        val email = binding.TietSignUpEmail.text.toString().trim()
        val patternemail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val match = Pattern.matches(patternemail, email)

        if (match) {
            binding.TietSignUpEmail.setTextColor(getColor(R.color.black))
            binding.TilSignUpEmail.error= null
            return true
        } else {
            binding.TietSignUpEmail.setTextColor(getColor(R.color.system_red))
            binding.TilSignUpEmail.error="이메일 형식이 잘못되었습니다"
            return false
        }
    }

    fun checkid():Boolean{
        val id = binding.TietSignUpId.text.toString().trim()
        val patternid = """^[0-9a-zA-Z!@#$%^+_\-=]*$"""
        val match = Pattern.matches(patternid, id)

        if (match) {
            binding.TietSignUpId.setTextColor(getColor(R.color.black))
            binding.TilSignUpId.error= null
            return true
        } else {
            binding.TietSignUpId.setTextColor(getColor(R.color.system_red))
            binding.TilSignUpId.error="아이디 형식이 잘못되었습니다"
            return false
        }
    }

    fun checkpw():Boolean{
//        비밀번호 (숫자, 문자, 특수문자 포함 8~15자리 이내)
        val pw = binding.TietSignUpPw.text.toString().trim()
        val patternpw = "^.*(?=^.{8,15}$)(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$"
        val match = Pattern.matches(patternpw, pw)

        if (match) {
            binding.TietSignUpPw.setTextColor(getColor(R.color.black))
            binding.TilSignUpPw.error= null
            return true
        } else {
            binding.TietSignUpPw.setTextColor(getColor(R.color.system_red))
            binding.TilSignUpPw.error="비밀번호 형식이 잘못되었습니다"
            return false
        }
    }
    fun checkrepw():Boolean{
        if(binding.TietSignUpRePw.text.toString().equals(binding.TietSignUpPw.text.toString())) {
            binding.TietSignUpRePw.setTextColor(getColor(R.color.black))
            binding.TilSignUpRePw.error= null
            return true

        }else{
            binding.TietSignUpRePw.setTextColor(getColor(R.color.system_red))
            binding.TilSignUpRePw.error="비밀번호가 다릅니다."
            return false
        }
    }


    fun certificationbtn(){
        if(checkemail()){
            binding.BtnCertification.isEnabled=true
        }else{
            binding.BtnCertification.isEnabled=false
        }
    }


    fun nextbtn(){
        if(checkemail()&&checkid()&&checkpw()&&checkrepw()){
            binding.BtnSignUpNext.isEnabled=true
        }else{
            binding.BtnSignUpNext.isEnabled=false
        }
    }
}