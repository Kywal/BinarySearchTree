package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import bst.BinarySearchTree;
import bst.Node;


public class MainTests {

	public static void main(String[] args) {
		System.out.println("Insira o caminho absoluto do arquivo.txt com os valores da sua arvore:");
		Scanner gate = new Scanner(System.in);
		String path = gate.next();
		
		BinarySearchTree bst = createBstThroughTxt(path);
		bst.imprimeArvore(1);
		
		gate.close();
	}
	
	public static String readFile(String path) {
		Reader r = null;
		String info = "";
		try {
			r = new FileReader(path);
			int c;
			while((c = r.read()) != -1) {
				info += (char) c;
			}
		} catch (FileNotFoundException e) {
			System.out.println(path + " nao existe.");
		} catch (IOException e) {
			System.out.println("Erro de leitura no arquivo.");
		} finally {
			try {
				if(r != null) {
					r.close();
				}
			} catch (IOException e) {
				System.out.println("Erro ao fechar o arquivo: " + path);
			}
		}
		
		return info;
	}	
	
	public static BinarySearchTree createBstThroughTxt(String txtPath) {
		BinarySearchTree bst = new BinarySearchTree();
		String infoTree = "";
		
		try {
			infoTree = readFile(txtPath);			
		} catch (Exception e) {
			System.out.println("Exception reading the file: " + txtPath);
			e.printStackTrace();
		}
		
		String node = "";
		
		for(int i = 0; i < infoTree.length(); i++) {
			if(infoTree.charAt(i) == ' ') {
				int value = Integer.parseInt(node);
				node = "";
				
				bst.insert(value);
				continue; 				
			}

			node += infoTree.charAt(i);			
		}
		
		return bst;
	}
}
