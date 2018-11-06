package cubex.mahesh.tel_con_and9amnov

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tManager = getSystemService(
  Context.TELEPHONY_SERVICE) as TelephonyManager
        var cManager = getSystemService(
  Context.CONNECTIVITY_SERVICE) as ConnectivityManager
  var temp_list = mutableListOf<String>()
  temp_list.add("IMEI : ${tManager.deviceId}")
  temp_list.add("Sim Sno : ${tManager.simSerialNumber}")
  temp_list.add("Op Name : ${tManager.simOperatorName}")
  temp_list.add("Op ISO : ${tManager.simCountryIso}")

if( cManager.activeNetworkInfo != null){
    temp_list.add("Data  Enabled : true")
}else{
    temp_list.add("Data  Enabled : false")
}
var adapter = ArrayAdapter<String>(
        this@MainActivity,
        android.R.layout.simple_list_item_single_choice,
        temp_list)
lview.adapter = adapter

    }
}
