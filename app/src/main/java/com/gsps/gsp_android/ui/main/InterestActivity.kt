package com.gsps.gsp_android.ui.main

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.annotation.CheckResult
import androidx.annotation.RequiresApi
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityInterestBinding
import com.gsps.gsp_android.databinding.ActivityProfileBinding
import com.gsps.gsp_android.ui.base.BaseActivity
import com.gsps.gsp_android.ui.model.InterestModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList



//@AndroidEntryPoint
class InterestActivity : BaseActivity<ActivityInterestBinding>(
    R.layout.activity_interest
) {
    private lateinit var ibinding: ActivityInterestBinding

    companion object{
        var count:Int =0
    }


    override fun initView() {
        ibinding = ActivityInterestBinding.inflate(layoutInflater)
        setContentView(ibinding.root)
        check()
    }




    fun check(){
        var listener =CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                when(buttonView){
                    ibinding.designCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.managementCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.healthCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.environmentCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.materialCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.electronicCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.erectionCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.chemistryCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.planCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.printCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.salesCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.welfareCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.AffairsCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                    ibinding.clothCheckBox -> {ibinding.TvInterestCount.text="(${++count}/5)"}
                }
            }else{
                when(buttonView){
                    ibinding.designCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.managementCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.healthCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.environmentCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.materialCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.electronicCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.erectionCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.chemistryCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.planCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.printCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.salesCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.welfareCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.AffairsCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                    ibinding.clothCheckBox -> {ibinding.TvInterestCount.text="(${--count}/5)"}
                }
            }
        }
        ibinding.designCheckBox.setOnCheckedChangeListener(listener)
        ibinding.managementCheckBox.setOnCheckedChangeListener(listener)
        ibinding.healthCheckBox.setOnCheckedChangeListener(listener)
        ibinding.environmentCheckBox.setOnCheckedChangeListener(listener)
        ibinding.materialCheckBox.setOnCheckedChangeListener(listener)
        ibinding.electronicCheckBox.setOnCheckedChangeListener(listener)
        ibinding.erectionCheckBox.setOnCheckedChangeListener(listener)
        ibinding.chemistryCheckBox.setOnCheckedChangeListener(listener)
        ibinding.planCheckBox.setOnCheckedChangeListener(listener)
        ibinding.printCheckBox.setOnCheckedChangeListener(listener)
        ibinding.salesCheckBox.setOnCheckedChangeListener(listener)
        ibinding.welfareCheckBox.setOnCheckedChangeListener(listener)
        ibinding.AffairsCheckBox.setOnCheckedChangeListener(listener)
        ibinding.clothCheckBox.setOnCheckedChangeListener(listener)
    }
}

