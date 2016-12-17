package gr.hua.dit.android.dbexampleclient;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ContentResolver resolver = this.getContentResolver();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://gr.hua.dit.android.dbexample/contacts/1");
                Cursor cursor = resolver.query(uri,null,null,null,null);
                if (cursor.moveToFirst()){
                    String name = cursor.getString(1);
                    String phone = cursor.getString(2);
                    Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),phone,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
