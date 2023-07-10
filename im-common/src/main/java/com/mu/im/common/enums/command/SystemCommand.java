package com.mu.im.common.enums.command;

/**
 * @author Mr.yuan
 * Date: 2023-07-10 9:27
 * version: 1.0
 */
public enum SystemCommand implements Command{

    /**
     * 登录 9000
     */
    LOGIN(0x2328),

    ;

    private int command;

    SystemCommand(int command){
        this.command=command;
    }


    @Override
    public int getCommand() {
        return command;
    }

}
