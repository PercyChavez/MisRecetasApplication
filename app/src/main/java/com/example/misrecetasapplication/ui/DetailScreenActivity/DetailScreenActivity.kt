package com.example.misrecetasapplication.ui.DetailScreenActivity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.misrecetasapplication.R
import com.example.misrecetasapplication.data.model.ReceiptE
import com.example.misrecetasapplication.databinding.ActivityDetaiScreenBinding
import com.example.misrecetasapplication.ui.MapScreenActivity.MapScreenActivity
import com.example.misrecetasapplication.utils.Utils
import com.example.misrecetasapplication.utils.loadReceiptImg
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.gson.Gson

class DetailScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetaiScreenBinding
    lateinit var recipe: ReceiptE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetaiScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            recipe = Gson().fromJson(extras.getString("recipeData"), ReceiptE::class.java)
        }

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title

        binding.toolbarLayout.title = recipe.getNameStr()
        binding.imgColapsing.loadReceiptImg(recipe.getImgNotNull())
        binding.recipeDescription.text = recipe.description
        binding.recipeName.text = recipe.name
        binding.ingredients.text = recipe.getIngredientsNotNull()
        binding.fab.setOnClickListener {
            val intent = Intent(this@DetailScreenActivity, MapScreenActivity::class.java)
            intent.putExtra("recipeData", Utils.toJson(recipe))
            startActivity(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("recipe_data", Utils.toJson(recipe))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        recipe = Gson().fromJson(savedInstanceState.getString("recipe_data"), ReceiptE::class.java)
    }

}