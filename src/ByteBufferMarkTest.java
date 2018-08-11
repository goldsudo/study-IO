import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 这个类借助ByteBuffer的get方法put方法，以及mark方法，reset方法来实现将一个字符串的相邻字符顺序调换
 * 例如 abcde 调换后为 badce
 */
public class ByteBufferMarkTest {
    public static void change(CharBuffer cb) {
        while (cb.hasRemaining()) {
            cb.mark();
            char c1 = cb.get();
            if(!cb.hasRemaining()){
                return;
            }
            char c2 = cb.get();
            cb.reset();
            cb.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] datas = "abcdefg".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(datas.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(datas);
        cb.flip();
        while (cb.hasRemaining()) {
            System.out.print(cb.get());
        }
        System.out.println();
        cb.flip();
        change(cb);
        cb.flip();
        while (cb.hasRemaining()) {
            System.out.print(cb.get());
        }
        System.out.println();
        cb.flip();
        change(cb);
        cb.flip();
        while (cb.hasRemaining()) {
            System.out.print(cb.get());
        }
    }
}
