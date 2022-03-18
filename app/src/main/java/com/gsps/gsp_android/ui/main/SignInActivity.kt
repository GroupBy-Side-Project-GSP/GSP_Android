package com.gsps.gsp_android.ui.main

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivitySignInBinding
import com.gsps.gsp_android.ui.base.BaseActivity
import java.util.regex.Pattern

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    private val userIdTil: TextInputLayout by lazy { findViewById(R.id.sign_in_til_id) }
    private val userId: TextInputEditText by lazy { findViewById(R.id.sign_in_et_id) }
    private val pwTil: TextInputLayout by lazy { findViewById(R.id.sign_in_til_pw) }
    private val pw: TextInputEditText by lazy { findViewById(R.id.sign_in_et_pw) }
    private val buttonSignIn: AppCompatButton by lazy { findViewById(R.id.sign_in_btn_sign_in) }
    var booleanId: Boolean = false
    var booleanPw: Boolean = false
    lateinit var backgroundColorButtonSignIn: GradientDrawable

    override fun ActivitySignInBinding.onCreate(){
        
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        backgroundColorButtonSignIn = buttonSignIn.background as GradientDrawable

        userId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkId()
                if (booleanId && booleanPw) backgroundColorButtonSignIn.setColor(getColor(R.color.main))
                else backgroundColorButtonSignIn.setColor(getColor(R.color.main_lighten))
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        pw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                booleanPw = pw.text.toString().trim() != ""
                if (booleanId && booleanPw) backgroundColorButtonSignIn.setColor(getColor(R.color.main))
                else backgroundColorButtonSignIn.setColor(getColor(R.color.main_lighten))
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }


    fun checkId() {
        val id = userId.text.toString().trim()
        val patternId: String = """^[0-9a-zA-Z!@#$%^+_\-=]*$"""
        val match = Pattern.matches(patternId, id)

        return if (!match) {
            userId.setTextColor(getColor(R.color.system_red))
            userIdTil.error = getString(R.string.error_wrong_id)
            booleanId = false
        } else {
            userId.setTextColor(getColor(R.color.black))
            userIdTil.error = null
            booleanId = id != ""
        }
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

}