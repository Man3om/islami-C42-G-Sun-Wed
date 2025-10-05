package com.route.islamic42gsunwed.fragments.radio.api.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class RadioResponse(

	@field:SerializedName("radios")
	val radios: List<RadiosItem>? = null
) : Parcelable