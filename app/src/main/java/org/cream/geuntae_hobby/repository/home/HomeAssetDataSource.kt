package org.cream.geuntae_hobby.repository.home

import com.google.gson.Gson
import org.cream.geuntae_hobby.AssetLoader
import org.cream.geuntae_hobby.model.HomeData

class HomeAssetDataSource(private val assetLoader: AssetLoader) : HomeDataSource {

    private val gson = Gson()

    override fun getHomeData(): HomeData? {

        return  assetLoader.getJsonString("home.json")?.let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }


    }
}