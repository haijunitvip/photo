package test.demo;

/**
 * @author ghj
 * @Description
 * @date 2020/4/1 10:19
 */
public abstract class AbstractDemo {
    public abstract void run();

    public void get() {
        System.out.println("非抽象方法");
    }

    class Sun extends AbstractDemo {

        @Override
        public void run() {
            System.out.println("实现..");
        }
    }
    interface inDome{
        void run();
        //不能有方法实现
        public void get();
    }
}
