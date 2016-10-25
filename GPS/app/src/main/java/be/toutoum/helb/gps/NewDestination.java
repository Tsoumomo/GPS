package be.toutoum.helb.gps;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class NewDestination extends AppCompatActivity  {
    private Button scan_btn;
    public String reponse =  "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_destination);
        scan_btn = (Button) findViewById(R.id.bQRCode);
        final Activity activity = this;

        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    IntentIntegrator integrator = new IntentIntegrator(activity);
                    integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                    integrator.setPrompt("Scan");
                    integrator.setCameraId(0);
                    integrator.setBeepEnabled(false);
                    integrator.setBarcodeImageEnabled(false);
                    integrator.initiateScan();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if (result.getContents()==null){
                Toast.makeText(this, "Scan annulé", Toast.LENGTH_LONG).show();
            }
            else{
                reponse = "" + result.getContents();
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();

                new Handler().postDelayed(new Runnable(){
                    public void run(){
                        Intent i = new Intent(getApplicationContext(),QRCodeActivity.class);
                        i.putExtra("reponse", reponse);
                        startActivity(i);

                        //Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        //        Uri.parse(reponse));
                        //startActivity(intent);
                    }
                }, 2000); //2000 is time delayed in millseconds
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void intentAddress (View v){
        Intent i = new Intent(this,NewAdress.class);
        startActivity(i);
    }

    public void intentMenu (View v){
        Intent i = new Intent(this,HomeActivity.class);
        startActivity(i);
    }
}
