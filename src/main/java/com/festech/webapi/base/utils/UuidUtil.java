package com.festech.webapi.base.utils;

import java.util.UUID;

public class UuidUtil {


    public static String getUuid() {

        return UUID.randomUUID().toString().replace("-", "");

    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {

            System.out.println(UuidUtil.getUuid());
        }

    }

}
