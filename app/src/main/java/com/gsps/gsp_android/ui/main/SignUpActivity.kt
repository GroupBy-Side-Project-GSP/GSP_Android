package com.gsps.gsp_android.ui.main

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivitySignUpBinding
import com.gsps.gsp_android.ui.base.BaseActivity
import java.util.regex.Pattern

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun initView() {
        binding.tietSignUpEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkemail()
                certificationbtn()
                nextbtn()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.tietSignUpId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkid()
                nextbtn()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.tietSignUpPw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkpw()
                nextbtn()

            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.tietSignUpRePw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkrepw()
                nextbtn()
            }

            override fun afterTextChanged(p0: Editable?) {
                checkrepw()
            }
        })

        binding.btnCertification.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignUpNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignUpLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun checkemail(): Boolean {
        val email = binding.tietSignUpEmail.text.toString().trim()
        val patternemail =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val match = Pattern.matches(patternemail, email)

        return if (match) {
            binding.tietSignUpEmail.setTextColor(getColor(R.color.black))
            binding.tilSignUpEmail.error = null
            true
        } else {
            binding.tietSignUpEmail.setTextColor(getColor(R.color.system_red))
            binding.tilSignUpEmail.error = "????????? ????????? ?????????????????????"
            false
        }
    }

    fun checkid(): Boolean {

        val id = binding.tietSignUpId.text.toString().trim()
        val patternid = "^[a-zA-Z]{1}[a-zA-Z0-9]{4,11}$"
        val match = Pattern.matches(patternid, id)

        return if (match) {
            binding.tietSignUpId.setTextColor(getColor(R.color.black))
            binding.tilSignUpId.error = null
            true
        } else {
            binding.tietSignUpId.setTextColor(getColor(R.color.system_red))
            binding.tilSignUpId.error = "????????? ????????? ?????????????????????"
            false
        }
    }

    fun checkpw(): Boolean {
//        ???????????? (??????, ??????, ???????????? ?????? 8~15?????? ??????)
        val pw = binding.tietSignUpPw.text.toString().trim()
        val patternpw = "^.*(?=^.{8,15}$)(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$"
        val match = Pattern.matches(patternpw, pw)

        return if (match) {
            binding.tietSignUpPw.setTextColor(getColor(R.color.black))
            binding.tilSignUpPw.error = null
            true
        } else {
            binding.tietSignUpPw.setTextColor(getColor(R.color.system_red))
            binding.tilSignUpPw.error = "???????????? ????????? ?????????????????????"
            false
        }
    }

    fun checkrepw(): Boolean {
        return if (binding.tietSignUpRePw.text.toString()
                .equals(binding.tietSignUpPw.text.toString())
        ) {
            binding.tietSignUpRePw.setTextColor(getColor(R.color.black))
            binding.tilSignUpRePw.error = null
            true

        } else {
            binding.tietSignUpRePw.setTextColor(getColor(R.color.system_red))
            binding.tilSignUpRePw.error = "??????????????? ????????????."
            false
        }
    }

    fun certificationbtn() {
        binding.btnCertification.isEnabled = checkemail()
    }

    fun nextbtn() {
        binding.btnSignUpNext.isEnabled = checkemail() && checkid() && checkpw() && checkrepw()
    }
}