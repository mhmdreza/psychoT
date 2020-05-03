package ir.nilva.azmoonyar.webservice.webservices.payment

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ir.nilva.azmoonyar.webservice.base.requestProcess.BaseResponse
import java.util.*

class PaymentResponse(
    @field: SerializedName("Status") @Expose
    val Status : Int,
    @field: SerializedName("Message") @Expose
    val message : String,
    @field: SerializedName("Data") @Expose
    val data : PaymentData
) : BaseResponse()

class PaymentData(
    @field: SerializedName("Token") @Expose
    val token: Int?,

    @field: SerializedName("ExpireDate") @Expose
    val expireDate: String?,

    @field: SerializedName("Status") @Expose
    val status: Int?,
    @field: SerializedName("Message") @Expose
    val message: String?
)