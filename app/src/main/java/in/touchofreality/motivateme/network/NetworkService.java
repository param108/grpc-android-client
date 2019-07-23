package in.touchofreality.motivateme.network;

import in.touchofreality.motivateme.data.Result;
import in.touchofreality.motivateme.data.model.LoggedInUser;

public interface NetworkService {
    public Result<LoggedInUser> Login(String username, String password);
    public Result<LoggedInUser> UpdateFirebaseToken (String accessToken, String firebaseToken);
}
