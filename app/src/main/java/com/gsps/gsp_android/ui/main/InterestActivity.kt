package com.gsps.gsp_android.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityInterestBinding
import com.gsps.gsp_android.ui.adapter.InterestAdapter
import com.gsps.gsp_android.ui.base.BaseActivity
import com.gsps.gsp_android.ui.model.InterestModel
import com.gsps.gsp_android.ui.viewmodel.InterestViewModel
import dagger.hilt.android.AndroidEntryPoint

//class InterestActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_interest)
//    }
//}

@AndroidEntryPoint
class InterestActivity : BaseActivity<ActivityInterestBinding>(
    R.layout.activity_interest
) {
    private lateinit var ibinding: ActivityInterestBinding
    lateinit var interestViewModel: InterestViewModel

    companion object{
        var count: Int =0
    }
    val interestList = arrayListOf(
        InterestModel("디자인"),
        InterestModel("경영&회계"),
        InterestModel("보건&의료"),
        InterestModel("환경&에너지"),
        InterestModel("재료"),
        InterestModel("전기&전자"),
        InterestModel("건설"),
        InterestModel("화학&바이오"),
        InterestModel("기획&마케팅"),
        InterestModel("인쇄&공예"),
        InterestModel("영업판매"),
        InterestModel("사회목지"),
        InterestModel("사무"),
        InterestModel("섬유&의복")
    )

    override fun initView(){
        adpaterConnection(interestList)


//        ibinding = ActivityInterestBinding.inflate(layoutInflater)
//        setContentView(ibinding.root)
//
//        val interestList = arrayListOf(
//            InterestModel("디자인"),
//            InterestModel("경영&회계"),
//            InterestModel("보건&의료"),
//            InterestModel("환경&에너지"),
//            InterestModel("재료"),
//            InterestModel("전기&전자"),
//            InterestModel("건설"),
//            InterestModel("화학&바이오"),
//            InterestModel("기획&마케팅"),
//            InterestModel("인쇄&공예"),
//            InterestModel("영업판매"),
//            InterestModel("사회목지"),
//            InterestModel("사무"),
//            InterestModel("섬유&의복")
//        )
//
//        ibinding.RvInterestMenu.layoutManager = StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL)
//        ibinding.RvInterestMenu.setHasFixedSize(true)



//        ibinding.RvInterestMenu.adapter = InterestAdapter(interestList).setItemClickListener(object: InterestAdapter.OnItemClickListener{
//            var count: Int=0
//
//            override fun onCheckedChanged(v: View, position: Int, isChecked: Boolean) {
//                when(isChecked){
//                    false -> count++
//
//                }
//
//
//
//
//            }
//        })

        ibinding.RvInterestMenu.adapter = InterestAdapter(interestList).setItemClickListener(object : InterestAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {

                var checkedlist : ArrayList<Boolean> = arrayListOf(false)

                checkedlist.set(position,true)

            }
        }

//            override fun onClick(v: View, position: Int) {
//                val clickcheck: Boolean =false
//
//                when(clickcheck){
//                    false-> ibinding.RvInterestMenu[]
//                }
//
//            }


    }

    fun adpaterConnection(interestlist: ArrayList<InterestModel>){
        ibinding = ActivityInterestBinding.inflate(layoutInflater)
        setContentView(ibinding.root)



        ibinding.RvInterestMenu.layoutManager = StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL)
        ibinding.RvInterestMenu.setHasFixedSize(true)
    }

    fun observEvent(interestlist: ArrayList<InterestModel>){

        interestViewModel = ViewModelProvider(this).get(InterestViewModel::class.java)

        interestViewModel.countText.observe(this, Observer{
            ibinding.TvInterestCount.text =it
        })

        interestViewModel.init()


        ibinding.RvInterestMenu.adapter = InterestAdapter(interestList).setItemClickListener(object : InterestAdapter.OnItemClickListener{
            override fun onCheckedChanged(v: View, position: Int, isChecked: Boolean) {
                //해당 아이템 뷰의 값을
                v.setOnClickListener{

                }
            }
        }
    }
}