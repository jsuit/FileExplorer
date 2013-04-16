import java.io.File;

public class FileExplorer {
	private static int dashes = 0;

	public static void explore(File in) {
		File[] filelist;
		String s = "";
		//check to see if it is a directory
		if (in.isDirectory()) {

			for (int i = 0; i < dashes; i++) { //how many  hyphens to add
				s += "-";
			}
			s = s.concat(in.getName());		
			System.out.println(s);		//print the name of current directory

			filelist = in.listFiles();		//get all the files in current directory
			for (int i = 0; i < filelist.length; i++) {
				++dashes;	//increase the dashes by one
				explore(filelist[i]);
				--dashes; //after the recursive call remove one dash;
			}

		} else if (in.isFile()) {	//if it is a file find how many dashes to add
			for (int i = 0; i < dashes; ++i) {
				s += "-";
			}
			s = s.concat(in.getName());
			System.out.println(s); //then print file name with dashes
		}

	}

	public static void main(String[] args) {
		String s = args[0];
		File in = new File(s);
		FileExplorer.explore(in);

	}
}
