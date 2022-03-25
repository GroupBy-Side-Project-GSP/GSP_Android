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




        binding.tietSignUpEmail.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkemail()
                certificationbtn()
                nextbtn()
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.tietSignUpId.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkid()
                nextbtn()

            }
            override fun afterTextChanged(p0: Editable?) {}

        })

        binding.tietSignUpPw.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkpw()
                nextbtn()

            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.tietSignUpRePw.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkrepw()
                nextbtn()
            }
            override fun afterTextChanged(p0: Editable?) {checkrepw()}

        })



        binding.btnCertification.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignUpNext.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignUpLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }



    fun checkemail():Boolean{
        val email = binding.tietSignUpEmail.text.toString().trim()
        val patternemail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val match = Pattern.matches(patternemail, email)

        if (match) {
            binding.tietSignUpEmail.setTextColor(getColor(R.color.black))
            binding.tilSignUpEmail.error= null
            return true
        } else {
            binding.tietSignUpEmail.setTextColor(getColor(R.color.system_red))
            binding.tilSignUpEmail.error="이메일 형식이 잘못되었습니다"
            return false
        }
    }

    fun checkid():Boolean{
        val id = binding.tietSignUpId.text.toString().trim()
        val patternid = """^[0-9a-zA-Z!@#$%^+_\-=]*$"""
        val match = Pattern.matches(patternid, id)

        if (match) {
            binding.tietSignUpId.setTextColor(getColor(R.color.black))
            binding.tilSignUpId.error= null
            return true
        } else {
            binding.tietSignUpId.setTextColor(getColor(R.color.system_red))
            binding.tilSignUpId.error="아이디 형식이 잘못되었습니다"
            return false
        }
    }

    fun checkpw():Boolean{
//        비밀번호 (숫자, 문자, 특수문자 포함 8~15자리 이내)
        val pw = binding.tietSignUpPw.text.toString().trim()
        val patternpw = "^.*(?=^.{8,15}$)(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$"
        val match = Pattern.matches(patternpw, pw)

        if (match) {
            binding.tietSignUpPw.setTextColor(getColor(R.color.black))
            binding.tilSignUpPw.error= null
            return true
        } else {
            binding.tietSignUpPw.setTextColor(getColor(R.color.system_red))
            binding.tilSignUpPw.error="비밀번호 형식이 잘못되었습니다"
            return false
        }
    }
    fun checkrepw():Boolean{
        if(binding.tietSignUpRePw.text.toString().equals(binding.tietSignUpPw.text.toString())) {
            binding.tietSignUpRePw.setTextColor(getColor(R.color.black))
            binding.tilSignUpRePw.error= null
            return true

        }else{
            binding.tietSignUpRePw.setTextColor(getColor(R.color.system_red))
            binding.tilSignUpRePw.error="비밀번호가 다릅니다."
            return false
        }
    }


    fun certificationbtn(){
        if(checkemail()){
            binding.btnCertification.isEnabled=true
        }else{
            binding.btnCertification.isEnabled=false
        }
    }


    fun nextbtn(){
        if(checkemail()&&checkid()&&checkpw()&&checkrepw()){
            binding.btnSignUpNext.isEnabled=true
        }else{
            binding.btnSignUpNext.isEnabled=false
        }
    }
}