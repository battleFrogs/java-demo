package object.application;

public class StringTest {

    public static void main(String[] args) {

        // s1引用了【堆】中存放地址
        // 而s2虽然拿的的是同一个hello【常量池】地方，但是它是直接引用【方法区】的地址
        String s1 = new String("hello");
        String s2 = "hello";
        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//true

        // s2+s3 是地址的拼接合成，当然不等同于s4
        // s4 会等同于两个字符串拼接 ，找到常量池存在，直接引用，所以等同相同
        String s3 = "world";
        String s4 = "helloworld";
        System.out.println(s4 = s2 + s3);//false
        System.out.println(s4 = "hello" + "world");//true
    }

}
