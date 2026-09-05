# Step_semester_3 🚀

A curated collection of Java solutions, live-coding practice sessions, and graded algorithmic assignments developed during **Semester 3** (CodInClub powered by BridgeLabz).

---

## 📌 Table of Contents

- [Overview](#-overview)
- [Repository Structure](#-repository-structure)
- [Curriculum & Problem Directory](#-curriculum--problem-directory)
  - [Week 1: Fundamentals & Logic Building](#week-1-fundamentals--logic-building)
  - [Week 2: String Manipulation & Validations](#week-2-string-manipulation--validations)
  - [Week 4: Advanced Arrays & Two-Pointer Patterns](#week-4-advanced-arrays--two-pointer-patterns)
  - [Week 5: 2D Grids, OOP & Ranking Engines](#week-5-2d-grids-oop--ranking-engines)
- [How to Compile and Run](#-how-to-compile-and-run)
- [Author & License](#-author--license)

---

## 📖 Overview

This repository contains clean, efficient, and robust Java implementations covering:
- **Core Algorithms & Data Structures**: Arrays, Strings, HashMaps, Two Pointers, Sliding Window, Prefix Sums, Kadane's Algorithm, Binary Search.
- **Data Parsing & Sanitization**: CSV parsing, regex-free custom tokenizers, input normalization, masking, and multi-stage validators.
- **Object-Oriented Programming (OOP)**: Encapsulation, Method Overloading, `Comparable<T>` interface for custom sorting, and modern Java records/streams.

---

## 📂 Repository Structure

```
Step_semester_3/
├── WEEK-1/                 # Day 1 Live-Coding Practice Problems
├── Week-1-Assignments/     # Week 1 Graded Assignment Solutions
├── WEEK-2/                 # Day 2 Live-Coding Practice Problems
├── Week-2-Assignments/     # Week 2 Graded Assignment Solutions
├── WEEK-4/                 # Week 4 Live-Coding Practice Problems (LeetCode Style)
├── Week-4-Assignments/     # Week 4 Advanced Algorithmic Assignments
├── WEEK-5/                 # Week 5 Live-Coding Practice Problems
├── Week-5-Assignments/     # Week 5 Domain-Specific Ranking & Grid Assignments
├── README.md               # Repository Documentation
└── LICENSE                 # License
```

---

## 📚 Curriculum & Problem Directory

### Week 1: Fundamentals & Logic Building

#### 🔹 Live-Coding Problems (`WEEK-1/`)
| Problem | File | Key Concepts |
| :--- | :--- | :--- |
| **Rock-Paper-Scissors Game** | [`RockPaperScissors.java`](./WEEK-1/RockPaperScissors.java) | Random simulation, game rules, scoreboard formatting, win % calculation |
| **Palindrome Checker (3 Approaches)** | [`PalindromeChecker.java`](./WEEK-1/PalindromeChecker.java) | Iterative two-pointers, recursion, and array reversal comparisons |
| **BMI Calculator for a Team** | [`BmiCalculator.java`](./WEEK-1/BmiCalculator.java) | Parallel arrays, arithmetic operations, formatted tabular reporting |
| **Reverse Customer Name** | [`ReverseCustomerName.java`](./WEEK-1/ReverseCustomerName.java) | In-place character swapping, string immutability preservation |

#### 🔹 Assignment Solutions (`Week-1-Assignments/`)
| Problem | File | Key Concepts |
| :--- | :--- | :--- |
| **Exam Hall Seat Duplication Checker** | [`ExamHallSeatDuplicationChecker.java`](./Week-1-Assignments/ExamHallSeatDuplicationChecker.java) | Nested loops without Collections, early duplicate detection |
| **Typing Speed Test Accuracy Checker** | [`TypingSpeedAccuracyChecker.java`](./Week-1-Assignments/TypingSpeedAccuracyChecker.java) | String traversal, accuracy metrics, mismatch index detection |
| **Traffic Signal Streak Analyzer** | [`TrafficSignalStreakAnalyzer.java`](./Week-1-Assignments/TrafficSignalStreakAnalyzer.java) | Consecutive sequence scanning, running maximum streak tracking |
| **Warehouse Inventory Balancer** | [`WarehouseInventoryBalancer.java`](./Week-1-Assignments/WarehouseInventoryBalancer.java) | Array accumulation, cross-section balance comparison, max tracking |
| **Movie Review Word Length Profiler** | [`MovieReviewWordLengthProfiler.java`](./Week-1-Assignments/MovieReviewWordLengthProfiler.java) | String tokenization (`split`), word categorization (Short/Medium/Long) |

---

### Week 2: String Manipulation & Validations

#### 🔹 Live-Coding Problems (`WEEK-2/`)
| Problem | File | Key Concepts |
| :--- | :--- | :--- |
| **Vowel & Consonant Counter** | [`VowelConsonantCounter.java`](./WEEK-2/VowelConsonantCounter.java) | Character classification, case-insensitive comparison, whitespace skipping |
| **CSV Student Record Parser** | [`CsvStudentRecordParser.java`](./WEEK-2/CsvStudentRecordParser.java) | `split(",")`, field length validation, formatted string output |
| **File Extension Validator** | [`FileExtensionValidator.java`](./WEEK-2/FileExtensionValidator.java) | `lastIndexOf()`, `substring()`, case-insensitive whitelist check |
| **Masked Phone Number Formatter** | [`MaskedPhoneNumberFormatter.java`](./WEEK-2/MaskedPhoneNumberFormatter.java) | Numeric validation, `StringBuilder`, string masking & insertion |
| **Bank Transaction Reference Validator** | [`BankTransactionReferenceValidator.java`](./WEEK-2/BankTransactionReferenceValidator.java) | Multi-stage normalization, `Character.isLetter`/`isDigit` verification |

#### 🔹 Assignment Solutions (`Week-2-Assignments/`)
| Problem | File | Key Concepts |
| :--- | :--- | :--- |
| **ATM PIN Length Validator** | [`AtmPinLengthValidator.java`](./Week-2-Assignments/AtmPinLengthValidator.java) | `length()` validation, single conditional branch |
| **Word Reversal Encoder** | [`WordReversalEncoder.java`](./Week-2-Assignments/WordReversalEncoder.java) | Word-by-word reversal using `StringBuilder`, preserving sentence order |
| **Product Inventory CSV Parser** | [`ProductInventoryCsvParser.java`](./Week-2-Assignments/ProductInventoryCsvParser.java) | CSV parsing, error handling for corrupted records |
| **Library ISBN Validator** | [`LibraryIsbnValidator.java`](./Week-2-Assignments/LibraryIsbnValidator.java) | Publisher code capitalization, date/catalog digit validation |
| **Stop-Word-Filtered Frequency Report** | [`StopWordFrequencyReport.java`](./Week-2-Assignments/StopWordFrequencyReport.java) | Text normalization, stop-word set filtering, HashMap frequency sorting |

---

### Week 4: Advanced Arrays & Two-Pointer Patterns

#### 🔹 Live-Coding Problems (`WEEK-4/`)
| Problem | File | Algorithm / Technique | Time | Space |
| :--- | :--- | :--- | :--- | :--- |
| **Two Sum** | [`TwoSum.java`](./WEEK-4/TwoSum.java) | Two Pointers / Hash Search | $O(N)$ | $O(1)$ |
| **Best Time to Buy & Sell Stock** | [`BestTimeToBuyAndSellStock.java`](./WEEK-4/BestTimeToBuyAndSellStock.java) | Single-pass Min-Price Tracking | $O(N)$ | $O(1)$ |
| **Contains Duplicate** | [`ContainsDuplicate.java`](./WEEK-4/ContainsDuplicate.java) | Element Lookup / Hashing | $O(N)$ | $O(N)$ |
| **Merge Sorted Arrays** | [`MergeSortedArrays.java`](./WEEK-4/MergeSortedArrays.java) | Three-Pointer Backward Merge | $O(M+N)$ | $O(1)$ |
| **Rotate Array** | [`RotateArray.java`](./WEEK-4/RotateArray.java) | Array Block Reversal ($k \bmod N$) | $O(N)$ | $O(1)$ |

#### 🔹 Assignment Solutions (`Week-4-Assignments/`)
| Problem | File | Algorithm / Technique | Time | Space |
| :--- | :--- | :--- | :--- | :--- |
| **3Sum** | [`ThreeSum.java`](./Week-4-Assignments/ThreeSum.java) | Sorting + Two Pointers (Unique Triplets) | $O(N^2)$ | $O(1)$ |
| **Product of Array Except Self** | [`ProductExceptSelf.java`](./Week-4-Assignments/ProductExceptSelf.java) | Prefix & Suffix Products | $O(N)$ | $O(1)$ |
| **Maximum Subarray** | [`MaximunSubarray.java`](./Week-4-Assignments/MaximunSubarray.java) | Kadane's Algorithm | $O(N)$ | $O(1)$ |
| **Subarray Sum Equals K** | [`SubarraySumEqualsK.java`](./Week-4-Assignments/SubarraySumEqualsK.java) | Prefix Sums + Frequency Hash Map | $O(N)$ | $O(N)$ |
| **Find Minimum in Rotated Sorted Array**| [`FindMinimumRotatedSortedArray.java`](./Week-4-Assignments/FindMinimumRotatedSortedArray.java) | Binary Search on Rotated Pivot | $O(\log N)$ | $O(1)$ |

---

### Week 5: 2D Grids, OOP & Ranking Engines

#### 🔹 Live-Coding Problems (`WEEK-5/`)
| Problem | File | Key Concepts |
| :--- | :--- | :--- |
| **Hackathon Score Curve Booster** | [`HackathonScoreCurveBooster.java`](./WEEK-5/HackathonScoreCurveBooster.java) | In-place array modification passed by reference |
| **Duplicate Team Name Finder** | [`DuplicateTeamNameFinder.java`](./WEEK-5/DuplicateTeamNameFinder.java) | Pairwise loop comparison, case-sensitive deduplication |
| **Top-3 Podium Finder** | [`TopThreePodiumFinder.java`](./WEEK-5/TopThreePodiumFinder.java) | Single-pass top 3 tracking with tie handling ($O(N)$) |
| **Hackathon Seating Grid Optimizer** | [`HackathonSeatingGridOptimizer.java`](./WEEK-5/HackathonSeatingGridOptimizer.java) | 2D jagged grid averaging, zone classification |
| **Placement Drive Shortlisting Engine** | [`PlacementDriveEngine.java`](./WEEK-5/PlacementDriveEngine.java) | Records/OOP, overloaded eligibility filters, Java Streams & Sorting |

#### 🔹 Assignment Solutions (`Week-5-Assignments/`)
| Problem | File | Key Concepts |
| :--- | :--- | :--- |
| **Fantasy Team Score Multiplier** | [`FantasyTeamScoreMultiplier.java`](./Week-5-Assignments/FantasyTeamScoreMultiplier.java) | Positional multipliers (Captain $2.0\times$, Vice-Captain $1.5\times$) in-place |
| **Duplicate Player Pick Checker** | [`DuplicatePlayerPickChecker.java`](./Week-5-Assignments/DuplicatePlayerPickChecker.java) | Linear lineup validation without Collections |
| **Top Performer Tracker** | [`TopPerformerTracker.java`](./Week-5-Assignments/TopPerformerTracker.java) | Single-pass Min/Max/Spread calculation |
| **Match Day Grid Analyzer** | [`MatchDayGridAnalyzer.java`](./Week-5-Assignments/MatchDayGridAnalyzer.java) | 2D match run rates, helper method reuse, threshold classification |
| **Fantasy League Auto-Draft Engine** | [`FantasyLeagueAutoDraft.java`](./Week-5-Assignments/FantasyLeagueAutoDraft.java) | `Comparable<Player>`, overloaded eligibility checks, `Arrays.sort` ranking |

---

## 🛠️ How to Compile and Run

Make sure you have **JDK 17+** (JDK 21 or 25 recommended) installed on your system.

### 1. Clone the Repository
```bash
git clone https://github.com/ak4746/Step_semester_3.git
cd Step_semester_3
```

### 2. Compile and Run Any Specific Program
Navigate to the root directory and execute:

```bash
# Example: Running Palindrome Checker from WEEK-1
javac WEEK-1/PalindromeChecker.java
java -cp WEEK-1 PalindromeChecker

# Example: Running 3Sum from Week-4-Assignments
javac Week-4-Assignments/ThreeSum.java
java -cp Week-4-Assignments ThreeSum

# Example: Running Fantasy League Auto-Draft from Week-5-Assignments
javac Week-5-Assignments/FantasyLeagueAutoDraft.java
java -cp Week-5-Assignments FantasyLeagueAutoDraft
```

### 3. Batch Compile All Solutions in a Directory
```bash
# Windows (PowerShell)
javac WEEK-1/*.java
javac Week-1-Assignments/*.java
javac WEEK-2/*.java
javac Week-2-Assignments/*.java
javac WEEK-4/*.java
javac Week-4-Assignments/*.java
javac WEEK-5/*.java
javac Week-5-Assignments/*.java
```

---

## 👤 Author

- **GitHub**: [@ak4746](https://github.com/ak4746)
- **Repository**: [ak4746/Step_semester_3](https://github.com/ak4746/Step_semester_3)

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
