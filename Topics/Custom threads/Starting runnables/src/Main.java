class Starter {

    public static void startRunnables(Runnable[] runnables) {
        // implement the method
        for (Runnable runnable : runnables){
            Thread temp = new Thread(runnable);
            temp.start();
        }
    }
}