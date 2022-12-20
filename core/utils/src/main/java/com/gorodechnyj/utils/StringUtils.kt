package com.gorodechnyj.utils

fun StringBuilder.appendNotNull(string: String?) = if (string != null) append(string) else this
