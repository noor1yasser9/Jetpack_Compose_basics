package com.noor.yasser.ps.jetpackcomposebasics.ComposePaging

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}