Book Bibliography and CSV Processor 📚
A Java-based system for processing and validating bibliographic data and CSV files with format conversion and error handling capabilities.
Project Overview
This project consists of two main components:

A Bibliography Factory that converts bibliography files into different citation formats (IEEE, ACM, NJ)
A CSV processor for book records with validation and categorization features

Features
Bibliography Factory

Converts source files into three citation formats:

IEEE format
ACM format
Nature Journal (NJ) format


Input validation with error handling
Interactive file review system
Multiple file processing capability

CSV Book Processor

Validates book records for:

ISBN verification (10 and 13 digit)
Price validation
Year range checking (1995-2010)


Categorizes books by genre into separate files
Comprehensive error logging
Exception handling for invalid data

Technical Details
Main Components

BibliographyFactory.java: Main bibliography processing engine
do_part_1.java: CSV processing and validation
Custom Exception Classes:

invalidISBNException.java
invalidPriceException.java
invalidYearException.java



Input/Output

Input Formats:

Bibliography: .bib files
Book records: .csv files


Output Formats:

Citations: .json files
Categorized books: .csv files
Error logs: .txt files



Validation Rules

ISBN: Checksum validation for both 10 and 13 digit formats
Price: Must be positive
Year: Must be between 1995-2010
All fields must be properly formatted

Usage
Bibliography Generation
javaCopyjava BibliographyFactory

Program will process all Latex*.bib files in directory
Creates corresponding IEEE, ACM, and NJ format files
Allows review of generated files

CSV Processing
javaCopyjava do_part_1

Processes books1995.csv.txt
Creates genre-specific output files
Generates Semantic.error.txt for validation errors

Requirements

Java Development Kit (JDK)
Input files in correct format
Sufficient disk space for output files

Error Handling

Invalid files are detected and reported
Detailed error messages in Semantic.error.txt
Graceful handling of file I/O exceptions
