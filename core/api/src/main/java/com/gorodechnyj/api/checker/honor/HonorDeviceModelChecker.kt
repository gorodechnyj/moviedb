package com.gorodechnyj.api.checker.honor

import android.os.Build
import com.gorodechnyj.api.checker.DeviceModel

object HonorDeviceModelChecker : DeviceModel.DeviceModelChecker {

    private const val HONOR = "HONOR"

    override fun deviceModelEqualToDeviceModelType() = Build.MANUFACTURER.contains(HONOR, true)
}
