package com.example.misrecetasapplication.ui.MapScreenActivity

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.PersistableBundle
import com.example.misrecetasapplication.ActivityBase
import com.example.misrecetasapplication.R
import com.example.misrecetasapplication.data.model.ReceiptE
import com.example.misrecetasapplication.databinding.ActivityMapScreenBinding
import com.example.misrecetasapplication.utils.Utils
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import java.net.URL


class MapScreenActivity : ActivityBase(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapScreenBinding
    lateinit var recipe: ReceiptE


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("recipe_data", Utils.toJson(recipe))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        recipe = Gson().fromJson(savedInstanceState.getString("recipe_data"), ReceiptE::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            recipe = Gson().fromJson(extras.getString("recipeData"), ReceiptE::class.java)
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val prev = supportFragmentManager.findFragmentByTag("map")
        var mapFragment: SupportMapFragment? = null
        if (prev == null) {
            val gmapOptions = GoogleMapOptions().liteMode(false)
            mapFragment = SupportMapFragment.newInstance(gmapOptions)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.recipe_map, mapFragment, "map")
                .commit()
        }
        if (mapFragment == null) {
            mapFragment = supportFragmentManager.findFragmentByTag("map") as SupportMapFragment?
        }
        mapFragment?.getMapAsync(this)
        MapsInitializer.initialize(applicationContext)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        addMarker()
        mMap.uiSettings.isZoomControlsEnabled = true
    }

    var recipeMarker: Marker? = null
    private fun addMarker(){
        val recipeLocation = LatLng(recipe.getLatNotNull().toDouble(), recipe.getLngNotNull().toDouble())
        val markerOptions = MarkerOptions().position(recipeLocation).anchor(0.5f, 1f)
        markerOptions.title(recipe.getNameStr())
        markerOptions.snippet("Recetas App")
        //markerOptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeStream(URL(recipe.getImgNotNull()).openConnection().getInputStream())))
        recipeMarker = mMap.addMarker(markerOptions)
        recipeMarker!!.showInfoWindow()
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recipeLocation, 16.0f))
    }


}