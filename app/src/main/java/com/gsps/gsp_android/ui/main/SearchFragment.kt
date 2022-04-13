package com.gsps.gsp_android.ui.main

import android.widget.CompoundButton
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentSearchBinding
import com.gsps.gsp_android.ui.base.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    companion object {
        var count: Int = 0
    }

    override fun initView() {
        check()
    }

    fun check() {
        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                when (buttonView) {
                    binding.searchDesignCheckBox -> {
                    }
                    binding.searchManagementCheckBox -> {
                    }
                    binding.searchHealthCheckBox -> {
                    }
                    binding.searchEnvironmentCheckBox -> {
                    }
                    binding.searchMaterialCheckBox -> {
                    }
                    binding.searchElectronicCheckBox -> {
                    }
                    binding.searchErectionCheckBox -> {
                    }
                    binding.searchChemistryCheckBox -> {
                    }
                    binding.searchPlanCheckBox -> {
                    }
                    binding.searchPrintCheckBox -> {
                    }
                    binding.searchSalesCheckBox -> {
                    }
                    binding.searchWelfareCheckBox -> {
                    }
                    binding.searchAffairsCheckBox -> {
                    }
                    binding.searchClothCheckBox -> {
                    }
                }
                binding.btnSelectSearch.isEnabled = count != 0
                when (buttonView) {
                    binding.searchDesignCheckBox -> {
                        binding.searchDesignCheckBox.isChecked = false
                    }
                    binding.searchManagementCheckBox -> {
                        binding.searchManagementCheckBox.isChecked = false
                    }
                    binding.searchHealthCheckBox -> {
                        binding.searchHealthCheckBox.isChecked = false
                    }
                    binding.searchEnvironmentCheckBox -> {
                        binding.searchEnvironmentCheckBox.isChecked = false
                    }
                    binding.searchMaterialCheckBox -> {
                        binding.searchMaterialCheckBox.isChecked = false
                    }
                    binding.searchElectronicCheckBox -> {
                        binding.searchElectronicCheckBox.isChecked = false
                    }
                    binding.searchErectionCheckBox -> {
                        binding.searchErectionCheckBox.isChecked = false
                    }
                    binding.searchChemistryCheckBox -> {
                        binding.searchChemistryCheckBox.isChecked = false
                    }
                    binding.searchPlanCheckBox -> {
                        binding.searchPlanCheckBox.isChecked = false
                    }
                    binding.searchPrintCheckBox -> {
                        binding.searchPrintCheckBox.isChecked = false
                    }
                    binding.searchSalesCheckBox -> {
                        binding.searchSalesCheckBox.isChecked = false
                    }
                    binding.searchWelfareCheckBox -> {
                        binding.searchWelfareCheckBox.isChecked = false
                    }
                    binding.searchAffairsCheckBox -> {
                        binding.searchAffairsCheckBox.isChecked = false
                    }
                    binding.searchClothCheckBox -> {
                        binding.searchClothCheckBox.isChecked = false
                    }
                }
            } else {
                when (buttonView) {
                    binding.searchDesignCheckBox -> {
                    }
                    binding.searchManagementCheckBox -> {
                    }
                    binding.searchHealthCheckBox -> {
                    }
                    binding.searchEnvironmentCheckBox -> {
                    }
                    binding.searchMaterialCheckBox -> {
                    }
                    binding.searchElectronicCheckBox -> {
                    }
                    binding.searchErectionCheckBox -> {
                    }
                    binding.searchChemistryCheckBox -> {
                    }
                    binding.searchPlanCheckBox -> {
                    }
                    binding.searchPrintCheckBox -> {
                    }
                    binding.searchSalesCheckBox -> {
                    }
                    binding.searchWelfareCheckBox -> {
                    }
                    binding.searchAffairsCheckBox -> {
                    }
                    binding.searchClothCheckBox -> {
                    }
                }
                binding.btnSelectSearch.isEnabled = count != 0
            }
        }
        binding.searchDesignCheckBox.setOnCheckedChangeListener(listener)
        binding.searchManagementCheckBox.setOnCheckedChangeListener(listener)
        binding.searchHealthCheckBox.setOnCheckedChangeListener(listener)
        binding.searchEnvironmentCheckBox.setOnCheckedChangeListener(listener)
        binding.searchMaterialCheckBox.setOnCheckedChangeListener(listener)
        binding.searchElectronicCheckBox.setOnCheckedChangeListener(listener)
        binding.searchErectionCheckBox.setOnCheckedChangeListener(listener)
        binding.searchChemistryCheckBox.setOnCheckedChangeListener(listener)
        binding.searchPlanCheckBox.setOnCheckedChangeListener(listener)
        binding.searchPrintCheckBox.setOnCheckedChangeListener(listener)
        binding.searchSalesCheckBox.setOnCheckedChangeListener(listener)
        binding.searchWelfareCheckBox.setOnCheckedChangeListener(listener)
        binding.searchAffairsCheckBox.setOnCheckedChangeListener(listener)
        binding.searchClothCheckBox.setOnCheckedChangeListener(listener)
    }
}