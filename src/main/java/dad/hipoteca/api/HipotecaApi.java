package dad.hipoteca.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HipotecaApi {
    private static final String BASE_URL = "http://localhost:3000/";

    private final HipotecaInterface service;

    public HipotecaApi() {

        ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(pool)
                .build();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        service = retrofit.create(HipotecaInterface.class);

    }

    public HipotecaResult getCuotas(Double capital, Double intereses, Integer plazos) throws IOException {
        Response<HipotecaResult> response = service.search(capital, intereses,plazos).execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }

}


