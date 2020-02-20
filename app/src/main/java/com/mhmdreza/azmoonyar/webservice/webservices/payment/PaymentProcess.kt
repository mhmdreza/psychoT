package com.mhmdreza.azmoonyar.webservice.webservices.payment

import java.io.IOException

import com.mhmdreza.azmoonyar.webservice.base.requestProcess.BaseProcess
import com.mhmdreza.azmoonyar.webservice.base.MyRetrofit
import com.mhmdreza.azmoonyar.webservice.base.WebserviceException

class PaymentProcess(amount: Long) : BaseProcess() {
    private val request: PaymentRequest = PaymentRequest(amount)


    @Throws(IOException::class, WebserviceException::class)
    override fun process(): PaymentResponse {
        val login = MyRetrofit.webserviceUrls.payment(request)
        return send(login)
    }
}
