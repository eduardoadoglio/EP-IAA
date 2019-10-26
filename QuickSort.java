import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.File;


public class QuickSort{

	public static void main(String[] args){
		
		final File folder = new File("/home/local/USPEACHSI/a11271077/Documentos/txt");

		listFilesForFolder(folder);
		/*int[] arr = getArrayFromFile("1K_Array_1.txt");
		int start = 0;
		int end = arr.length -1;
		long startNano = System.nanoTime();
		quickSort(arr, start, end);
		//printArr(arr);
		long endNano = System.nanoTime();
		long finalNano = endNano - startNano;
		System.out.printf("Tempo de execução: %d", finalNano);*/
	}

	public static int[] getArrayFromFile(String filename){
		try{

		FileInputStream fstream = new FileInputStream(
"txt/"+filename);
	
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		int numLinhas = Integer.parseInt(br.readLine());
		int i = 0;
		int[] arr = new int[numLinhas];
		while ((strLine = br.readLine()) != null)   {
			arr[i] = Integer.parseInt(strLine);
			i++;
		}

		in.close();
		return arr;
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
  		return null;
	}

	public static void printArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}


	public static int partition(int[] arr, int start, int end){
		int pivot = arr[end];  
		int i = (start-1);
		for (int j=start; j<end; j++) { 
			if (arr[j] < pivot) { 
				i++; 

				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		int temp = arr[i+1]; 
		arr[i+1] = arr[end]; 
		arr[end] = temp; 

		return i+1; 
	}

	public static void quickSort(int[] arr, int start, int end){
		if (start < end) { 
            int pi = partition(arr, start, end); 
  
            quickSort(arr, start, pi-1); 
            quickSort(arr, pi+1, end); 
        }
	}

	public static void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
				int[] arr = getArrayFromFile(fileEntry.getName());
				int start = 0;
				int end = arr.length -1;
				long startNano = System.nanoTime();
				quickSort(arr, start, end);
				long endNano = System.nanoTime();
				long finalNano = endNano - startNano;
				System.out.printf("Tamanho do array: %d\nTempo de execução: %d",arr.length, finalNano);
			}
		}

}
