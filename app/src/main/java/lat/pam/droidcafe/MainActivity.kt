package lat.pam.droidcafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity created")

        // Setup click listeners untuk ImageView
        setupImageClickListeners()

        // Setup FAB
        setupFAB()
    }

    private fun setupImageClickListeners() {
        try {
            findViewById<ImageView>(R.id.donut).setOnClickListener {
                displayToast(getString(R.string.donut_order_message))
            }

            findViewById<ImageView>(R.id.ice_cream).setOnClickListener {
                displayToast(getString(R.string.ice_cream_order_message))
            }

            findViewById<ImageView>(R.id.froyo).setOnClickListener {
                displayToast(getString(R.string.froyo_order_message))
            }
            Log.d(TAG, "Image click listeners setup successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Error setting up image click listeners: ${e.message}")
            displayToast("Error setting up click listeners")
        }
    }

    private fun setupFAB() {
        try {
            val fab = findViewById<FloatingActionButton>(R.id.fab)
            fab.setOnClickListener {
                Log.d(TAG, "FAB clicked")
                openOrderActivity()
            }
            Log.d(TAG, "FAB setup successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Error setting up FAB: ${e.message}")
            displayToast("Error setting up order button")
        }
    }

    private fun openOrderActivity() {
        try {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
            Log.d(TAG, "OrderActivity started successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Error starting OrderActivity: ${e.message}")
            displayToast("Error opening order page")
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}