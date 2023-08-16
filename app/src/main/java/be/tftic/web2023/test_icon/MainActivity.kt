package be.tftic.web2023.test_icon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import be.tftic.web2023.test_icon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private  lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // OnClickListener
        binding.btnMainChoice1.setOnClickListener { changeToIcon1() }
        binding.btnMainChoice2.setOnClickListener { changeToIcon2() }
        binding.btnMainRestore.setOnClickListener { restoreInitialIcon() }
    }

    private fun changeToIcon1() {
        TODO("Not yet implemented")
    }

    private fun changeToIcon2() {
        TODO("Not yet implemented")
    }

    private fun restoreInitialIcon() {
        TODO("Not yet implemented")
    }
}