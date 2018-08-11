import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 测试缓冲区溢出的问题
 */
public class ByteBufferFullTest {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(16);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{1, 2, 3, 4});
        System.out.println("当前limit：" + ib.limit());
        System.out.println("当前position:" + ib.position());
        System.out.println("总容量:" + ib.capacity());
//        ib.rewind();
//        System.out.println("rewind()后，当前limit：" + ib.limit());
//        System.out.println("rewind()后，当前position:" + ib.position());
//        System.out.println("总容量:" + ib.capacity());

        //这里睡眠100ms的原因是为了让err流先等到上面的out流输出完毕
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //容量只有4字节，如果继续put，那么会报错，除非先执行rewind或者flip，可以从头开始写
        ib.put(5);
        System.out.println("当前limit：" + ib.limit());
        System.out.println("当前position:" + ib.position());
        System.out.println("总容量:" + ib.capacity());
        ib.rewind();
        int count = 1;
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println("第" + count++ + "ib.get():" + i);
        }
    }
}
