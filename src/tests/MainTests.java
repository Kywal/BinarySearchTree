package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bst.BinarySearchTree;
import bst.Node;


public class MainTests {

	public static void main(String[] args) {
		Scanner gate = new Scanner(System.in);
		String path;
		
		System.out.println("Insira o caminho absoluto do arquivo.txt com os valores da sua arvore:");
		path = gate.next();
		ArrayList<String> infoTree = readFile(path);
		BinarySearchTree bst = createBstThroughTxt(infoTree);
		bst.imprimeArvore(1);

		System.out.println("Insira o caminho absoluto do arquivo.txt com os comandos para sua arvore:");
		path = gate.next();
		ArrayList<String> comands = readFile(path);
		executeComands(comands, bst);
		
		gate.close();
	}
	
	public static ArrayList<String> readFile(String path) {
		Reader r = null;
		String info = "";
		ArrayList<String> infos = new ArrayList<String>();
		try {
			r = new FileReader(path);
			int c = 0;
			
			while((c = r.read()) != -1) {				
				char digit = (char) c; 
				
				if(digit == ' ' || digit == '\r') {
					info = info.replaceFirst("\\n", "");
					infos.add(info);
					info = "";
					
					continue;
				}
				
				info = info.replaceFirst("\\n", "");
				info += (char) c;
			}
			
			infos.add(info);
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
		
		System.out.println(infos);
		return infos;
	}	
	
	public static BinarySearchTree createBstThroughTxt(ArrayList<String> infoTree) {
		BinarySearchTree bst = new BinarySearchTree();
		
		for(int i = 0; i < infoTree.size(); i++) {
			bst.insert(Integer.parseInt(infoTree.get(i)));
		}
		
		return bst;
	}

	public static void executeComands(ArrayList<String> comands, BinarySearchTree bst) {		
		int value = 0;
		
		for (int j = 0; j < comands.size(); j++) {
			String comand = comands.get(j);
			
			switch(comand) {
				case "CHEIA" :
					String infoCheia = bst.ehCheia() ? "eh" : "nao eh";
					System.out.println("A arvore " + infoCheia + " cheia");
					break;
				case "COMPLETA":
					String infoCompleta = bst.ehCompleta() ? "eh" : "nao eh";
					System.out.println("A arvore " + infoCompleta + " completa");
					break;
				case "ENESIMO":
					comand = comands.get(++j);
					System.out.println(bst.enesimoElemento(Integer.parseInt(comand)));
					break;
				case "INSIRA":
					comand = comands.get(++j);
					value = Integer.parseInt(comand);
					if(bst.insert(value)) {
						System.out.println(value + " adicionado");
					} else {
						System.out.println(value + " ja esta na arvore, nao pode ser inserido");
					}
					break;
				case "PREORDEM":
					bst.preOrder(bst.getRoot());
					System.out.println("");
					break;
				case "IMPRIMA":
					comand = comands.get(++j);
					value = Integer.parseInt(comand);
					bst.imprimeArvore(value);
					break;
				case "REMOVA":
					comand = comands.get(++j);
					value = Integer.parseInt(comand);
					if(bst.remove(value)) {
						System.out.println(value + " removido");
					} else {
						System.out.println(value + " nao esta na arvore, nao pode ser removido");
					}
					break;
				case "POSICAO":
					comand = comands.get(++j);
					value = Integer.parseInt(comand);
					System.out.println("O no " + value + " esta na posicao " + bst.posicao(value));
					break;
				case "MEDIANA":
					System.out.println("Mediana: " + bst.mediana());
					break;
				case "MEDIA":
					comand = comands.get(++j);
					value = Integer.parseInt(comand);
					try {
						System.out.println("###########");
						System.out.println("Media: " + bst.media(value));
						System.out.println("###########");
					} catch (NullPointerException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
					break;
				case "BUSCAR":
					comand = comands.get(++j);
					value = Integer.parseInt(comand);
					Node f = bst.find(value);
					
					if(f == null) System.out.println("Chave nao encontrada");
					else System.out.println("Chave encontrada");
					break;
				default:
					System.out.println("Comando nao identificado!");
			}			
		}
	}

}
