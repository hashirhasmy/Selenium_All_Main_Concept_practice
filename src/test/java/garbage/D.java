package garbage;

import org.testng.annotations.Test;

public class D {

    @Test
    public void test1() {
        A x = new A();
        x.aA();
        x.aB();

        B y= new B();
        y.bB();
        y.bC();

        C z= new C();
        z.cC();
    }

    @Test
    public void test2() {
        A x = new A();
        x.aA().aB().bB().bC().cC();

//        B y=x.aA().aB().bB();  -
//
//          1st metthod
//          C z=x.aA().aB().bC().cC();

            /* 2nd method
            C z;
            z=x.aA().aB().bC().cC();
             */
    }

}
