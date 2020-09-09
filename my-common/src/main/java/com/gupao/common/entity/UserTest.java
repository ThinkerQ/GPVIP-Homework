package com.gupao.common.entity;

import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 用户实体类
 */
@ToString
public class UserTest {

    private Integer id; // ID，数据库自增
    private String name; //
    private Integer gender; //
    private String phone; //


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public UserTest(String name,String phone){
        this.name = name;
        this.phone = phone;
    }
    public static void main(String[] args) {
        testLoop();
//       testListRemove();
    }

    private static void testListRemove() {
        ArrayList<UserTest> list = new ArrayList<>();
        list.add(new UserTest("1","1231222"));
        list.add(new UserTest("2","1231222"));

        for (UserTest user:list) {
            if("2".equals(user.getName())){
                list.remove(user);
            }
        }
        System.out.println("====end");
    }

    private static void testLoop() {
        LinkedList<UserTest> linkedList = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            linkedList.add(new UserTest(""+i,"king"+i));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        for (UserTest user:linkedList) {


        }
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.get(10));
    }
}
