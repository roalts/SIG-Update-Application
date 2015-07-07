package com.ieeedtu.sigupdate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Sig> sigList = new ArrayList<>();
    private Sig oss = new Sig(), embedded = new Sig(), programming = new Sig();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeList(oss, "OSS SIG", "5:00 - 7:00", "Android Development", "Smart Class Room");
        initializeList(embedded, "Embedded Systems", "5:00 - 7:00", "Arduino", "TW1GF4");
        initializeList(programming, "Programming SIG", "5:00 - 7:00", "Trees", "TW1GF3");

        sigList.add(oss);
        sigList.add(embedded);
        sigList.add(programming);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);

        SigAdapter adapter = new SigAdapter(sigList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initializeList(Sig sig, String name, String time, String topic, String room) {
        sig.setName(name);
        sig.setTime(time);
        sig.setTopic(topic);
        sig.setRoom(room);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
