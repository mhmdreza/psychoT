package ir.nilva.azmoonyar.webservice.webservices.payment

import java.io.IOException

import ir.nilva.azmoonyar.webservice.base.requestProcess.BaseProcess
import ir.nilva.azmoonyar.webservice.base.MyRetrofit
import ir.nilva.azmoonyar.webservice.base.WebserviceException

class PaymentProcess(amount: Long) : BaseProcess() {
    private val request: PaymentRequest = PaymentRequest(amount)


    @Throws(IOException::class, WebserviceException::class)
    override fun process(): PaymentResponse {
        val login = MyRetrofit.webserviceUrls.payment(request)
        return send(login)
    }
}
