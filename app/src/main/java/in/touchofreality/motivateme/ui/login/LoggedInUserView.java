package in.touchofreality.motivateme.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    private String accessToken;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName, String accessToken) {
        this.displayName = displayName;
        this.accessToken = accessToken;
    }

    String getAccessToken() {
        return accessToken;
    }
    String getDisplayName() {
        return displayName;
    }
}
