package dad.hipoteca.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HipotecaInterface {

    // localhost:3000/hipoteca?capital=1000&intereses=5&años=2
    @GET("search.json")
    Call<HipotecaApi> search(@Query("capital") String query, @Query("intereses") String query2, @Query("años") String query3);

}
