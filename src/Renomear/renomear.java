package Renomear;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

	public class renomear {

	    private static String direitorio1(String extensao[], String descricao) {
	        String path = "";
	        JFileChooser fc = new JFileChooser();
	        // restringe a amostra a diretorios apenas
	        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        int res = fc.showOpenDialog(null);
	        if (res == JFileChooser.APPROVE_OPTION) {
	            File diretorio = fc.getSelectedFile();
	            path = diretorio.getAbsolutePath();
	        } else {
	            return null;
	        }
	        return path;
	    }

	    /**
	     * SELECIONA UM DIRETORIO PARA RENOMEAR ARQUIVOS EM LOTE
	     * VERIFICA SE EXITE ARQUIVO E SE O MESMO TEM A MESMA EXTENSÃO QUE EU 
	     * DESEJO RENOMEAR, CASO EU NÃO QUERO FILTRAR A EXTENSÃO SÓ BASTA VIRIFICAR 
	     * A EXISTECIA DO ARQUIVO
	     * if (f.isFile()){
	     * COLOQUEI PARA RENOMEAR TODOS OS ARQUIVOS DE UM DIRETORIO DE FORMAR SEQUENCIA COMEÇANDO EM 1000
	     * MAS PODE SER ALTERADO PARA SEGUIR QUALQUER LOGICA  DE QUE QUIZER IMPLEMENTAR 
	     * 
	     * NO MEU CASO ESTOU RENOMEANDO TODOS OS ARQUIVOS DE MP3 DE UM DIRETORIO COMEÇANDO EM 1000.MP3, 1001.MP3, 1002.MP3 ...                
	     */
	    public static void main(String[] args) {
	        File arquivo = new File(direitorio1(null, "C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\DadosDezembro2020\\S03122020"));
	        File[] file = arquivo.listFiles();
	        if (file != null) {
	            int length = file.length;
	            for (int i = 0; i < length; ++i) {
	                File fileAntigo = file[i];

	                if (fileAntigo.isFile() && fileAntigo.getName().substring(fileAntigo.getName().lastIndexOf("."), fileAntigo.getName().length()).equals(".xml")) {

	                    String ARQ = fileAntigo.getPath();
	                    String path = ARQ.replace(fileAntigo.getName(), "");
	                       File fileNovo = new File(path + ("530_20201201_13085567.xml" + i) + ".html");    // Renomeando arquivo ou diretório  
	                    boolean success = fileAntigo.renameTo(fileNovo);
	                    if (!success) {
	                        JOptionPane.showMessageDialog(null, "ERRO: " + (i + 1));
	                    } else {
	                    }
	                }
	            }
	        }
	    }
	}

