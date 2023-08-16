package be.tftic.web2023.test_icon.tools

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log

class IconAppTool private constructor() {

    // This enum must be contain all activity name to use their icon
    enum class IconEnum(val value: String) {
        ICON1("MainActivityIcon1"),
        ICON2("MainActivityIcon2"),
        DEFAULT("MainActivity")
    }

    companion object {
        fun changeIcon(context: Context, icon: IconEnum) {
            // Disable all activity to remove icon
            disableAllIcon(context)

            // Enable activity for use icon
            context.packageManager.setComponentEnabledSetting(
                ComponentName(
                    context,
                    "${context.packageName}.${icon.value}"
                ),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )
        }

        private fun disableAllIcon(context: Context) {
            IconEnum.values()
                .map { iconEnum -> iconEnum.value }
                .forEach { icon ->
                    Log.d("disableOtherIcon", icon)
                    context.packageManager.setComponentEnabledSetting(
                        ComponentName(
                            context,
                            "${context.packageName}.$icon"
                        ),
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP
                    )
                }
        }
    }
}