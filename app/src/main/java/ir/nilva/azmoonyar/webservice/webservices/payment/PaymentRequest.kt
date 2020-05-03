package ir.nilva.azmoonyar.webservice.webservices.payment

import com.google.gson.annotations.SerializedName

import ir.nilva.azmoonyar.webservice.base.requestProcess.BaseRequest
import com.google.gson.annotations.Expose
import kotlin.random.Random

class PaymentRequest(
    @field:SerializedName("Amount") @Expose
    private val amount: Long,
    @field:SerializedName("MobileNo") @Expose
    private val MobileNo: Long = 9150773830,
    @field:SerializedName("PaymentType") @Expose
    private val PaymentType: Byte = 1,
    @field:SerializedName("OrderId") @Expose
    private val OrderId: Long = System.currentTimeMillis()
) : BaseRequest()