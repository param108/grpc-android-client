package in.touchofreality.motivateme.network;

import in.touchofreality.motivateme.config.GRPCNetworkConfig;
import in.touchofreality.motivateme.data.Result;
import in.touchofreality.motivateme.data.model.LoggedInUser;

public class NetworkServiceGRPC implements NetworkService {

    private static NetworkServiceGRPC instance = null;
    private GRPCNetworkConfig config;
    private NetworkServiceGRPC(GRPCNetworkConfig config) {
        this.config = config;
    }

    public static NetworkService getInstance(GRPCNetworkConfig config) {
        if (instance == null) {
            instance = new NetworkServiceGRPC(config);
        }
        return instance;
    }

    @Override
    public Result<LoggedInUser> Login(String username, String password) {
        return null;
    }

    @Override
    public Result<LoggedInUser> UpdateFirebaseToken(String accessToken, String firebaseToken) {
        return null;
    }
}
