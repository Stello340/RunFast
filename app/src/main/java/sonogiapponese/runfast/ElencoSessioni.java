package sonogiapponese.runfast;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.ListView;

public class ElencoSessioni extends MainActivity {
    String[] sessionArray = new String[] { "Product1", "Product2", "Product3" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elenco_sessioni);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] citta = new String[]{"Torino","Roma","Milano","Napoli","Firenze"};
        Integer[] image = {R.drawable.run50x50, R.drawable.run50x50, R.drawable.run50x50, R.drawable.run50x50, R.drawable.run50x50};
        CustomList adapter = new CustomList(this, citta, image);
        ListView list = (ListView)findViewById(R.id.listaSessioni);
        list.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
