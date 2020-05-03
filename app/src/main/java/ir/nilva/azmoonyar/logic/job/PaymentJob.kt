package ir.nilva.azmoonyar.logic.job

import ir.nilva.azmoonyar.webservice.base.WebserviceException
import ir.nilva.azmoonyar.logic.PAYMENT
import ir.nilva.azmoonyar.webservice.WebserviceHelper
import org.greenrobot.eventbus.EventBus
import java.io.IOException

class PaymentJob : BaseJob() {
    override fun onRunJob(p0: Params): Result {
        try {
            val payment = WebserviceHelper.payment(amount)
            EventBus.getDefault().post(OnPaymentJobSuccessEvent(payment))
            return Result.SUCCESS
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: WebserviceException) {
            e.printStackTrace()
        }

        return Result.FAILURE
    }

    companion object {
        private var amount = 0L

        fun schedule(paymentAmount: Long) {
            amount = paymentAmount
            scheduleImmediateJob(PAYMENT)
        }
    }
}