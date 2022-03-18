package com.gsps.gsp_android.ui.main

import android.graphics.drawable.GradientDrawable
import android.text.Editable
import android.text.TextWatcher
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivitySignInBinding
import com.gsps.gsp_android.ui.base.BaseActivity
import java.util.regex.Pattern

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    var booleanId: Boolean = false
    var booleanPw: Boolean = false
    lateinit var backgroundColorButtonSignIn: GradientDrawable


    fun checkId() {
        val id = binding.signInEtId.text.toString().trim()
        val patternId: String = """^[0-9a-zA-Z!@#$%^+_\-=]*$"""
        val match = Pattern.matches(patternId, id)

        return if (!match) {
            binding.signInEtId.setTextColor(getColor(R.color.system_red))
            binding.signInTilId.error = getString(R.string.error_wrong_id)
            booleanId = false
        } else {
            binding.signInEtId.setTextColor(getColor(R.color.black))
            binding.signInTilId.error = null
            booleanId = id != ""
        }
    }


    override fun initView() {
        backgroundColorButtonSignIn = binding.signInBtnSignIn.background as GradientDrawable

        binding.signInEtId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkId()
                if (booleanId && booleanPw) backgroundColorButtonSignIn.setColor(getColor(R.color.main))
                else backgroundColorButtonSignIn.setColor(getColor(R.color.main_lighten))
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.signInEtPw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                booleanPw = binding.signInEtPw.text.toString().trim() != ""
                if (booleanId && booleanPw) backgroundColorButtonSignIn.setColor(getColor(R.color.main))
                else backgroundColorButtonSignIn.setColor(getColor(R.color.main_lighten))
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}