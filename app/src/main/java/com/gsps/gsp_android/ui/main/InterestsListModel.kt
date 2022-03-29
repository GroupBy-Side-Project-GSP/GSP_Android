package com.gsps.gsp_android.ui.main

data class InterestsListModel(
    var category: String,
    var innerList: MutableList<InterestsMemberModel>
)
