package in.touchofreality.motivateme.data;

import in.touchofreality.motivateme.data.model.LoggedInUser;
import in.touchofreality.motivateme.network.NetworkService;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private NetworkService mNetworkService;
    public LoginDataSource(NetworkService networkService) {
        mNetworkService = networkService;
    }

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            return mNetworkService.Login(username,password);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
