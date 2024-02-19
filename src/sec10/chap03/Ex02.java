package sec10.chap03;

import java.io.FileNotFoundException;

public class Ex02 {
    public static void registerDutyMonth (String name, int month) {
        if (month < 1 || month > 12) {
            throw new IndexOutOfBoundsException(
                    "우리 %s씨는 1년에 몇 달이 있는지 아직 못 배웠나봐?"
                            .formatted(name)
            );
        }
        System.out.printf("%s씨 %d월 담당으로 배정되셨어요.%n", name, month);
    }

    public static void main(String[] args) {
        registerDutyMonth("정핫훈", 7);

        registerDutyMonth("김돌준", 13);
        //  ⭐️ try 문으로 감싸지 않았음
        //  - 다음 코드들이 실행되려면 주석처리해야 함

        openMyFile("잘나온얼굴.png");
        openMyFile("야구동영상.avi");
    }

    public static void openMyFile (String fileName) {
        if (fileName.contains("야구동영상")) {
            //  💡 try 문으로 감싸야 컴파일되는 예외
            try {
                throw new FileNotFoundException(
                        "제 컴퓨터엔 그런 거 없어요."
                );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("👨‍🏫 인강 프로그램을 실행합니다...");
            }
            return;
        }
        System.out.printf("%s 파일 열람%n", fileName);
    }

    public class WrongMonthException extends RuntimeException {
        public WrongMonthException(int month) {
            //  💡 최고조상인 Throwable의 생성자 확인
            //  - detailMessage 에 값을 넣는 오버로드
            super(
                    ("당신이 사는 세계에는 %d월이 있나 보군요." +
                            "멀티버스 여행이 가능해진다면 " +
                            "저도 꼭 %d월을 살아 보고 싶습니다.")
                            .formatted(month, month)
            );
        }
    }
}
