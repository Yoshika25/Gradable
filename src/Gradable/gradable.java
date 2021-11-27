package Gradable;



		import java.io.*;
		import java.io.File;
		import java.nio.file.Files;
		import java.nio.file.Path;
		import java.nio.file.Paths;
		import java.util.*;

		public class gradable {

			public static void main(String[] args) throws IOException  {

				Scanner sc=new Scanner(System.in);
				Scanner sc1=new Scanner(System.in);

				System.out.println("Welcome user");
				System.out.println("Developer name:Yoshika Rai");
				System.out.println("Email:yoshikarai2015@gmail.com");
				System.out.println("Project Name: Gradable");
				System.out.println();

				int choice=-1;		

				do {		

					System.out.println();
					System.out.println("Choose Options Below:");
					System.out.println("1.Display files");
					System.out.println("2.Add a file to existing directory");
					System.out.println("3.Delete a file");
					System.out.println("4.Search a file");
					System.out.println("0.Exit");
					System.out.println();
					System.out.println("What you want to do?");
					choice=sc.nextInt();

					switch (choice) {
					case 1: {			

				            String dirPath ="C:\\Users\\mac\\Desktop\\Gradable\\src\\" ;
				            File folder = new File(dirPath);

				            if(folder.isDirectory())
				            {
				                File[] fileList = folder.listFiles();//{name,name1,name2,gradable}

				                //sorting
				                Arrays.sort(fileList);

				                System.out.println("\nTotal number of items present in the directory: " + fileList.length );


				                // Lists only files since we have applied file filter
				                for(File file:fileList)
				                {
				                    System.out.println(file.getName());
				                }

				                // Creating a filter to return only files.
				                System.out.println();
				                System.out.println("Displaying Total Number of Files After Sorting");
				                System.out.println();
				                FileFilter fileFilter = new FileFilter()
				                {
				                    @Override
				                    public boolean accept(File file) {

				                        return !file.isDirectory();
				                    }
				                };

				                fileList = folder.listFiles(fileFilter);

				                // Sort files by name
				                Arrays.sort(fileList, new Comparator()
				                {
				                    @Override
				                    public int compare(Object f1, Object f2) {
				                        return ((File) f1).getName().compareTo(((File) f2).getName());
				                    }
				                });

				                //Prints the files in file name ascending order
				                for(File file:fileList)
				                {
				                    System.out.println(file.getName());
				                }

				            }   
					}

					case 2:{

						System.out.println("How many files you want to create?");
						int number=sc.nextInt();

						for (int i = 0; i < number; i++) {

							String dirPath ="C:\\Users\\mac\\Desktop\\Gradable\\src\\" ;
							System.out.println("Enter file name");
							String filename=sc1.nextLine();
							String filetype=".txt";
							String filepath=dirPath + filename + filetype;
							System.out.println(filepath);

							//create file
							try {
								FileOutputStream fout=new FileOutputStream(filepath);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							System.out.println("Successfully Created");		


						}				

					}

					case 3:{

						System.out.println("File you want to delete: ");

						String dirPath ="C:\\Users\\mac\\Desktop\\Gradable\\src\\" ;
						String filename=sc1.nextLine();
						String filetype=".txt";
						String filepath=dirPath + filename + filetype;

						File file = new File(filepath);

				        if(file.delete())
				        {
				            System.out.println("File deleted successfully");
				        }
				        else
				        {
				            System.out.println("Failed to delete the file");
				        }


				    }		

					case 4:{

						System.out.println("Search Your File Here ->");		
						String nameoffile=sc1.nextLine();

						String dirPath ="C:\\Users\\mac\\Desktop\\Gradable\\src\\" ;
						File directory = new File(dirPath);

				        // store all names with same name
				        // with/without extension
				        String[] flist = directory.list();
				        int flag = 0;
				        if (flist == null) {
				            System.out.println("Empty directory.");
				        }
				        else {

				            // Linear search in the array
				            for (int i = 0; i < flist.length; i++) {
				                String filename = flist[i];
				                //System.out.println(filename);
				                if (filename.equalsIgnoreCase(nameoffile)) {
				                    System.out.println(filename + " found file");
				                    flag = 1;
				                }
				            }
				        }

				        if (flag == 0) {
				            System.out.println("File Not Found");
				        }


					}

					case 0:{

						System.exit(0);
					}

					default:				

					}		

				}while(choice!=-1);


			}

		


	}


