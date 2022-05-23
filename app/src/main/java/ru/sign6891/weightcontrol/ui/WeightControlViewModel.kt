package ru.sign6891.weightcontrol.ui

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.sign6891.weightcontrol.data.repository.DataRepository
import ru.sign6891.weightcontrol.data.source.local.entity.DataElementEntity
import java.lang.IllegalArgumentException

class WeightControlViewModel(private val repo:DataRepository): ViewModel() {

    //Получить список элементов
    val allDataElement: LiveData<List<DataElementEntity>> = repo.allDataElement

    //Получить один элемент
    fun getElement(elementId: Int): LiveData<DataElementEntity> = repo.getElement(elementId)

    //Добавить запист в БД
    fun addDataElement(element: DataElementEntity) = viewModelScope.launch {
        repo.insert(element)
    }

}

class WeightControlViewModelFactory(private val repository: DataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeightControlViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WeightControlViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}