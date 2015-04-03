import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecCommand {
	private String executeCmd(String cmd) {
		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
			BufferedReader reader =
				new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		ExecCommand execCommand = new ExecCommand();
		ExecCommand execCommand2 = new ExecCommand();
/*		String command = "C:\\apache-james-2.3.2\\james-2.3.2\\bin\\run.bat";
		String output = execCommand.executeCmd(command);*/
		String command = "C:\\Windows\\System32\\telnet.exe";
		String output = execCommand2.executeCmd("telnet localhost 4555");
		System.out.print(output);
	}

}
