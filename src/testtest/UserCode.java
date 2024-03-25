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
		// "        while(true) {\n" +
		// "        }\n" +
		"            // 계산하고 결과 출력\n" +
		"            System.out.println(a + b + 1);\n" +
		"        } catch (IOException e) {\n" +
		"            e.printStackTrace();\n" +
		"        }\n" +
		"    }\n" +
		"}\n";

	public String getCode() {
		return code;
	}
}
