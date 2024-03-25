package testtest;

import java.io.*;
import java.util.*;

public class test {
	public static void main(String[] args) {
		try {
			UserCode code = new UserCode();

			// 임시 디렉토리에 파일을 생성하고 코드를 쓰기
			File tempDir = new File("temp");
			isExist(tempDir);

			File sourceFile = new File(tempDir, "Main.java");
			BufferedWriter writer = new BufferedWriter(new FileWriter(sourceFile));
			writer.write(code.getCode());
			writer.close();

			// 실행할 Java 클래스의 전체 이름을 지정합니다. 패키지 이름을 포함해야 합니다.
			String fullClassName = "Main";

			// 입력과 기대 출력을 List로 관리합니다.
			List<List<String>> testCases = new ArrayList<>();

			testCases.add(new ArrayList<>(List.of("1\n2\n", "3")));
			testCases.add(new ArrayList<>(List.of("2\n3\n", "5")));
			testCases.add(new ArrayList<>(List.of("3\n3\n", "6")));

			// 자바 소스 코드를 컴파일하기 위한 ProcessBuilder를 생성합니다.
			ProcessBuilder compileProcessBuilder = new ProcessBuilder("javac", sourceFile.getAbsolutePath());
			Process compileProcess = compileProcessBuilder.start();
			compileProcess.waitFor();

			// 컴파일이 성공적으로 완료되었는지 확인합니다.
			if (compileProcess.exitValue() == 0) {
				trueOrFalse(testCases, tempDir, fullClassName);
			} else {
				comileError(compileProcess);
			}

			sourceFile.delete();
			tempDir.delete();
			System.out.println("Cleanup completed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void trueOrFalse(List<List<String>> testCases, File tempDir, String fullClassName) throws
		IOException,
		InterruptedException {
		for (List<String> testCase : testCases) {
			String input = testCase.get(0);
			String expectedOutput = testCase.get(1);

			// 컴파일이 성공했을 경우, 컴파일된 클래스를 실행하기 위한 ProcessBuilder를 생성합니다.
			ProcessBuilder runProcessBuilder = new ProcessBuilder("java", "-cp", tempDir.getAbsolutePath(),
				fullClassName);
			Process runProcess = runProcessBuilder.start();

			// 실행할 클래스에 입력을 전달하기 위한 BufferedWriter를 생성합니다.
			BufferedWriter processInputWriter = new BufferedWriter(new OutputStreamWriter(runProcess.getOutputStream()));
			processInputWriter.write(input);
			processInputWriter.flush();
			processInputWriter.close();

			// 실행 결과를 읽기 위한 BufferedReader를 생성합니다.
			BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
			String line = reader.readLine();

			// 실행 결과가 예상된 출력과 일치하는지 확인합니다.
			if (expectedOutput.equals(line)) {
				System.out.println("성공: " + line);
			} else {
				System.out.println("실패" + " 입력 값" + Arrays.toString(input.split("\n")) + "기댓 값 " + expectedOutput);
			}

			runProcess.waitFor();
		}
	}

	private static void comileError(Process compileProcess) throws IOException {
		BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
		String errorLine;
		while ((errorLine = errorReader.readLine()) != null) {
			System.out.println("Error: " + errorLine);

		}
	}

	private static void isExist(File tempDir) {
		if (!tempDir.exists()) {
			tempDir.mkdir();
		}
	}
}
