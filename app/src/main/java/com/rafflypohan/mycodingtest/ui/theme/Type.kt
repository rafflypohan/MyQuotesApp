package com.rafflypohan.mycodingtest.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.rafflypohan.mycodingtest.R

@OptIn(ExperimentalTextApi::class)
val provider =  GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

@OptIn(ExperimentalTextApi::class)
val UbuntuFont = GoogleFont(name = "Ubuntu")

@OptIn(ExperimentalTextApi::class)
val DancingScriptFont = GoogleFont(name = "Dancing Script")

@OptIn(ExperimentalTextApi::class)
val UbuntuFontFamily = FontFamily(
    Font(UbuntuFont, fontProvider = provider, weight = FontWeight.Light),
    Font(UbuntuFont, fontProvider = provider, weight = FontWeight.Normal),
    Font(UbuntuFont, fontProvider = provider, weight = FontWeight.Medium),
    Font(UbuntuFont, fontProvider = provider, weight = FontWeight.SemiBold)
)

@OptIn(ExperimentalTextApi::class)
val DancingScriptFontFamily = FontFamily(
    Font(DancingScriptFont, fontProvider = provider, weight = FontWeight.Normal),
    Font(DancingScriptFont, fontProvider = provider, weight = FontWeight.Medium),
    Font(DancingScriptFont, fontProvider = provider, weight = FontWeight.SemiBold),
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 57.sp,
        lineHeight = 64.sp,
    ),
    h4 = TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 36.sp,
        lineHeight = 44.sp
    ),
    h6 =TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 24.sp,
        lineHeight = 36.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = DancingScriptFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
    ),
    body1 = TextStyle(
        fontFamily = UbuntuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
)