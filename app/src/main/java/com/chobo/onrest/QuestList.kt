package com.chobo.onrest

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chobo.onrest.databinding.QuestListBinding

class QuestList : AppCompatActivity() {
    private lateinit var binding: QuestListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuestListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.dateTV.text = "21일"
        binding.dateTV1.text = "21일"
        binding.dateTV2.text = "21일"
        binding.missionTV.text = "명상을 해봐요"
        binding.missionTV1.text = "스트래칭을 해봐요"
        binding.missionTV2.text = "노래를 들어봐요"

        binding.speechbubble.setOnClickListener() {
            startActivity(Intent(this, NaviActivity::class.java))
            overridePendingTransition( R.anim.fade_in, R.anim.fade_out )
            finish()
        }
    }
}