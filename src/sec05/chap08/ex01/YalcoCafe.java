package sec05.chap08.ex01;

public class YalcoCafe extends YalcoGroup {
    public static String getCreed () {
        return CREED.formatted("원두향은");
    }
    protected static int lastNo = 0;

    private boolean isTakeout;

    public YalcoCafe(String name, boolean isTakeout) {
        super(++lastNo, name);
        this.isTakeout = isTakeout;
    }

    //  💡 반드시 구현 - 제거해 볼 것

    @Override
    public void takeOrder() {

    }
}