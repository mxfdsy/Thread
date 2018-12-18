package Atomic;

import java.util.concurrent.atomic.AtomicReference;

public class UseAtomicReference {

    static AtomicReference<UserInfo> useRef = new AtomicReference<>();

    //定义一个实体类
    static class UserInfo {
        private String name;
        private int age;
        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        UserInfo user = new UserInfo("cww", 19);
        useRef.set(user);

        UserInfo updateUser = new UserInfo("chengww", 18);
        useRef.compareAndSet(user, updateUser);
        System.out.println(useRef.get().getName());
        System.out.println(useRef.get().getAge());
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }
}
