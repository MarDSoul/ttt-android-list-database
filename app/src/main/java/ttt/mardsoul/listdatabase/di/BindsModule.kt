package ttt.mardsoul.listdatabase.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ttt.mardsoul.listdatabase.data.ItemRepositoryImpl
import ttt.mardsoul.listdatabase.domain.ItemRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsModule {
    @Binds
    @Singleton
    abstract fun bindRepository(repository: ItemRepositoryImpl): ItemRepository
}