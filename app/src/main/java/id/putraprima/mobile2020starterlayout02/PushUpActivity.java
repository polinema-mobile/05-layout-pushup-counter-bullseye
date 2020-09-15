package id.putraprima.mobile2020starterlayout02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PushUpActivity extends AppCompatActivity {

    private int counterPush = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_up);
        // Mengeset nilai counter ke 0 saat activity;
        TextView textcounter = (TextView) findViewById(R.id.txtCounter);
        textcounter.setText("0");
    }

    public void toMainMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void pushClick(View view){
        counterPush += 1;
        TextView textcounter = (TextView) findViewById(R.id.txtCounter);
        textcounter.setText(""+counterPush);
    }
}