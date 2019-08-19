package in.touchofreality.motivateme.config.propertyfile;

import android.content.Context;

import java.io.IOException;
import java.util.Properties;

import in.touchofreality.motivateme.config.Config;
import in.touchofreality.motivateme.config.GRPCNetworkConfig;

public class PropertyFileConfig implements Config {

    public static PropertyFileConfig instance = null;
    Context context;
    GRPCNetworkConfig grpcNetworkConfig;

    public static PropertyFileConfig getInstance(Context context) {
        if (instance == null && context != null) {
            instance = new PropertyFileConfig(context);
        }
        return instance;
    }

    private PropertyFileConfig(Context context) {
        this.context = context;
        readGRPCNetworkConfig();
    }

    private void readGRPCNetworkConfig() {
        Properties properties = new Properties();
        try {
            properties.load(context.getAssets().open("config/grpc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        grpcNetworkConfig = new GRPCNetworkConfig();
        grpcNetworkConfig.GRPCHost = properties.getProperty("host");
        grpcNetworkConfig.GRPCPort = properties.getProperty("port");
    }

    @Override
    public GRPCNetworkConfig getGRPCNetworkConfig() {
        return grpcNetworkConfig;
    }
}
