import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 测试buffer中的get,flip,rewind方法，以及limit,position,capacity属性
 */
public class ByteBufferFlipTest {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        System.out.println("当前limit：" + ib.limit());
        System.out.println("当前position:" + ib.position());
        System.out.println("总容量:" + ib.capacity());
        System.out.println("ib.get(3)" + ib.get(3));
        System.out.println("ib.get(3)后，当前limit：" + ib.limit());
        System.out.println("ib.get(3)后，当前position:" + ib.position());
        System.out.println("ib.get(3)后，总容量:" + ib.capacity());
        ib.put(new int[]{3, 1811});
        System.out.println("ib.put({3,1811})后，当前limit：" + ib.limit());
        System.out.println("ib.put({3,1811})后，当前position:" + ib.position());
        System.out.println("ib.put({3,1811})后，总容量:" + ib.capacity());
        ib.flip();
        System.out.println("ib.flip()后，当前limit：" + ib.limit());
        System.out.println("ib.flip()后，当前position:" + ib.position());
        System.out.println("ib.flip()后，总容量:" + ib.capacity());
        ib.rewind();
        System.out.println("ib.rewind()后，当前limit：" + ib.limit());
        System.out.println("ib.rewind()后，当前position:" + ib.position());
        System.out.println("ib.rewind()后，总容量:" + ib.capacity());
        int count = 1;
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println("第" + count++ + "次ib.get():" + i);
        }
    }
}
