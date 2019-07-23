package in.touchofreality.motivateme.pushmessaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import in.touchofreality.motivateme.config.Config;
import in.touchofreality.motivateme.config.propertyfile.PropertyFileConfig;
import in.touchofreality.motivateme.network.NetworkService;
import in.touchofreality.motivateme.network.NetworkServiceGRPC;

public class PushMessagingService extends FirebaseMessagingService {
    String TAG = "PushMessagingService";
    private LocalBroadcastManager broadcaster;
    private Config config;
    private NetworkService networkService;
    public PushMessagingService() {
        config = PropertyFileConfig.getInstance(getApplicationContext());
        networkService = NetworkServiceGRPC.getInstance(config.getGRPCNetworkConfig());
    }

    @Override
    public void onNewToken(String token) {
    }



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

}
