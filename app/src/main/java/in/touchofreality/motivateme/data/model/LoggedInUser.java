package in.touchofreality.motivateme.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String displayName;
    private String accessToken;

    public LoggedInUser(String displayName, String accessToken) {
        this.displayName = displayName;
        this.accessToken = accessToken;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAccessToken() { return accessToken; }
}
