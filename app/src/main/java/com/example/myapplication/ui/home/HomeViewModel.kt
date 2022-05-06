package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.objects.Child
import com.example.myapplication.ui.NavigationCommand
import com.example.myapplication.ui.BaseViewModel


class HomeViewModel : BaseViewModel() {

    private val _childList = MutableLiveData<List<Child>>()
    val childList : LiveData<List<Child>> = _childList

    init {
        fetchChildList()
    }

    private fun fetchChildList() {
        var newList = listOf(
            Child(name = "Bartek", dutyPoints = 13, behaviourPoints = 4, drawableName = "kid"),
            Child(name = "Antek", dutyPoints = 10, behaviourPoints = 6, drawableName = "kid"),
            Child(name = "Marta", dutyPoints = 7, behaviourPoints = 11, drawableName = "kid"),
        )
        _childList.value = newList
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun addNewChild(){
        var direction = HomeFragmentDirections.actionNavigationHomeToChildAddEditFragment()
        navigateTo(NavigationCommand.To(direction))
    }
}