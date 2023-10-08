package com.example.sandwhiches.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


private const val PRICE_PER_SANDWHICH=5.00

class OrderViewModel:ViewModel(){

    val dateoptions=getPickupOptions()
    private val _flavour=MutableLiveData<String>()
    val flavour:LiveData<String> = _flavour

    private val _date=MutableLiveData<String>()
    val date:LiveData<String> =_date

    private val _price=MutableLiveData<Double>()
    val price:LiveData<Double> =_price



    fun setFlavor(desiredFlavor: String) {
        _flavour.value = desiredFlavor
        updatePrice()
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
        updatePrice()
    }

    fun hasNoFlavourset():Boolean{
        return _flavour.value.isNullOrEmpty()
    }

    private fun getPickupOptions():List<String>{
        val options= mutableListOf<String>()
        val formatter=SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar=Calendar.getInstance()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options

    }

    fun resetOrder(){
        _flavour.value=" "
        _date.value=dateoptions[0]
        _price.value=0.0

    }
    init{
        resetOrder()
    }

    private fun updatePrice(){
        _price.value= PRICE_PER_SANDWHICH
    }
}