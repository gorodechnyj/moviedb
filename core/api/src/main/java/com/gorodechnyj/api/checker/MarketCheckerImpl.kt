package com.gorodechnyj.api.checker

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Base64
import com.gorodechnyj.api.market.MarketChecker
import com.gorodechnyj.api.market.MarketType
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Arrays

private const val GOOGLE_PLAY_MARKET_HASH = "+b0tWQlai/i"
private const val HUAWEI_APP_GALLERY_HASH = "7wrXfa2ry4f"

class MarketCheckerImpl(
    private val context: Context
) : MarketChecker {

    override fun checkMarket(): MarketType {
        return try {
            when (AppSignatureHelper.getHash(context)) {
                GOOGLE_PLAY_MARKET_HASH -> MarketType.GOOGLE_PLAY_MARKET
                HUAWEI_APP_GALLERY_HASH -> MarketType.HUAWEI_APP_GALLERY
                else -> MarketType.UNKNOWN
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            MarketType.UNKNOWN
        }
    }
}

private object AppSignatureHelper {
    private const val HASH_TYPE = "SHA-256"
    private const val NUM_HASHED_BYTES = 9
    private const val NUM_BASE64_CHAR = 11

    fun getHash(context: Context): String {
        var hash = ""
        try {
            val packageName = context.packageName
            val packageManager = context.packageManager
            val signatures = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageManager.getPackageInfo(
                    packageName,
                    PackageManager.GET_SIGNING_CERTIFICATES
                ).signingInfo.apkContentsSigners
            } else {
                packageManager.getPackageInfo(
                    packageName,
                    PackageManager.GET_SIGNATURES
                ).signatures
            }

            hash = hash(
                packageName,
                signatures[0].toCharsString()
            ).orEmpty()
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return hash
    }

    private fun hash(packageName: String, signature: String): String? {
        val appInfo = "$packageName $signature"
        try {
            val messageDigest = MessageDigest.getInstance(HASH_TYPE)
            messageDigest.update(appInfo.toByteArray(StandardCharsets.UTF_8))
            var hashSignature = messageDigest.digest()

            hashSignature = Arrays.copyOfRange(
                hashSignature,
                0,
                NUM_HASHED_BYTES
            )
            var base64Hash =
                Base64.encodeToString(hashSignature, Base64.NO_PADDING or Base64.NO_WRAP)
            base64Hash = base64Hash.substring(
                0,
                NUM_BASE64_CHAR
            )
            return base64Hash
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return null
    }
}
