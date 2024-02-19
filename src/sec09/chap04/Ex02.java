package sec09.chap04;
import sec07.chap04.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class Ex02 {
    public static void main(String[] args) {
        //  💡 배열로부터 생성
        Integer[] integerAry = {1, 2, 3, 4, 5};
        Stream<Integer> fromArray = Arrays.stream(integerAry);
        Object[] fromArray_Arr = fromArray.toArray();

        //  ⚠️ 런타임 에러
        //  - 스트림은 한 번 사용하면 끝 (흘러가버린 물)
        //Object[] ifReuse = fromArray.toArray();

        //  원시값의 배열로부터는 스트림의 클래스가 달라짐
        int[] intAry = {1, 2, 3, 4, 5};
        IntStream fromIntAry = Arrays.stream(intAry);
        int[] fromIntAry_Arr = fromIntAry.toArray();

        double[] dblAry = {1.1, 2.2, 3.3};
        DoubleStream fromDblAry = Arrays.stream(dblAry);
        double[] fromDblAry_Arr = fromDblAry.toArray();

        //  💡 값들로 직접 생성
        IntStream withInts = IntStream.of(1, 2, 3, 4, 5);
        Stream<Integer> withIntegers = Stream.of(1, 2, 3, 4, 5);
        Stream<Unit> withUnits = Stream.of(
                new Swordman(Side.BLUE),
                new Knight(Side.BLUE),
                new MagicKnight(Side.BLUE)
        );
        Object[] withUnits_Arr = withUnits.toArray();

        //  💡 컬렉션으로부터 생성
        List<Integer> intAryList = new ArrayList<>(Arrays.asList(integerAry));
        Stream fromColl1 = intAryList.stream();
        Object[] fromColl1_Arr = fromColl1.toArray();

        //  맵의 경우 엔트리의 스트림으로 생성
        Map<String, Character> subjectGradeHM = new HashMap<>();
        subjectGradeHM.put("English", 'B');
        subjectGradeHM.put("Math", 'C');
        subjectGradeHM.put("Programming", 'A');
        Object[] fromHashMap_Arr = subjectGradeHM.entrySet().stream().toArray();

        //  💡 빌더로 생성
        Stream.Builder<Character> builder = Stream.builder();
        builder.accept('스');
        builder.accept('트');
        builder.accept('림');
        builder.accept('빌');
        builder.accept('더');
        Stream<Character> withBuilder = builder.build();
        Object[] withBuilder_Arr = withBuilder.toArray();

        //  💡 concat 메소드로 생성
        Stream<Integer> toConcat1 = Stream.of(11, 22, 33);
        Stream<Integer> toConcat2 = Stream.of(44, 55, 66);
        Stream<Integer> withConcatMethod = Stream.concat(toConcat1, toConcat2);
        Object[] withConcatMethod_Arr = withConcatMethod.toArray();

        //  💡 이터레이터로 생성
        //  - 인자: 초기값, 다음 값을 구하는 람다 함수
        //  - limit으로 횟수를 지정해야 함
        Stream<Integer> withIter1 = Stream
                .iterate(0, i -> i + 2)
                .limit(10);
        Object[] withIter1_Arr = withIter1.toArray();

        Stream<String> withIter2 = Stream
                .iterate("홀", s -> s + (s.endsWith("홀") ? "짝" : "홀"))
                .limit(8);
        Object[] withIter2_Arr = withIter2.toArray();

        //  💡 원시자료형 스트림의 기능들로 생성
        IntStream fromRange1 = IntStream.range(10, 20); // 20 미포함
        IntStream fromRange2 = IntStream.rangeClosed(10, 20); // 20 포함

        Stream<Integer> fromRangeBox = fromRange1.boxed();
        Object[] fromRangeBox_Arr = fromRangeBox.toArray();

//        //  💡 원시자료형 스트림의 기능들로 생성
//        IntStream fromRange1 = IntStream.range(10, 20); // 20 미포함
//        IntStream fromRange2 = IntStream.rangeClosed(10, 20); // 20 포함
//
//        Stream<Integer> fromRangeBox = fromRange1.boxed();
//        Object[] fromRangeBox_Arr = fromRangeBox.toArray();

        //  💡 Random 클래스의 스트림 생성 메소드들
        IntStream randomInts = new Random().ints(5, 0, 100);
        int[] randomInts_Arr = randomInts.toArray();

        DoubleStream randomDbls = new Random().doubles(5, 2, 3);
        double[] randomDbls_Arr = randomDbls.toArray();

        //  문자열을 각 문자에 해당하는 정수의 스트림으로
        IntStream fromString = "Hello World".chars();
        int[] fromString_Arr = fromString.toArray();

        //  💡 파일로부터 생성
        //  - File I/O : 이후 배울 것
        Stream<String> fromFile;
        Path path = Paths.get("./src/sec09/chap04/turtle.txt");
        try {
            fromFile = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Object[] fromFile_Arr = fromFile.toArray();

        //  💡 빈 스트림 생성
        //  - 스트림을 받는 메소드 등에서 종종 사용
        Stream<Double> emptyDblStream = Stream.empty();
    }

}
