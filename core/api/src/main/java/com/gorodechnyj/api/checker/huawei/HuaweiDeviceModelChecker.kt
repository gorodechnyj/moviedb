package com.gorodechnyj.api.checker.huawei

import android.os.Build
import com.gorodechnyj.api.checker.DeviceModel

object HuaweiDeviceModelChecker : DeviceModel.DeviceModelChecker {

    private const val HUAWEI = "HUAWEI"

    override fun deviceModelEqualToDeviceModelType() = Build.MANUFACTURER.contains(HUAWEI, true)
}
