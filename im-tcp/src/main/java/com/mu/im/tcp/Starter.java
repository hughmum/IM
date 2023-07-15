package com.mu.im.tcp;

import com.mu.im.codec.config.BootstrapConfig;
import com.mu.im.tcp.reciver.MessageReciver;
import com.mu.im.tcp.redis.RedisManager;
import com.mu.im.tcp.register.RegistryZK;
import com.mu.im.tcp.register.ZKit;
import com.mu.im.tcp.server.ImServer;
import com.mu.im.tcp.server.ImWebSocketServer;
import com.mu.im.tcp.utils.MqFactory;
import org.I0Itec.zkclient.ZkClient;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Mr.yuan
 * Date: 2023-07-06 17:35
 * version: 1.0
 */
public class Starter {
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length > 0){
            start(args[0]);
        }
    }

    private static void start(String path){
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(path);
            BootstrapConfig bootstrapConfig = yaml.loadAs(inputStream, BootstrapConfig.class);

            new ImServer(bootstrapConfig.getIm()).start();
            new ImWebSocketServer(bootstrapConfig.getIm()).start();

            RedisManager.init(bootstrapConfig);
            MqFactory.init(bootstrapConfig.getIm().getRabbitmq());
            MessageReciver.init();
            registerZK(bootstrapConfig);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(500);
        }
    }

    public static void registerZK(BootstrapConfig config) throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        ZkClient zkClient = new ZkClient(config.getIm().getZkConfig().getZkAddr(),
                config.getIm().getZkConfig().getZkConnectTimeOut());
        ZKit zKit = new ZKit(zkClient);
        RegistryZK registryZK = new RegistryZK(zKit, hostAddress, config.getIm());
        Thread thread = new Thread(registryZK);
        thread.start();

    }
}
