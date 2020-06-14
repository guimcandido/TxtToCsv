package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {
	public static void main(String[] args) {
		IArquivosController arquivosController = new ArquivosController();
		
		String path = JOptionPane.showInputDialog(null, "Informe apenas o diretório do relatório:", "Diretório",
				JOptionPane.INFORMATION_MESSAGE);
		String name = JOptionPane.showInputDialog(null, "Informe o nome do arquivo do relatório:", "Arquivo",
				JOptionPane.INFORMATION_MESSAGE);
		
		
		try {
			//arquivosController.readDir(path);
			//arquivosController.createFile(path, name);
			//arquivosController.readFile(path, name);
			//arquivosController.openFile(path, name);
			arquivosController.txtToCsv(path, name);
			JOptionPane.showMessageDialog(null, "Relatório convertido com sucesso, verifique o diretório");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
