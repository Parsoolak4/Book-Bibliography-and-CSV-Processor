📚 Book Bibliography and CSV Processor

🚀 A powerful Java-based system for transforming your bibliographic data into multiple formats!

🎯 Project Overview
Transform your bibliography chaos into organized excellence with our dual-component system:

📑 Bibliography Factory: Your one-stop citation format converter
📊 CSV Processor: Smart book record validator and organizer

✨ Features
📗 Bibliography Factory

🔄 Triple-format conversion magic:

📌 IEEE format
🎯 ACM format
🌟 Nature Journal (NJ) format


✅ Smart input validation
🖥️ Interactive file review
📦 Batch processing power

📘 CSV Book Processor

🔍 Smart Validation:

📇 ISBN checker (10 & 13 digits)
💰 Price validator
📅 Year range guardian (1995-2010)


📁 Auto-categorization by genre
🚨 Comprehensive error tracking
🛡️ Robust exception handling

🛠️ Technical Details
🔧 Core Components
javaCopy📂 Main Files:
├── 🔮 BibliographyFactory.java
├── 🎯 do_part_1.java
└── 🚨 Exception Classes:
    ├── invalidISBNException.java
    ├── invalidPriceException.java
    └── invalidYearException.java
📥 Input/Output
Copy📁 Input:
├── 📑 .bib files (Bibliography)
└── 📊 .csv files (Book records)

📁 Output:
├── 📋 .json files (Citations)
├── 📊 .csv files (Categorized books)
└── 📝 .txt files (Error logs)
✅ Validation Rules

📚 ISBN: Smart checksum validation
💲 Price: Positive values only
📅 Year: 1995-2010 range
🎯 Format: Strict field validation

🚀 Usage
📚 Bibliography Generation
bashCopyjava BibliographyFactory

🎯 Processes all Latex*.bib files and creates formatted citations

📊 CSV Processing
bashCopyjava do_part_1

🔄 Handles books1995.csv.txt with automatic categorization

⚙️ Requirements

☕ Java Development Kit (JDK)
📁 Properly formatted input files
💾 Adequate storage space

🛡️ Error Handling

🚫 Instant invalid file detection
📝 Detailed error reporting
🛠️ Smooth exception management


🤝 Contributing
Feel free to enhance this project! Open an issue or submit a pull request.
