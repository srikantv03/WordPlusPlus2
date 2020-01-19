# Word++

Word++ is a specialized text editor made with Java and focuses on modularity and dynamic functionality. It is focused on plugins, from which it derives the majority of its functionality, as these plugins automatically update information in text files with real-time data.

## Installation

### Windows 10

This program is still in experimental stage, and as such the stable version is entirely contained in a single .jar file. It has only been tested on Java 8, and there is no guarantee that it works with any other versions of Java. To download Word++, simply download the .jar file, make sure you have Java 8 installed, and run the file from the Downloads directory (or wherever it was saved).

## Usage

The beauty of this text editor is that it utilizes pairs of files, with one file being the 'source' code, and the other file containing the updated data. To edit files, open the source code text file, which we refer to as filenameSrc.txt. To insert data to be dynamically updated, use the following syntax: \pluginName[parameter]. If you want to insert the current stock price of AMD dynamically then, you would type \stocks[amd] in the filenameSrc.txt file, which would be 'compiled' in the filename.txt file as the current stocks price of AMD.
