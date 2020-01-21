package com.citizenwarwick.memset.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.citizenwarwick.memset.core.di.get
import com.citizenwarwick.memset.core.model.MemoryCard
import com.citizenwarwick.memset.data.MemsetDatabase
import com.citizenwarwick.memset.data.entities.MemoryCardEntity
import com.squareup.moshi.Moshi

class MemoryCardRepository(
    private val db: MemsetDatabase = get(),
    private val moshi: Moshi = get()
) {
    suspend fun saveCard(card: MemoryCard) {
        val jsonAdapter = moshi.adapter(MemoryCard::class.java)
        val json = jsonAdapter.toJson(card)

        db.memoryCardDao().insertAll(MemoryCardEntity(uuid = card.uuid, cardJson = json))

    }

    fun getCards(): LiveData<List<MemoryCard>> {
        val jsonAdapter = moshi.adapter(MemoryCard::class.java)
        return Transformations.map(
            db.memoryCardDao().getAll()
        ) {
            it.map { jsonAdapter.fromJson(it.cardJson!!)!! }
        }
    }

    suspend fun deleteCard(card: MemoryCard) {
        db.memoryCardDao().deleteByUid(card.uuid)
    }
}
