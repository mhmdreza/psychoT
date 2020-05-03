package ir.nilva.azmoonyar.webservice

import ir.nilva.azmoonyar.webservice.webservices.payment.PaymentProcess
import ir.nilva.azmoonyar.webservice.webservices.payment.PaymentResponse

object WebserviceHelper {

//    @Throws(IOException::class, WebserviceException::class)
//    fun record(): RecordResponse = RecordProcess().process()
//
//    @Throws(IOException::class, WebserviceException::class)
//    fun profile(): ProfileResponse = ProfileProcess().process()
//
//    @Throws(IOException::class, WebserviceException::class)
//    fun buy(cost: Int): BuyResponse = BuyProcess(cost).process()
//
//    @Throws(IOException::class, WebserviceException::class)
//    fun spinNow(id: String): SpinNowResponse = SpinNowProcess(id).process()
//
//    @Throws(IOException::class, WebserviceException::class)
//    fun luckyWheel(): LuckyWheelResponse = LuckyWheelProcess().process()

    fun payment(amount: Long): PaymentResponse {
        return PaymentProcess(amount).process()
    }

}
