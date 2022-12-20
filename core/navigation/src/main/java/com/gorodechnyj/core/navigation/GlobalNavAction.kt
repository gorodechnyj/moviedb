package com.gorodechnyj.core.navigation

sealed class GlobalNavAction : Direction {

    object ToMainMenu : GlobalNavAction()
}
