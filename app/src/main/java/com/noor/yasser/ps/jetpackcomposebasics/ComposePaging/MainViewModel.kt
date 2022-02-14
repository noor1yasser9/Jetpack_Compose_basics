package com.noor.yasser.ps.jetpackcomposebasics.ComposePaging


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noor.yasser.ps.jetpackcomposebasics.ComposePaging.ui.ListItem
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = Repository()
    var state by mutableStateOf(ScreenState())
    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            repository.getItems(nextPage, 20)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = state.items + items,
                page = newKey,
                endReached = items.isEmpty()
            )
        }
    )


    fun loadNextItems() {
        val id = arrayListOf(2, 3, 4, 5)
        val id2 = arrayListOf(2, 3, 4, 5, 6, 7, 8, 89)

        Log.e("tttttttt", "${id + id2}")
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

    init {
        loadNextItems()
    }
}

data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<ListItem> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)