package tjuri.example.com.converter;


import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;


public interface ITecaj {

    public static final String ENDPOINT_URL = "http://hnbex.eu";

    @GET("/api/v1/rates/daily/")
    void tecajevi (@Query("date") String datum, Callback< List< Tecaj > > call );
}