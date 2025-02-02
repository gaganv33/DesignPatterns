public class Main {
    public static void main(String[] args) {
        Post postProxy = new PostProxy();
        System.out.println(postProxy.getData(1));
        System.out.println(postProxy.getData(0));
        System.out.println(postProxy.getData(3));
        System.out.println(postProxy.getData(4));
        System.out.println(postProxy.getData(100));
        System.out.println(postProxy.getData(4000));
    }
}