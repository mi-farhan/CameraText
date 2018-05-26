package example.com.cameratext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class translate extends AppCompatActivity {
    public EditText editText;
    public TextView textView;
    public Button button;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("name");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        editText=(EditText)findViewById(R.id.textName);
        textView=(TextView)findViewById(R.id.translatedText);
        button=(Button)findViewById(R.id.btn);
        String text=editText.getText().toString().trim();
        Log.d("edit text",text);

        button.setOnClickListener(new View.OnClickListener() {
            String name=editText.getText().toString().trim();
            @Override
            public void onClick(View view) {
                myRef.push().setValue("HEllo");
                if (myRef.setValue(name).isSuccessful()){
                    Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
                    textView.setText(name);
                }

            }
        });

    }


}
