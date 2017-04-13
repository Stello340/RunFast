package sonogiapponese.runfast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ElencoSessioni extends MainActivity {
    String[] listviewTitle = new String[]{
            "ListView Title 1", "ListView Title 2", "ListView Title 3", "ListView Title 4",
            "ListView Title 5", "ListView Title 6", "ListView Title 7", "ListView Title 8"
    };
    int listviewImage = R.drawable.run50x50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elenco_sessioni);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hmSessioni = new HashMap<String, String>();
            hmSessioni.put("listview_title", listviewTitle[i]);
            hmSessioni.put("listview_image", Integer.toString(listviewImage));
            aList.add(hmSessioni);
        }

        String[] from = {"listview_image", "listview_title"};
        int[] to = {R.id.imageList, R.id.textList};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.element_session_list, from, to);
        ListView androidListView = (ListView) findViewById(R.id.listaSessioni);
        androidListView.setAdapter(simpleAdapter);

        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView < ? > adapter, View view,int position, long arg){
                // TODO Auto-generated method stub
                Intent openDettaglioSessione = new Intent(ElencoSessioni.this, DettaglioSessione.class);
                startActivity(openDettaglioSessione);
            }
        });
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
