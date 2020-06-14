package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	@Override
	public void readDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				if (f.isFile()) {
					System.out.println("     \t" + f.getName());
				} else {
					System.out.println("<DIR>\t" + f.getName());
				}
			}
		} else {
			throw new IOException("Diretório inválido");
		}
	}

	@Override
	public File createFile(String path, String name, String content) throws IOException {
		File dir = new File(path);
		File file = new File(path, name);
		if (dir.exists() && dir.isDirectory()) {
			boolean fileExist = false;
			if (file.exists()) {
				fileExist = true;
			}
			FileWriter fileWriter = new FileWriter(file, fileExist);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(content);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório inválido");
		}
		return file;
	}

	private String generateTxt() {
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while (!line.equalsIgnoreCase("fim")) {
			line = JOptionPane.showInputDialog(null, "Digite uma frase:", "Entrada de texto",
					JOptionPane.INFORMATION_MESSAGE);
			if (!line.equalsIgnoreCase("fim")) {
				buffer.append(line + "\n");
			}
		}
		return buffer.toString();
	}

	@Override
	public void readFile(String path, String name) throws IOException {
		File file = new File(path, name);
		if (file.exists() && file.isFile()) {
			FileInputStream flow = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			while (line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}
			buffer.close();
			reader.close();
			flow.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	public void txtToCsv(String path, String name) throws IOException {
		File fileTxt = new File(path, name);
		StringBuffer bufferCsv = new StringBuffer();

		if (fileTxt.exists() && fileTxt.isFile()) {
			FileInputStream flow = new FileInputStream(fileTxt);
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			while (line != null) {
				String lineCsv = "";
				String[] arrayLine = line.split(" ");
				for (int i = 0; i < arrayLine.length; i++) {
					lineCsv = lineCsv + ";" + arrayLine[i];
				}
				bufferCsv.append(lineCsv + "\n");
				System.out.println(line);
				line = buffer.readLine();
				
			}
			buffer.close();
			reader.close();
			flow.close();
		} else

		{
			throw new IOException("Arquivo inválido");
		}

		File fileCsv = this.createFile(path, "relatorio.csv", bufferCsv.toString());
		//this.openFile(path, "relatorio.csv");
	}

	@Override
	public void openFile(String path, String name) throws IOException {
		File file = new File(path, name);
		if (file.exists() && file.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(file);
		} else {
			throw new IOException("Arquivo inválido");
		}
	}
}
