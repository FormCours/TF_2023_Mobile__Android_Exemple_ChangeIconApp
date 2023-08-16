package be.tftic.web2023.test_icon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import be.tftic.web2023.test_icon.databinding.ActivityMainBinding
import be.tftic.web2023.test_icon.tools.IconAppTool


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
        // Use with activity-alias "MainActivityIcon1"
        IconAppTool.changeIcon(this, IconAppTool.IconEnum.ICON1)
    }

    private fun changeToIcon2() {
        // Use with activity-alias "MainActivityIcon1"
        IconAppTool.changeIcon(this, IconAppTool.IconEnum.ICON2)
    }

    private fun restoreInitialIcon() {
        // Use with activity "MainActivity"
        IconAppTool.changeIcon(this, IconAppTool.IconEnum.DEFAULT)
    }
}