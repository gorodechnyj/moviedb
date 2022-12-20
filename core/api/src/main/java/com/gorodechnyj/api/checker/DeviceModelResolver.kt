package com.gorodechnyj.api.checker

class DeviceModelResolver(
    private val checkers: Map<DeviceModelType, DeviceModel.DeviceModelChecker>
) : DeviceModel {

    override fun getDeviceModelType(): DeviceModelType {
        for ((key, value) in checkers) {
            if (value.deviceModelEqualToDeviceModelType()) return key
        }
        return DeviceModelType.OTHER
    }
}
