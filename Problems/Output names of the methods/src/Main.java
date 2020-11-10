class CreateInstance {

    public static SuperClass create() {

        SuperClass instance = new SuperClass() {
            public void method2(){
                System.out.println("method2");
            }
            @Override
            public void method3() {
                System.out.println("method3");
            }
        };

        /* create an instance of an anonymous class here,
                                 do not forget ; on the end */

        return instance;
    }
//    abstract static class SuperClass {
//
//        public static void method1() { }
//
//        public void method2() { }
//
//        public abstract void method3();
//    }

//    public static void main(String[] args) {
//        CreateInstance.create().method2();
//        CreateInstance.create().method3();
//    }
}