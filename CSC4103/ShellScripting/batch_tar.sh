#!/bin/bash
# Name: Vogel, Andrew
# Project: PA-3 (Shell Programming)
# File: batch_tar.sh

error_detect_then_run () {
  if [ "$1" == "help" ];
  then
    echo "To copy from the tar directory, please specify a file src path and a file destination path"
    echo "EXAMPLE:"
    echo "./batch_tar.sh path/to/old_directory new_directory"
    echo "Will output all the contents of old_directory to:"
    echo "/new_directory/path/to/old_directory"
    echo "It will then tarball all files."
    exit 1
  elif [ -z "$1" ];
  then
    echo "ERROR: Please supply a first argument"
    exit 1
  elif [ -z "$2" ];
  then
    echo "ERROR: Please supply a second argument"
    exit 1
  fi
  copy_directory_structure $1 $2
}

copy_directory_structure () {
   # Copy the src directories and their contents to the new directory
   cp --parents -r "$1" "$2"
   src="$1"
   dest="$2"
   dest="$2/$1/"
   totalFiles=0
   totalSizeOriginals=0
   totalSizeTars=0
   echo "The destination directory is $dest"
   echo ""
   echo "------------Original File Names and Sizes------------"
   echo "---Filename-----------------FileSize---"
   for file in "$dest"*;
   do
     name=$(echo ${file##*/} | cut -d '.' -f 1)
     size=$(stat -c%s "$file")
     echo "$name                          $size kb"
     totalFiles=$((totalFiles + 1))
     totalSizeOriginals=$(($totalSizeOriginals + $size))
   done
   echo ""
   echo "------------Compressed File Names and Sizes----------"
   echo "---Filename-----------------FileSize---"
   for file in "$dest"*;
   do
     ext=".tgz"
     new="$file$ext"
     tar -zcf $new $file
   done

   # kind of inneficient, but whatever
   for file in "$dest"*.tgz;
   do
     name=$(echo ${file##*/})
     size=$(stat -c%s "$new")
     echo "$name                  $size kb"
     totalSizeTars=$(($totalSizeTars + $size))
   done

   echo ""
   echo "-------------------Coverage Report-------------------"
   echo "Total number of files processed: $totalFiles"
   echo "Total size of all original files: $totalSizeOriginals"
   echo "Total size of all tar files: $totalSizeTars"
   exit 0
}

error_detect_then_run $1 $2
