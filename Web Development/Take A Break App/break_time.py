import time
import webbrowser

total = 3
count = 0

print("This program started on " + time.ctime())
while(count < total):
    time.sleep(7200)
    webbrowser.open("https://youtu.be/kAMRpchLUXU")
    count += 1
