package be.tftic.web2023.test_icon

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import be.tftic.web2023.test_icon.databinding.ActivityMainBinding


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
        enableIcon("MainActivityIcon1")
    }

    private fun changeToIcon2() {
        // Use with activity-alias "MainActivityIcon1"
        enableIcon("MainActivityIcon2")
    }

    private fun restoreInitialIcon() {
        // Use with activity "MainActivity"
        enableIcon("MainActivity")
    }

    private fun enableIcon(iconName : String) {
        // Disable all activity ()
        disableAllIcon()

        // Enable activity for use icon
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this@MainActivity,
                "$packageName.$iconName"
            ),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }
    private fun disableAllIcon() {
        val iconList = listOf<String>(
            "MainActivityIcon1",
            "MainActivityIcon2",
            "MainActivity"
        )

        iconList
            .forEach { icon ->
                Log.d("disableOtherIcon", icon)
            packageManager.setComponentEnabledSetting(
                ComponentName(
                    this@MainActivity,
                    "$packageName.$icon"
                ),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )
        }
    }
}