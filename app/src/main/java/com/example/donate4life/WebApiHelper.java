package com.example.donate4life;

import android.content.Context;
import android.preference.PreferenceManager;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class WebApiHelper {

    private static final WebApiHelper ourInstance = new WebApiHelper();

    public static WebApiHelper getInstance() {
        return ourInstance;
    }

    private WebApiHelper() {
    }

    WebApi webApi = null;

    public void init(final Context context) {


        class MyInterceptor implements Interceptor {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                HashSet<String> preferences = (HashSet<String>) PreferenceManager.getDefaultSharedPreferences(context).getStringSet("Cookies", new HashSet<String>());
                for (String cookie : preferences) {
                    builder.addHeader("Cookies", cookie);
                }

                return chain.proceed(builder.build());
            }
        }
        class ReceivedCookiesInterceptor implements Interceptor {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());

                if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                    HashSet<String> cookies = new HashSet<>();

                    for (String header : originalResponse.headers("Set-Cookie")) {
                        cookies.add(header);
                    }

                    PreferenceManager.getDefaultSharedPreferences(context).edit()
                            .putStringSet("Cookies", cookies)
                            .apply();
                }

                return originalResponse;
            }
        }


        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(new MyInterceptor());
        client.addInterceptor(new ReceivedCookiesInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://att-world-media.herokuapp.com/master/")
                .baseUrl("http://192.168.137.30:80/")
//                .baseUrl("https://att1111.herokuapp.com/master/")
                .client(client.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webApi = retrofit.create(WebApi.class);
    }

    public void login(Callback<LoginResponse> responseCallback, String name, String password) {
        try {

            if (webApi != null) {
                Call<LoginResponse> call = webApi.userLogin(name, password);
                call.enqueue(responseCallback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
