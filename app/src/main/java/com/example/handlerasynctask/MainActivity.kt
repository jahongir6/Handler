package com.example.handlerasynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.handlerasynctask.databinding.ActivityMainBinding

/*Thread -> oqim bir vaqtda bir nechta ishni bajarish
* thread yasashni 2 xil usuli bor edi
* 1->thread classida voris olgan paytda
* 2->runnable interfase da implement qilganda*/
/*thread 2 turga bolinib ketyapti
* 1-mainthread-> va mainthrad  ham turlari bor -> ui
* 2-backroundthread->ham bolinib ketadi ->io thread ->malumot bn ishlaydi,va defaulthread-> protsessorda hisob kitob amallarini bajaradi*/
class MainActivity : AppCompatActivity() {
    lateinit var handler: Handler
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handler = Handler(Looper.getMainLooper())
        handler.postDelayed(runnable, 3000)
    }

    var count = 0
    var runnable = object : Runnable {
        override fun run() {
            binding.tvTime.text = count.toString()
            count--
            handler.postDelayed(this, 1000)
        }
    }
}