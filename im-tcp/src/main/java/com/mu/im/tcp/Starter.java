package com.mu.im.tcp;

import com.mu.im.codec.config.BootstrapConfig;
import com.mu.im.tcp.server.ImServer;
import com.mu.im.tcp.server.ImWebSocketServer;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(500);
        }
    }
}
