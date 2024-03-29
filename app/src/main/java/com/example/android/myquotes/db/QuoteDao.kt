package com.example.android.myquotes.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.android.myquotes.models.MyQuotes
import com.example.android.myquotes.models.Result

@Dao
interface QuoteDao {
    @Insert
    suspend fun addQuote(quotes : Result)

    @Query("Select * from quote")
    suspend fun getQuote() : List<Result>

    @Delete
    suspend fun deleteQuote(quote: Result)

    @Insert
    suspend fun addQuote(quotes : MyQuotes)

    @Query("Select * from myquote")
    suspend fun getMyQuote() : List<MyQuotes>

    @Delete
    suspend fun deleteQuote(quote: MyQuotes)

}