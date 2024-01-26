package br.com.thalesnishida.calcimc

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MainItem(
    val id: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val texStringId: Int,
    val color: Int
)
