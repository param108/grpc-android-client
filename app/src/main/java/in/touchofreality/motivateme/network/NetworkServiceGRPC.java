package in.touchofreality.motivateme.network;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import in.touchofreality.motivateme.ChatGrpc;
import in.touchofreality.motivateme.ChatOuterClass;
import in.touchofreality.motivateme.config.GRPCNetworkConfig;
import in.touchofreality.motivateme.data.Result;
import in.touchofreality.motivateme.data.model.LoggedInUser;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class NetworkServiceGRPC implements NetworkService {

    private static NetworkServiceGRPC instance = null;
    private GRPCNetworkConfig config;
    private ManagedChannel managedChannel;
    private NetworkServiceGRPC(GRPCNetworkConfig config) {
        this.config = config;
        managedChannel = ManagedChannelBuilder.forAddress(config.GRPCHost, Integer.parseInt(config.GRPCHost,10)).build();
    }

    public static NetworkService getInstance(GRPCNetworkConfig config) {
        if (instance == null) {
            instance = new NetworkServiceGRPC(config);
        }
        return instance;
    }

    @Override
    public Result<LoggedInUser> Login(String username, String password) {
        ChatOuterClass.LoginRequest loginRequest = ChatOuterClass.LoginRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .build()
                ;
        ChatOuterClass.LoginResponse loginResponse = ChatGrpc.newBlockingStub(managedChannel).login(loginRequest);
        if (loginResponse.getSuccess()) {
            LoggedInUser loggedInUser = new LoggedInUser(username, loginResponse.getUserToken());
            return new Result.Success<LoggedInUser>(loggedInUser);
        } else {
            return new Result.Error(new IOException(loginResponse.getError()));
        }
        // return null;
    }

    @Override
    public Result<LoggedInUser> UpdateFirebaseToken(String accessToken, String firebaseToken) {
        return null;
    }
}
