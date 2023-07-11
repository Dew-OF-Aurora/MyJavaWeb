package com.aurora.service.jdkproxy;

/**
 * @author:Aurora
 * @create: 2023-01-04 21:21
 * @Description:
 */
public class OrderServiceImpl implements OrderService{
    @Override
    public int buy() {
        System.out.println("正在购买");
        return 1;
    }
}
