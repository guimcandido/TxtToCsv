package controller;

import java.io.File;
import java.io.IOException;

public interface IArquivosController {

	public void readDir(String path) throws IOException;

	public File createFile(String path, String name, String content) throws IOException;

	public void readFile(String path, String nome) throws IOException;

	public void openFile(String path, String nome) throws IOException;
	
	public void txtToCsv(String path, String nome) throws IOException;

}
