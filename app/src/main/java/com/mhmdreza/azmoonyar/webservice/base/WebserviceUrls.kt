package com.mhmdreza.azmoonyar.webservice.base
import com.mhmdreza.azmoonyar.webservice.base.constants.PAYMENT
import com.mhmdreza.azmoonyar.webservice.webservices.payment.PaymentRequest
import com.mhmdreza.azmoonyar.webservice.webservices.payment.PaymentResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WebserviceUrls {
//    @POST(LOGIN)
//    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(PAYMENT)
    fun payment(@Body request: PaymentRequest): Call<PaymentResponse>

//    @GET(RECORD)
//    fun record(): Call<RecordResponse>
//
//    @GET(PROFILE)
//    fun profile(): Call<ProfileResponse>
//
//    @GET(BUY)
//    fun buy(@Body request: BuyRequest): Call<BuyResponse>
//
//    @GET(LUCKY_WHEEL)
//    fun luckyWheel(): Call<LuckyWheelResponse>
//
//    @POST(SPIN_NOW)
//    fun spinNow(request: SpinNowRequest): Call<SpinNowResponse>
}
