package com.mhmdreza.azmoonyar.webservice.base.requestProcess

import com.google.gson.annotations.Expose

open class BaseResponse {
    @Expose
    var messageBody: String? = null
}
