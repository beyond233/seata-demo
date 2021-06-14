package com.beyond233.seata.demo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * description:
 *
 * @author beyond233
 * @since 2021/6/6 10:49
 */
public class ComputeIfAbsentTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap(8);
        Num n1 = new Num(3);
        Num n2 = new Num(19);
        Num n3 = new Num(20);

//     map.computeIfAbsent(n1, k1 -> map.computeIfAbsent(n3, k2 -> 200));     // 这行代码不会导致程序死循环
        map.computeIfAbsent(n1, k1 -> map.computeIfAbsent(n2, k2 -> 200));      // 这行代码会导致程序死循环
    }

    static class Num{
        private int i;
        public Num(int i){
            this.i = i;
        }

        @Override
        public int hashCode() {
            return i;
        }
    }
}
