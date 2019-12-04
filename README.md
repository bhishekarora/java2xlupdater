# java2xlupdater
update xlsx  via apache poi using java 

Readme
==================

How to add special characters?

RemoveSpecialCharacters.java // line 23 add remove characters here

Important files
===============
meta.xls // the xl sheet that need to be updated 
docs// folder where attachments are stored which have special characters
output// final attachments without special characters

How to run 
=====================
Unzip this folder on a windows machine with java on path // google for how to add java 8 to path

>java -classpath bin;* Files

// run the above command , and files in docs will be renamed and moved to output and meta.xls will be updated


Sample use case
=================
Add two files with   spaces in names test 1.txt  test 2.txt to docs folder
Add the two entries in names column in meta.xls
Run the above command and you should see these two files with renamed files in output folder with test_1.txt and test_2.txt 
Open meta.xls and you should see meta updated.

