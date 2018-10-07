package alterindonesia.project.com.spkproviderisp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    @GET("index.php")
    Call<List<PaketResponse>> getPaket(
            @Query("nominal") String nominal,
            @Query("domisili") String domisili
    );
}
