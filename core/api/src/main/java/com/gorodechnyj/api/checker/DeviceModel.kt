package com.gorodechnyj.api.checker

interface DeviceModel {

    fun getDeviceModelType(): DeviceModelType

    interface DeviceModelChecker {
        fun deviceModelEqualToDeviceModelType(): Boolean
    }
}
