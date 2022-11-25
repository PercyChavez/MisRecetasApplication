package com.example.misrecetasapplication.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.misrecetasapplication.ActivityBase
import com.example.misrecetasapplication.R
import com.example.misrecetasapplication.data.model.ReceiptE
import com.example.misrecetasapplication.data.model.ReceiptResponse
import com.example.misrecetasapplication.databinding.ActivityHomeScreenBinding
import com.example.misrecetasapplication.databinding.ActivityMapScreenBinding
import com.example.misrecetasapplication.dialogs.ViewPicDialog
import com.example.misrecetasapplication.ui.DetailScreenActivity.DetailScreenActivity
import com.example.misrecetasapplication.ui.MapScreenActivity.MapScreenActivity
import com.example.misrecetasapplication.utils.Constants
import com.example.misrecetasapplication.utils.Utils

class HomeScreenActivity : ActivityBase(), HomeReceiptAdapter.onClickItemRecipe {

    lateinit var binding: ActivityHomeScreenBinding
    lateinit var adapter: HomeReceiptAdapter
    private val homeScreenViewModel: HomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        val search = menu.findItem(R.id.appSearchBar)
        val searchView = search.actionView as android.widget.SearchView
        searchView.queryHint = "Busca por nombre o receta..."
        searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.addAllItems(lastReceipts.filter { it.getNameStr().contains(newText!!) || it.getDescriptionStr().contains(newText!!) }.toMutableList())
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onResume() {
        super.onResume()
        homeScreenViewModel.getAllReceipts()
    }

    private fun initAdapter(){
        adapter = HomeReceiptAdapter(Utils.getLocalReceipts(this), this)
        binding.recipeList.layoutManager = LinearLayoutManager(this)
        binding.recipeList.adapter = adapter
        binding.recipeList.setHasFixedSize(true)
    }

    var lastReceipts: MutableList<ReceiptE> = mutableListOf()
    private fun initViewModel(){
        homeScreenViewModel.receipts.observe(this, Observer {
            responseAction(onPause){
                dismissLoader()
                lastReceipts.clear()
                lastReceipts.addAll(it)
                adapter.addAllItems(it)
                Utils.saveStringPreferences(this, Constants.RECEIPTS_LIST, Utils.toJson(ReceiptResponse(it)))
            }
        })

        homeScreenViewModel.message.observe(this, Observer {
            responseAction(onPause){
                dismissLoader()
                //* show message if is wrong answer

            }
        })
    }

    override fun onClick(item: ReceiptE) {
        val intent = Intent(this@HomeScreenActivity, DetailScreenActivity::class.java)
        intent.putExtra("recipeData", Utils.toJson(item))
        startActivity(intent)
    }

    override fun onClickImage(item: ReceiptE) {
        ViewPicDialog.newInstance(item.getImgNotNull(), item.getNameStr()).show(supportFragmentManager, "VIEW_PIC_FRAGMENT")
    }
}