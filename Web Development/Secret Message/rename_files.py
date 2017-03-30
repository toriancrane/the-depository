import os

def rename_files():
    #1. Get file names from a folder
    file_list = os.listdir(r"F:\Github\the-depository\Web Development\Secret Message\prank")

    #Get current working directory
    saved_path = os.getcwd()

    #Change directory to the correct directory
    print ("Current working directory: " + saved_path)
    os.chdir(r"F:\Github\the-depository\Web Development\Secret Message\prank")

    #2. Rename each file in folder
    for file_name in file_list:
        #Print statement for old file names
        print("The old file name is: " + file_name)
        
        #Change the filenames
        os.rename(file_name, file_name.translate(None, "0123456789"))
        
        #Print statement for each time the name of file is changed
        print("The new file name is: " + file_name)

rename_files()
