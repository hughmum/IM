package com.mu.im.service.user.model.resp;

import lombok.Data;

import java.util.List;

/**
 * @author Mr.yuan
 * Date: 2023-07-03 10:08
 * version: 1.0
 */
@Data
public class ImportUserResp {

    private List<String> successId;

    private List<String> errorId;

}
