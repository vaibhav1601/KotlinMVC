package comp.kwork.moapplication.di

import comp.kwork.moapplication.data.model.DbHelper
import comp.kwork.moapplication.api.Api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    @Singleton

    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("BuildConfig.BASE_URL")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun geiListApi(retrofit: Retrofit): Api =
        retrofit.create(Api::class.java)



    @Provides
    @Singleton
    fun provideApiHelper(dbHelper: DbHelper): DbHelper = dbHelper



    /* @Singleton
     @Component(modules = [ReposDataModel::class])
     interface ApplicationComponent {
         fun inject(activity: MainActivity)
     }
 */


}


