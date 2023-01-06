package com.example.retrofitexample.tutormvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}

//class RecipeViewModel : ViewModel() {
//    private var recipeLiveData = MutableLiveData<List<Meal>>()
//    fun getMealsByCountryName() {
//        MealInstance.api.getRecipeByCountryName("Indian").enqueue(object : Callback<Recipe> {
//            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
//                response.body()?.let { mealsList ->
//                    recipeLiveData.postValue(mealsList.meals)
//                }
//            }
//
//            override fun onFailure(call: Call<Recipe>, t: Throwable) {
//                Log.i("TAG", t.message.toString())
//            }
//
//        })
//    }
//
//    fun observeLiveData(): LiveData<List<Meal>> {
//        return recipeLiveData
//    }
//}