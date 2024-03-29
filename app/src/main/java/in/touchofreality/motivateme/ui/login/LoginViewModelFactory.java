package in.touchofreality.motivateme.ui.login;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import in.touchofreality.motivateme.config.GRPCNetworkConfig;
import in.touchofreality.motivateme.config.propertyfile.PropertyFileConfig;
import in.touchofreality.motivateme.data.LoginDataSource;
import in.touchofreality.motivateme.data.LoginRepository;
import in.touchofreality.motivateme.network.NetworkServiceGRPC;

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
public class LoginViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(LoginRepository.getInstance(
                    new LoginDataSource(NetworkServiceGRPC.getInstance(
                            PropertyFileConfig.getInstance(null).
                                    getGRPCNetworkConfig()))));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
