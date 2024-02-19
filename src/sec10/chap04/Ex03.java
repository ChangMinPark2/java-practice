package sec10.chap04;

import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        IntStream.rangeClosed(0, 4)
                .forEach(Ex03::ceo);
    }
    //  💡 IDE의 안내에 따라 직접 작성해 볼 것
    public static void sawon (int i) throws XLargeException, LargeException, MediumException {
        try {
            switch (i) {
                case 1: throw new SmallException();
                case 2: throw new MediumException();
                case 3: throw new LargeException();
                case 4: throw new XLargeException();
                default:
                    System.out.println("저 가 봐도 되죠?");
            }
        } catch (SmallException se) {
            System.out.println(se.getMessage() + ": 저 이건 알아요!");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void daeri (int i) throws XLargeException, LargeException {
        try {
            sawon(i);
        } catch (MediumException me) {
            System.out.println(me.getMessage() + ": 내가 처리할 테니 가 봐요.");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void bujang (int i) throws XLargeException {
        try {
            daeri(i);
        } catch (LargeException le) {
            System.out.println(le.getMessage() + ": 잘 하자. 응?");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void ceo (int i) {
        try {
            bujang(i);
        } catch (XLargeException xe) {
            System.out.println(xe.getMessage() + ": 전원 집합");
        }
        System.out.println("\n- - - - -\n");
    }
}
