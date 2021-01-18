package com.fcheng.sample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_input_textlayout.*

class InputTextLayoutActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_textlayout)
        initTextInputLayout()
    }

    private fun initTextInputLayout(){
        til.editText?.addTextChangedListener(MyTextWatcher("长度应低于10位数!",til))
        //开启计数
        til.isCounterEnabled = true
        //最大输入限制数
        til.counterMaxLength = 10
    }

    class MyTextWatcher( var errorStr :String?,var textInputLayout : TextInputLayout) : TextWatcher {

        override fun afterTextChanged(s: Editable?) {
            // 文字改变后回调
            if(s.toString().length<=10){
                textInputLayout.isErrorEnabled = false
            }else{
                textInputLayout.isErrorEnabled = true
                textInputLayout.error = errorStr
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }
}