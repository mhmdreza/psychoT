package com.mhmdreza.azmoonyar.logic

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator
import com.mhmdreza.azmoonyar.logic.job.PaymentJob

const val PAYMENT = "PAYMENT"

class MyJobCreator : JobCreator {

    override fun create(s: String): Job? {
        return when (s) {
            PAYMENT -> PaymentJob()
            else -> null
        }
    }
}
