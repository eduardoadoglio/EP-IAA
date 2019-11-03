import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.File;


public class QuickSort{

	public static void main(String[] args){
		
		final File folder = new File("/home/adoglio/Documents/EP-IAA/txt/");

		listFilesForFolder(folder);
	}

	public static int[] getArrayFromFile(String filename){
		try{

		FileInputStream fstream = new FileInputStream("txt/"+filename);
	
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
                long startLeitura = System.nanoTime();
				int[] arr = getArrayFromFile(fileEntry.getName());
				long endLeitura = System.nanoTime();
                long tempoLeitura = endLeitura - startLeitura;
                int start = 0;
				int end = arr.length -1;
				long startSort = System.nanoTime();
				quickSort(arr, start, end);
				long endSort = System.nanoTime();
				long tempoSort = endSort - startSort;
                System.out.printf("%s %d %d %d np270e5g Quick Sort Java 11.0.4 GNU/Linux 64\n",fileEntry.getName(), arr.length, tempoLeitura, tempoSort);
			}
		}

}
