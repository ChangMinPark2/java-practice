package sec11.chap06.ex02;

import java.util.Random;
import java.util.concurrent.Callable;

public class RollDiceCall implements Callable<Integer> {

    //  💡 Callable 인터페이스
    //  - ⭐️ 함수형 인터페이스 (클래스 확인할 것)
    //  - Runnable과의 차이 :
    //    - 값 반환 (Supplier처럼)
    //    - Exception 던짐

    @Override
    public Integer call() throws Exception {

        Thread.sleep(1000); //  💡 현 함수가 Exception을 이미 던짐

        int result = new Random().nextInt(0, 6) + 1;
        System.out.println(result);

        return result;
    }
}
