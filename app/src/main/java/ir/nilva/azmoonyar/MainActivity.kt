package ir.nilva.azmoonyar

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.nilva.azmoonyar.data.Quiz
import ir.nilva.azmoonyar.data.SharedPref
import ir.nilva.azmoonyar.util.IabHelper
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


open class MainActivity : AppCompatActivity() {

    val TAG = ""
    val SKU_PREMIUM = ""
    var mIsPremium = false
    val RC_REQUEST = 100
    var mHelper: IabHelper? = null
    var view: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setLightStatusBar(window.decorView, this)
        val base64EncodedPublicKey =
            "MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwDeVtxFnsjvFtyulhSJVKtcmxAf9sS5ieWLmtRT+FYcf3G0lFAwJ27uML7iQ2fRB/DnbrPVQKMNslpNY39MoOBNpHYF3WSvyK1II/Rfgu5eLq7eWhPbBV3SzYVLVs9w/alqYoIaRbVGy07H9qrp/htbTZi9KI9M16o/ztJEXf+Plnzq7RmV7a2k5DrjnNgGaMJh2MFTOCLYZqh2RGttE9uYvtZcef/tCeDzaa5Ma38CAwEAAQ=="
        mHelper = IabHelper(this, base64EncodedPublicKey)

        Log.d(TAG, "Starting setup.")
        mHelper!!.startSetup { result ->
            Log.d(TAG, "Setup finished.")
            if (!result.isSuccess) { // Oh noes, there was a problem.
                Log.d(TAG, "Problem setting up In-app Billing: $result")
            }
            mHelper!!.queryInventoryAsync(mGotInventoryListener)
        }
    }

    private val mGotInventoryListener =
        IabHelper.QueryInventoryFinishedListener { result, inventory ->
            Log.d(TAG, "Query inventory finished.");
            if (result.isFailure) {
                Log.d(TAG, "Failed to query inventory: $result")
                return@QueryInventoryFinishedListener;
            } else {
                Log.d(TAG, "Query inventory was successful.");
                // does the user have the premium upgrade?
                mIsPremium = inventory.hasPurchase(SKU_PREMIUM);

                // update UI accordingly

                Log.d(TAG, "User is " + if (mIsPremium) "PREMIUM" else "NOT PREMIUM")
            }

            Log.d(TAG, "Initial inventory query finished; enabling main UI.")
        }

    private val mPurchaseFinishedListener =
        IabHelper.OnIabPurchaseFinishedListener { result, purchase ->
            if (result.isFailure) {
                Log.d(TAG, "Error purchasing: $result");
                Toast.makeText(
                    this,
                    "پرداخت شما با مشکل همراه بود. لطفا دوباره تلاش کنید",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                SharedPref.getInstance().setSuccessfulPayment()
                paymentFinished()
            }

        }

    lateinit var paymentFinished : () -> Unit

    fun openPayment(
        quiz: Quiz,
        paymentFinished: () -> Unit
    ) {
        this.paymentFinished = paymentFinished
        SharedPref.getInstance().setPayQuizId(quiz.id)
        mHelper?.launchPurchaseFlow(
            this,
            "quiz_id_${quiz.id}",
            RC_REQUEST,
            mPurchaseFinishedListener,
            "${quiz.id}"
        )

    }


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    private fun setLightStatusBar(view: View, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = view.systemUiVisibility
            flags = flags or SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
            activity.window.statusBarColor = Color.WHITE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        Log.d(TAG, "onActivityResult($requestCode,$resultCode,$data")

        // Pass on the activity result to the helper for handling
        if (!mHelper!!.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data)
        } else {
            Log.d(TAG, "onActivityResult handled by IABUtil.")
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (mHelper != null) mHelper!!.dispose()
        mHelper = null
    }


}
