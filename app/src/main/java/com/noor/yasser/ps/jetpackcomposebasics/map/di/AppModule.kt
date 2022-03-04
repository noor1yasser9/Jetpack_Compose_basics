package com.noor.yasser.ps.jetpackcomposebasics.map.di


import android.app.Application
import androidx.room.Room
import com.noor.yasser.ps.jetpackcomposebasics.map.data.ParkingSpotDatabase
import com.noor.yasser.ps.jetpackcomposebasics.map.data.ParkingSpotRepositoryImpl
import com.noor.yasser.ps.jetpackcomposebasics.map.repository.ParkingSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideParkingSpotDatabase(app: Application): ParkingSpotDatabase {
        return Room.databaseBuilder(
            app,
            ParkingSpotDatabase::class.java,
            "parking_spots.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSpotDatabase): ParkingSpotRepository {
        return ParkingSpotRepositoryImpl(db.dao)
    }
}