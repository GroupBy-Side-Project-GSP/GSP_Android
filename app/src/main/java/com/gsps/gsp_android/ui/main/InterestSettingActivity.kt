package com.gsps.gsp_android.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityInterestSettingBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class InterestSettingActivity : BaseActivity<ActivityInterestSettingBinding>(
    R.layout.activity_interest_setting
) {

    companion object{
        var count:Int =0
    }

    override fun initView() {

        check()

        binding.btnMyPageBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnMyPageInterestComplete.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun check(){
        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                if(count<=4){
                    when(buttonView){
                        binding.myPageDesignCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageManagementCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageHealthCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageEnvironmentCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageMaterialCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageElectronicCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageErectionCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageChemistryCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPagePlanCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPagePrintCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageSalesCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageWelfareCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageAffairsCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                        binding.myPageClothCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${++count}/5)"}
                    }
                    if(count==0){
                        binding.btnMyPageInterestComplete.isEnabled=false
                    }else{
                        binding.btnMyPageInterestComplete.isEnabled=true
                    }
                }else{
                    Toast.makeText(this, "선택 갯수 초과입니다.", Toast.LENGTH_SHORT).show()
                    when(buttonView){
                        binding.myPageDesignCheckBox -> {binding.myPageDesignCheckBox.isChecked=false}
                        binding.myPageManagementCheckBox -> {binding.myPageManagementCheckBox.isChecked=false}
                        binding.myPageHealthCheckBox -> {binding.myPageHealthCheckBox.isChecked=false}
                        binding.myPageEnvironmentCheckBox -> {binding.myPageEnvironmentCheckBox.isChecked=false}
                        binding.myPageMaterialCheckBox -> {binding.myPageMaterialCheckBox.isChecked=false}
                        binding.myPageElectronicCheckBox -> {binding.myPageElectronicCheckBox.isChecked=false}
                        binding.myPageErectionCheckBox -> {binding.myPageErectionCheckBox.isChecked=false}
                        binding.myPageChemistryCheckBox -> {binding.myPageChemistryCheckBox.isChecked=false}
                        binding.myPagePlanCheckBox -> {binding.myPagePlanCheckBox.isChecked=false}
                        binding.myPagePrintCheckBox -> {binding.myPagePrintCheckBox.isChecked=false}
                        binding.myPageSalesCheckBox -> {binding.myPageSalesCheckBox.isChecked=false}
                        binding.myPageWelfareCheckBox -> {binding.myPageWelfareCheckBox.isChecked=false}
                        binding.myPageAffairsCheckBox -> {binding.myPageAffairsCheckBox.isChecked=false}
                        binding.myPageClothCheckBox -> {binding.myPageClothCheckBox.isChecked=false}
                    }
                }
            }else{
                when(buttonView){
                    binding.myPageDesignCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageManagementCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageHealthCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageEnvironmentCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageMaterialCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageElectronicCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageErectionCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageChemistryCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPagePlanCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPagePrintCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageSalesCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageWelfareCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageAffairsCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                    binding.myPageClothCheckBox -> {binding.tvMyPageInterestSettingCount.text="(${--count}/5)"}
                }
                if(count==0){
                    binding.btnMyPageInterestComplete.isEnabled=false
                }else{
                    binding.btnMyPageInterestComplete.isEnabled=true
                }
            }
        }
        binding.myPageDesignCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageManagementCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageHealthCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageEnvironmentCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageMaterialCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageElectronicCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageErectionCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageChemistryCheckBox.setOnCheckedChangeListener(listener)
        binding.myPagePlanCheckBox.setOnCheckedChangeListener(listener)
        binding.myPagePrintCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageSalesCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageWelfareCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageAffairsCheckBox.setOnCheckedChangeListener(listener)
        binding.myPageClothCheckBox.setOnCheckedChangeListener(listener)
    }
}