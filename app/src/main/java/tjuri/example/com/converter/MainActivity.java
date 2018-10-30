package tjuri.example.com.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;


import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {


    Spinner spFrom;
    Spinner spTo;
    Button btnConvert;
    TextView tvResult;
    //private Callback< List < Tecaj > > callback;
    private ITecaj iTecajevi;
    private Callback<List<Tecaj>> callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRestAdapter();
    }

    public void getRates(View view) {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
        iTecajevi.tecajevi(formattedDate, callback);
    }



    private void setupRestAdapter() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ITecaj.ENDPOINT_URL)
                .build();
        iTecajevi = restAdapter.create(ITecaj.class);
        callback = new Callback<List<Tecaj>>() {
            @Override
            public void success(List<Tecaj> tecajevi, Response response) {
                StringBuilder text = new StringBuilder("[");
                Iterator<Tecaj> it = tecajevi.iterator();
                text.append("'" + it.next().getCurrencyCode() + "'");
                while (it.hasNext())
                    text.append(", '" + it.next().getCurrencyCode() + "'");
                text.append("]");

                Toast.makeText(getApplicationContext(), text.toString(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        };
    }

    public void initWidgets() {
        spFrom = findViewById(R.id.spFrom);
        spTo = findViewById(R.id.spTo);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);
    }
}
