package org.blackist.cloudq.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    // 远程服务调用失败，重试
    @Retryable(
            value = {RemoteAccessException.class}, // value: 需要重试的异常类型
            maxAttempts = 3, // 重试次数
            backoff = @Backoff(delay = 5000, multiplier = 5) // 重试间隔, 执行者数
    )
    public void call() throws Exception {
        System.out.println("=== Invoke Call method");
        throw new RemoteAccessException("Remote Invocation Exception...");
    }

    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println("=== Final handling..." + e.getMessage());
    }
}
