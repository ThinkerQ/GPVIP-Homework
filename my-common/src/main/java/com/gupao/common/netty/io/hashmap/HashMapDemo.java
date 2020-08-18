package com.gupao.common.netty.io.hashmap;

import java.util.HashMap;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/14
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Study study = new Study();
        study.setName("张三");
        HashMap<Object, String> map = new HashMap<>();
        map.put(study,"1212");
//        study.setName("2222");
        System.out.println("====end");
        String a = map.get(study);
        System.out.println(a);

        String name = "理论上散列值是一个int型，如果直接拿散列值作为下标访问HashMap主数组的话，考虑到2进制32位带符号的int表值范围从-2147483648到2147483648";

        System.out.println(name.hashCode());
        int h;
        System.out.println((h = name.hashCode()) ^ (h >>> 16));
    }
}
