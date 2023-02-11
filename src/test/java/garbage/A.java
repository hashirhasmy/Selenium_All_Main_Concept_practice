package garbage;

public class A {

    public void a(){
        System.out.println("a");
    }

    public A aA(){
        System.out.println("aA");
        return this;
    }

    public B aB(){
        System.out.println("aB");
        return new B();
    }

    public C aC(){
        System.out.println("aC");
        return new C();
    }


}
