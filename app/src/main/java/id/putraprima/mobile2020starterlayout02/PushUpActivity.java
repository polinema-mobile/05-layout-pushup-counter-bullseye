package id.putraprima.mobile2020starterlayout02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PushUpActivity extends AppCompatActivity implements SensorEventListener {

    // Set Sensitivitas sensor pada HP.
    private static final int SENSOR_SENSITIVITY = 5;
    private int counterPush = 0;
    private SensorManager mSensorManager;
    private Sensor mProximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_up);
        // Mengeset nilai counter ke 0 saat activity nomer 13
        TextView textcounter = (TextView) findViewById(R.id.txtCounter);
        textcounter.setText("0");

        // PROXIMITY
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    // Activity Resume: Sensor akan dijalankan lagi dengan delay normal
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    // Activity Pause: Sensor akan dihentikan dahulu
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    // Method menambah counter jika klik button
    public void pushClick(View view){
        counterPush += 1;
        TextView textcounter = (TextView) findViewById(R.id.txtCounter);
        textcounter.setText(""+counterPush);
    }

    // Method menggunakan sensor PROXIMITY untuk menambahkan counter
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (event.values[0] >= -SENSOR_SENSITIVITY && event.values[0] <= SENSOR_SENSITIVITY) {
                // near
                counterPush += 1;
                TextView textcounter = (TextView) findViewById(R.id.txtCounter);
                textcounter.setText(""+counterPush);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {}

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {}
}