import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MorseCode converter class that converts morse code into english
 * @author Cheol
 *
 *
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree codeTree = new MorseCodeTree();

	/**
	 * default constructor
	 */
	public  MorseCodeConverter() {
		
	}
	
	/**
	 * This method Uses the to Array method in MorseCodeTree to print string representation
	 * of all the data in the tree in LNR order
	 * @return the data in the tree in LNR order seperated by space
	 */
	public static String printTree()
	{
		ArrayList<String> treeData = new ArrayList<String>();
		treeData = codeTree.toArrayList();
		String result = "";
		for (int i=0; i < treeData.size(); i++)
		{
			result += treeData.get(i) + " ";
		}
		return result;
		
	}
	
	/**
	 * Converts given morse code into English.
	 * @param code morse code to convert
	 * @return English translation of morse code
	 */
	public static String convertToEnglish(String code){
		String result = "";
		String[] word = code.split(" / ");
		String[] letter;
		for(int i=0; i < word.length; i++)
		{
			letter = word[i].split(" ");
			for(int k =0; k < letter.length; k++)
			{	
				result += codeTree.fetch(letter[k]);
			}
			result +=" ";
		}
		result = result.trim();
		return result;
	}
	
	/**
	 * Converts a file that is morse code into English.
	 * @param codeFile the name of the file that contains morse code
	 * @return english translation of the given file
	 * @throws java.io.FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws java.io.FileNotFoundException{
		String result = "";
		ArrayList<String> line = new ArrayList<String>();
		String[] word;
		String[] letter;
		
		Scanner inFile = new Scanner(codeFile);
		
		while(inFile.hasNext()) {
			line.add(inFile.nextLine());
		}
		inFile.close();
		
		for(int i=0; i < line.size(); i++)
		{
			word = line.get(i).split(" / ");
		
			for(int k = 0; k < word.length; k++)
			{
				letter = word[k].split(" ");
				
				for(int j =0; j< letter.length; j++)
				{
					result += codeTree.fetch(letter[j]);
				}
				result += " ";
			}	
			
		}
		result = result.trim();
		return result;
	}
}
