package dad.hipoteca.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HipotecaInterface {

    // localhost:3000/hipoteca?capital=<capital>&intereses=<intereses>&plazos=<años>
    @GET("hipoteca")
    Call<HipotecaResult> search(@Query("capital") Double capital, @Query("intereses") Double intereses, @Query("plazos") Double plazos);

}
