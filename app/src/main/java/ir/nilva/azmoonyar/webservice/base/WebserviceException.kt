package ir.nilva.azmoonyar.webservice.base

class WebserviceException(private val code: Int, override val message: String?) : Exception() {

    override fun toString(): String {
        return "WebserviceException{" +
                "code=" + code +
                ", message='" + message + '\''.toString() +
                '}'.toString()
    }
}
