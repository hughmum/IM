package com.mu.im.tcp.register;

import com.mu.im.common.constants.Constants;
import org.I0Itec.zkclient.ZkClient;

/**
 * @author Mr.yuan
 * Date: 2023-07-14 17:01
 * version: 1.0
 */
public class ZKit {

    private ZkClient zkClient;

    public ZKit(ZkClient zkClient) {
        this.zkClient = zkClient;
    }

    //根据zkClient初始化节点
    //im-coreRoot/tcp/ip:port
    public void createRootNode() {
        //判断父节点是否存在
        boolean exists = zkClient.exists(Constants.ImCoreZkRoot);
        if(!exists){
            zkClient.createPersistent(Constants.ImCoreZkRoot);
        }
        boolean tcpExists = zkClient.exists(Constants.ImCoreZkRoot +
                Constants.ImCoreZkRootTcp);
        if(!tcpExists){
            zkClient.createPersistent(Constants.ImCoreZkRoot +
                    Constants.ImCoreZkRootTcp);
        }
        boolean webExists = zkClient.exists(Constants.ImCoreZkRoot +
                Constants.ImCoreZkRootWeb);
        if(!webExists){
            zkClient.createPersistent(Constants.ImCoreZkRoot +
                    Constants.ImCoreZkRootWeb);
        }

    }

    //ip+port
    public void createNode(String path){
        if(!zkClient.exists(path)){
            zkClient.createPersistent(path);
        }
    }

}
