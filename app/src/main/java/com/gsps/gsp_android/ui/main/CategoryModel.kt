package com.gsps.gsp_android.ui.main

data class CategoryModel(
    private var category: String,
    private var isChecked: Boolean
) {
    fun getCategory(): String {
        return category
    }

    fun setCategory(category: String) {
        this.category = category
    }

    fun getChecked(): Boolean {
        return isChecked
    }

    fun setChecked(isChecked: Boolean) {
        this.isChecked = isChecked
    }
}
