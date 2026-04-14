# ⚽ Soccer League Stats

A Java program that tracks team statistics for a soccer league by processing game scores from CSV files and responding to various stat queries.

---

## 📋 Assignment Overview

As game scores are reported, the program maintains team records and computes statistics including wins, draws, losses, goals for/against, and points. It reads game data from a `.csv` file and processes a transaction file containing stat requests.

---

## 📁 Project Structure

```
├── SoccerStats.java         # Core class - reads CSV and processes stat queries
├── TeamInfo.java            # Stores per-team statistics
├── GameInfo.java            # Represents individual game records
├── LinkedStack.java         # Generic linked-list based stack implementation
├── StackInt.java            # Stack interface
├── SoccerLeagueTest.java    # Test driver demonstrating SoccerStats usage
├── games1-8.csv             # Sample game data (8 games)
├── games1-24.csv            # Larger sample game data (24 games)
└── trans.txt                # Sample transaction/query file
```

---

## 🧠 How It Works

### Input: CSV Game File

Each line in the CSV file represents one game:

```
Home Team,Away Team,Home Goals,Away Goals
```

### Input: Transaction File

Each line contains one of the following queries:
| Command | Description |
|---|---|
| `STATS <team>` | Display stats for a specific team |
| `BEST` | Display stats for the team with the most points |
| `HSCORING` | List teams that scored more goals than the `BEST` team |

### Output Format

```
TEAM: Borussia Dortmund W: 0 D: 0 L: 1 GF: 2 GA: 3 PTS: 0
BEST: Meidericher SV W: 1 D: 0 L: 0 GF: 4 GA: 1 PTS: 3
HIGH SCORERS: NONE
```

**Points system:** 3 pts for a win, 1 pt for a draw, 0 for a loss.

**BEST tiebreakers (in order):**

1. Most points
2. Largest goal differential (GF - GA)
3. Most goals scored

---

## 🚀 Running the Program

### Compile

```bash
javac *.java
```

### Run

```bash
java SoccerLeagueTest
```

The test driver will prompt for or use a predefined CSV file and transaction file. You can swap in `games1-8.csv` or `games1-24.csv` along with `trans.txt` to test different scenarios.

---

## 🛠️ Key Classes

### `SoccerStats`

- **Constructor** `SoccerStats(String csvFile)` — reads and parses the CSV, builds internal team records
- **Method** `getStats(String statsFile)` — processes the transaction file and returns formatted output

### `TeamInfo`

Stores a team's running statistics: name, wins, draws, losses, goals for, goals against, and computed points.

### `GameInfo`

Represents a single game entry with home team, away team, home goals, and away goals.

### `LinkedStack<T>` / `StackInt<T>`

A generic stack backed by a linked list, implementing the `StackInt` interface.

---

## 🗄️ Data Handling

- Team data is managed using a `HashMap` for efficient storage and retrieval, with team names as keys.
- Each team's statistics are encapsulated in the `TeamInfo` class, updated as game results are processed.
- The program reads from two separate input files: a CSV file for game scores and a text file for stat requests.
- The design supports scaling to large datasets without performance concerns.

---

## 📌 Notes

- All `.java` files were written as part of this solution.
- The solution is designed to handle large datasets efficiently.

---
