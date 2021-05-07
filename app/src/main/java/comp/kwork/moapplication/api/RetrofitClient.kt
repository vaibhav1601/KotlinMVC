import android.os.Handler
import android.os.Message
import android.util.Base64


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


object RetrofitClient {
    private const val BASE_URL = "BuildConfig.BASE_URL"

    var okHttpClient = OkHttpClient.Builder()
        .addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response? {
                val original = chain.request()

                val requestBuilder = original.newBuilder()
                    //.addHeader("Authorization", "Basic UmVjaGFyZ2U6UmVjaGFyZ2Ux")
                    .method(original.method(), original.body())

                val request = requestBuilder.build()
                val response: Response = chain.proceed(request)


                if (response.code() == 500 || response.code() == 503 ||  response.code() == 404) {

                    object : Thread() {
                        override fun run() {
                            /*Handler().postDelayed(Runnable {
                                Utility.utilToast("No response from server")
                            }, 200)*/
                            /*msg.arg1 = 1
                            handler.sendMessage(msg)*/
                        }
                    }.start()

                    /*Handler().postDelayed(Runnable {
                        Utility.utilToast("No response from server")
                    }, 200)*/

                    return response
                } else {
                    return response
                }
            }
        })
        .connectTimeout(100, TimeUnit.SECONDS)
        .writeTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .build()


    /*val instance: Api by lazy{
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        retrofit.create(Api::class.java)
    }*/


    var handler = Handler(Handler.Callback { msg ->
        if (msg.arg1 == 1) {
            //Print Toast or open dialog
            //Utility.utilToast("No response from server")
        }
        false
    })

}