package in.touchofreality.motivateme.ui.thought;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import in.touchofreality.motivateme.R;
import in.touchofreality.motivateme.config.Config;
import in.touchofreality.motivateme.config.propertyfile.PropertyFileConfig;
import in.touchofreality.motivateme.network.NetworkService;
import in.touchofreality.motivateme.network.NetworkServiceGRPC;

public class MainActivity extends AppCompatActivity {

    private Config appConfig;
    private NetworkService networkService;

    private void setupDependencies() {
        appConfig = PropertyFileConfig.getInstance(getApplicationContext());
        networkService = NetworkServiceGRPC.getInstance(appConfig.getGRPCNetworkConfig());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupDependencies();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
