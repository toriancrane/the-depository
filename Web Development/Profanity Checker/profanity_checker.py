import urllib.request

def read_text():
    #Open a file
    quotes = open(r"D:\Github\the-depository\Web Development\Profanity Checker\movie_quotes.txt")

    #Read the contents of file
    contents_of_file = quotes.read()

    #Print the contents
    #print(contents_of_file)
    
    #Close file
    quotes.close()

    #Check profanity in contents of file
    check_profanity(contents_of_file)

def check_profanity(text_to_check):
    connection = urllib.request.urlopen("http://www.wdylike.appspot.com/?q="+urllib.request.quote(text_to_check))
    status = connection.read()

    #Print output
    connection.close()
    if b"true" in status:
        print("Warning: Your file contains profanity!")
    elif b"false" in status:
        print("This document is free of profanity!")
    else:
        print("There was an error in scanning the document.")
read_text()
