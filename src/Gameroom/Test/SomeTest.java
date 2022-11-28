package Gameroom.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class RoomManager{
    private static List roomList; // ���� ����Ʈ
    private static AtomicInteger atomicInteger;
    static {
        roomList = new ArrayList();
        atomicInteger = new AtomicInteger();
    }
    public static int createRoom() { // ���� ���� ����(�� ��)
        int roomId = atomicInteger.incrementAndGet();// room id ä��
        System.out.println("Room Created! : " + roomId);
        return roomId;
    }
}

public class SomeTest {
    public static void main(String[] args) {
        System.out.println(RoomManager.createRoom());
        System.out.println(RoomManager.createRoom());

        Thread thread = new Thread(() -> System.out.println(RoomManager.createRoom()));
        Thread thread2 = new Thread(() -> System.out.println(RoomManager.createRoom()));
        Thread thread3 = new Thread(() -> System.out.println(RoomManager.createRoom()));
        thread.start();
        thread2.start();
        thread3.start();
    }
}

/*
 * // result Room Created! : 1 1 Room Created! : 2 2 Room Created! : 3 3 Room
 * Created! : 4 4 Room Created! : 5 5
 */