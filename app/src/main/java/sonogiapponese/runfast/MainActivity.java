package sonogiapponese.runfast;

import android.app.Dialog;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ImageButton start;
    private ImageButton stop;
    private Chronometer chrono;
    private TextView distanza;
    private Button elencoSessioni;
    private Button reset;
    private Button save;
    private Date date = new Date();
    private Dialog dialog;
    private long lastPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (ImageButton) findViewById(R.id.start);
        stop = (ImageButton) findViewById(R.id.stop);
        chrono = (Chronometer) findViewById(R.id.tempo);
        distanza = (TextView) findViewById(R.id.distanza);
        elencoSessioni = (Button) findViewById(R.id.elenco_sessioni);
        reset = (Button) findViewById(R.id.azzera);
        save = (Button) findViewById(R.id.salva);
        lastPause = SystemClock.elapsedRealtime();
    }

    public void startChronometer(View view) {
        start.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.VISIBLE);
        elencoSessioni.setVisibility(View.INVISIBLE);
        reset.setVisibility(View.INVISIBLE);
        save.setVisibility(View.INVISIBLE);
        chrono.setBase(chrono.getBase() + SystemClock.elapsedRealtime() - lastPause);
        chrono.start();
    }
    public void stopChronometer(View view) {
        stop.setVisibility(View.INVISIBLE);
        start.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);
        save.setVisibility(View.VISIBLE);
        chrono.stop();
        lastPause = SystemClock.elapsedRealtime();
    }
    public void resetChronometer(View view) {
        elencoSessioni.setVisibility(View.VISIBLE);
        reset.setVisibility(View.INVISIBLE);
        save.setVisibility(View.INVISIBLE);
        chrono.setBase(SystemClock.elapsedRealtime());
        lastPause = SystemClock.elapsedRealtime();
    }

    public void mostraConfermaSalvataggio(View view) {
        stop.setVisibility(View.INVISIBLE);
        start.setVisibility(View.VISIBLE);
        elencoSessioni.setVisibility(View.VISIBLE);
        reset.setVisibility(View.INVISIBLE);
        save.setVisibility(View.INVISIBLE);
        chrono.setBase(SystemClock.elapsedRealtime());
        lastPause = SystemClock.elapsedRealtime();
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_salva_sessione_corrente);
        dialog.setTitle(DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ITALY).format(date));
        dialog.show();
    }
    public void saveOk(View view) {
        /*
        salva tempo e distanza della sessione corrente nell'internal storage
         */
        dialog.dismiss();
    }

    public void elencoSessioni(View view) {
        Intent openElencoSessioni = new Intent(MainActivity.this, ElencoSessioni.class);
        startActivity(openElencoSessioni);
    }
}
