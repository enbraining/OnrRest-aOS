package com.chobo.onrest

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.chobo.onrest.databinding.PostWriteBinding


class PostWrite : AppCompatActivity() {
    private lateinit var binding: PostWriteBinding
    private lateinit var editText: EditText
    private lateinit var captionTextView: TextView
    private lateinit var editText1: EditText
    private lateinit var captionTextView1: TextView
    private val maxCharacters = 300 // 최대 글자 수
    private val maxCharacters1 = 30 // 최대 글자 수
    var maxToggleCount = 2 // 최대 토글 횟수
    var currentToggleCount = 0 // 현재 토글 횟수


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PostWriteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val toggleListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                if (currentToggleCount >= maxToggleCount) {
                    buttonView.isChecked = false
                } else {
                    currentToggleCount++
                }
            } else {
                // 토글 해제 시 토글 횟수 감소
                currentToggleCount--
            }
        }

        binding.sad.setOnCheckedChangeListener(toggleListener)
        binding.helpless.setOnCheckedChangeListener(toggleListener)
        binding.shy.setOnCheckedChangeListener(toggleListener)
        binding.anoying.setOnCheckedChangeListener(toggleListener)
        binding.angry.setOnCheckedChangeListener(toggleListener)
        binding.joyful.setOnCheckedChangeListener(toggleListener)
        binding.tranquility.setOnCheckedChangeListener(toggleListener)
        binding.excited.setOnCheckedChangeListener(toggleListener)
        binding.happy.setOnCheckedChangeListener(toggleListener)

        editText = binding.detailinput
        captionTextView = binding.detailTextnum

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 첫 번째 EditText에 대한 코드 (maxCharacters = 300)
                val inputText = s.toString()
                val currentLength = inputText.length
                captionTextView.text = "$currentLength/$maxCharacters"

                if (currentLength > maxCharacters) {
                    editText.setText(inputText.substring(0, maxCharacters))
                    editText.setSelection(maxCharacters)
                    captionTextView.setTextColor(Color.parseColor("#E92626"))
                } else {
                    captionTextView1.setTextColor(Color.parseColor("#89857C"))
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        editText1 = binding.titleinput
        captionTextView1 = binding.titleTextnum

        editText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // 텍스트 변경 전에 호출되는 메서드
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 두 번째 EditText에 대한 코드 (maxCharacters1 = 30)
                val inputText1 = s.toString()
                val currentLength1 = inputText1.length
                captionTextView1.text = "$currentLength1/$maxCharacters1" // 현재 글자 수를 보여줍니다

                if (currentLength1 > maxCharacters1) {
                    editText1.setText(inputText1.substring(0, maxCharacters1))
                    editText1.setSelection(maxCharacters1)
                    captionTextView1.setTextColor(Color.parseColor("#E92626")) // 텍스트 색상을 변경합니다
                } else {
                    // 글자 수 제한 안에 있을 때 텍스트 색상을 리셋합니다
                    captionTextView1.setTextColor(Color.parseColor("#89857C"))
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // 텍스트 변경 후에 호출되는 메서드
            }
        })

        binding.send.setOnClickListener() {
            startActivity(Intent(this, QuestList::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
        binding.gobackIcon.setOnClickListener() {
            super.onBackPressed()
        }
    }
}