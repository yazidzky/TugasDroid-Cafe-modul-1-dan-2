package lat.pam.droidcafe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    private val TAG = "OrderActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        Log.d(TAG, "OrderActivity created")
        setupCitySpinner()
    }

    private fun setupCitySpinner() {
        try {
            val citySpinner: Spinner = findViewById(R.id.city_spinner)
            citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (position > 0) {
                        val selectedCity = parent.getItemAtPosition(position).toString()
                        displayToast("Kota dipilih: $selectedCity")
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Do nothing
                }
            }
            Log.d(TAG, "City spinner setup successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Error setting up city spinner: ${e.message}")
        }
    }

    fun onRadioButtonClicked(view: View) {
        try {
            val checked = (view as RadioButton).isChecked
            when (view.id) {
                R.id.sameday -> if (checked)
                    displayToast(getString(R.string.same_day_messenger_service))
                R.id.nextday -> if (checked)
                    displayToast(getString(R.string.next_day_ground_delivery))
                R.id.pickup -> if (checked)
                    displayToast(getString(R.string.pick_up))
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error in radio button click: ${e.message}")
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}