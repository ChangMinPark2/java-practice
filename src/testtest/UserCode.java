package testtest;

public class UserCode {
	public String code =
		"import java.io.*;\n" +
			"public class Main {\n" +
			"    public static void main(String[] args) {\n" +
			"        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\n" +
			"        int a, b;\n" +
			"        try {\n" +
			"            a = Integer.parseInt(br.readLine());\n" +
			"            b = Integer.parseInt(br.readLine());\n" +
			"            // 임의로 시간 지연을 추가하여 시간 초과를 유발\n" +
			"            Thread.sleep(500);\n" + // 5초 동안 일시 정지
			"            System.out.println(a + b);\n" +
			"        } catch (IOException e) {\n" +
			"            e.printStackTrace();\n" +
			"        } catch (InterruptedException e) {\n" +
			"            e.printStackTrace();\n" +
			"        }\n" +
			"    }\n" +
			"}\n";

	public String getCode() {
		return code;
	}
}
