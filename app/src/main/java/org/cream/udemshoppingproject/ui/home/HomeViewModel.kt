package org.cream.udemshoppingproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.cream.udemshoppingproject.model.Banner
import org.cream.udemshoppingproject.model.Promotion
import org.cream.udemshoppingproject.model.Title
import org.cream.udemshoppingproject.repository.home.HomeRepository
import org.cream.udemshoppingproject.ui.common.Event

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    private val _promotions = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> = _promotions

    private val _openProductEvent = MutableLiveData<Event<String>>()
    val openProductEvent: LiveData<Event<String>> = _openProductEvent

    init {
        loadHomeData()
    }

    fun openProductDetail(productId: String) {
        _openProductEvent.value = Event(productId)
    }

    private fun loadHomeData() {
        val homeData = homeRepository.getHomeData()
        homeData?.let { homeData ->
            _title.value = homeData.title
            _topBanners.value = homeData.topBanners
            _promotions.value = homeData.promotions
        }
    }
}