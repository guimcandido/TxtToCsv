package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {
	public static void main(String[] args) {
		IArquivosController arquivosController = new ArquivosController();
		
		String path = JOptionPane.showInputDialog(null, "Informe apenas o diret�rio do relat�rio:", "Diret�rio",
				JOptionPane.INFORMATION_MESSAGE);
		String name = JOptionPane.showInputDialog(null, "Informe o nome do arquivo do relat�rio:", "Arquivo",
				JOptionPane.INFORMATION_MESSAGE);
		
		
		try {
			//arquivosController.readDir(path);
			//arquivosController.createFile(path, name);
			//arquivosController.readFile(path, name);
			//arquivosController.openFile(path, name);
			arquivosController.txtToCsv(path, name);
			JOptionPane.showMessageDialog(null, "Relat�rio convertido com sucesso, verifique o diret�rio");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
