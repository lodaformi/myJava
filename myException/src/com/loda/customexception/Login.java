package com.loda.customexception;

import java.util.Objects;

public class Login {
    private static String[] names;
    private static String[] passwds;

    static {
        names = new String[]{"tom", "jerry", "mike"};
        passwds = new String[]{"111", "222", "333"};
    }

    public Login() {
    }

    private int findIdx(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Student loginCheck(String name, String passwd) throws StuException {
        int idx = findIdx(name);
        if (idx != -1) {
            String pwd = passwds[idx];
            if (pwd.equals(passwd)) {
                return new Student(name, passwd);
            } else {
                throw new StuException("password error!");
            }
        } else {
            throw new StuException(name + " doesn't exist!");
        }

//        for (String n : names) {
//            //字符串比较
//            if (n.equals(name)) {
//                return new Student(n, passwd);
//            }
//        }
//        throw new StuException("username or password error!");
    }
}
