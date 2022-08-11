package com.example.shoppinglist.di

import android.content.Context
import androidx.room.Room
import com.example.shoppinglist.data.local.ShoppingDatabase
import com.example.shoppinglist.data.local.dao.ShoppingDao
import com.example.shoppinglist.repository.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesShoppingDatabase(
        @ApplicationContext context: Context
    ): ShoppingDatabase =
        Room.databaseBuilder(context, ShoppingDatabase::class.java, "ShoppingDB").build()

    @Singleton
    @Provides
    fun providesShoppingDoa(db: ShoppingDatabase): ShoppingDao {
        return db.getShoppingDao()
    }
}