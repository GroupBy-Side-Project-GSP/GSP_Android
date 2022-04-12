package com.gsps.gsp_android.ui.main


import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener

import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityInterestBinding
import com.gsps.gsp_android.ui.base.BaseActivity


class InterestActivity : BaseActivity<ActivityInterestBinding>(
    R.layout.activity_interest
) {
    private val buttonSignIn: AppCompatButton by lazy { findViewById(R.id.btnInterestComplete) }

    companion object {
        var count: Int = 0
    }

    override fun initView() {
        check()
        binding.ibInterestBack.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    fun check() {
        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                if (count <= 4) {
                    when (buttonView) {
                        binding.designCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.managementCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.healthCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.environmentCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.materialCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.electronicCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.erectionCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.chemistryCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.planCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.printCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.salesCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.welfareCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.affairsCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                        binding.clothCheckBox -> {
                            binding.tvInterestCount.text = "(${++count}/5)"
                        }
                    }
                    if (count == 0) {
                        binding.btnInterestComplete.isEnabled = false
                    } else {
                        binding.btnInterestComplete.isEnabled = true
                    }
                } else {
                    Toast.makeText(this, "선택 갯수 초과입니다.", Toast.LENGTH_SHORT).show()
                    when (buttonView) {
                        binding.designCheckBox -> {
                            binding.designCheckBox.isChecked = false
                        }
                        binding.managementCheckBox -> {
                            binding.managementCheckBox.isChecked = false
                        }
                        binding.healthCheckBox -> {
                            binding.healthCheckBox.isChecked = false
                        }
                        binding.environmentCheckBox -> {
                            binding.environmentCheckBox.isChecked = false
                        }
                        binding.materialCheckBox -> {
                            binding.materialCheckBox.isChecked = false
                        }
                        binding.electronicCheckBox -> {
                            binding.electronicCheckBox.isChecked = false
                        }
                        binding.erectionCheckBox -> {
                            binding.erectionCheckBox.isChecked = false
                        }
                        binding.chemistryCheckBox -> {
                            binding.chemistryCheckBox.isChecked = false
                        }
                        binding.planCheckBox -> {
                            binding.planCheckBox.isChecked = false
                        }
                        binding.printCheckBox -> {
                            binding.printCheckBox.isChecked = false
                        }
                        binding.salesCheckBox -> {
                            binding.salesCheckBox.isChecked = false
                        }
                        binding.welfareCheckBox -> {
                            binding.welfareCheckBox.isChecked = false
                        }
                        binding.affairsCheckBox -> {
                            binding.affairsCheckBox.isChecked = false
                        }
                        binding.clothCheckBox -> {
                            binding.clothCheckBox.isChecked = false
                        }
                    }
                }
            } else {
                when (buttonView) {
                    binding.designCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.managementCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.healthCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.environmentCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.materialCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.electronicCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.erectionCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.chemistryCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.planCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.printCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.salesCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.welfareCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.affairsCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                    binding.clothCheckBox -> {
                        binding.tvInterestCount.text = "(${--count}/5)"
                    }
                }
                if (count == 0) {
                    binding.btnInterestComplete.isEnabled = false
                } else {
                    binding.btnInterestComplete.isEnabled = true
                }
            }
        }
        binding.designCheckBox.setOnCheckedChangeListener(listener)
        binding.managementCheckBox.setOnCheckedChangeListener(listener)
        binding.healthCheckBox.setOnCheckedChangeListener(listener)
        binding.environmentCheckBox.setOnCheckedChangeListener(listener)
        binding.materialCheckBox.setOnCheckedChangeListener(listener)
        binding.electronicCheckBox.setOnCheckedChangeListener(listener)
        binding.erectionCheckBox.setOnCheckedChangeListener(listener)
        binding.chemistryCheckBox.setOnCheckedChangeListener(listener)
        binding.planCheckBox.setOnCheckedChangeListener(listener)
        binding.printCheckBox.setOnCheckedChangeListener(listener)
        binding.salesCheckBox.setOnCheckedChangeListener(listener)
        binding.welfareCheckBox.setOnCheckedChangeListener(listener)
        binding.affairsCheckBox.setOnCheckedChangeListener(listener)
        binding.clothCheckBox.setOnCheckedChangeListener(listener)
    }
}

