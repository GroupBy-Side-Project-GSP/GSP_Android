package com.gsps.gsp_android.ui.chattinglist

import androidx.lifecycle.ViewModel
import com.gsps.gsp_android.data.repository.chatlist.ChattingListRepository

class ChatListViewModel(
    val chattingListRepository: ChattingListRepository
): ViewModel() {
}