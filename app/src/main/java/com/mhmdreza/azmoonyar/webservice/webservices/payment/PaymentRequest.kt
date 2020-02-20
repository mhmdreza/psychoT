package com.mhmdreza.azmoonyar.webservice.webservices.payment

import com.google.gson.annotations.SerializedName

import com.mhmdreza.azmoonyar.webservice.base.requestProcess.BaseRequest
import com.google.gson.annotations.Expose
import kotlin.random.Random

class PaymentRequest(
    @field:SerializedName("Amount") @Expose
    private val amount: Long,
    @field:SerializedName("MobileNo") @Expose
    private val MobileNo: Long = 9395472004,
    @field:SerializedName("PaymentType") @Expose
    private val PaymentType: Byte = 2,
    @field:SerializedName("OrderId") @Expose
    private val OrderId: Long = Random(System.currentTimeMillis()).nextLong()
) : BaseRequest()
