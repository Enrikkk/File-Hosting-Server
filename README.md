

# NanoFiles – File Hosting Server

A **peer-to-peer file hosting system** implemented in Java as part of the **Redes de Comunicaciones (Computer Networks) course, 2024/25, Universidad de Murcia**.

The project provides a **Directory Server** (centralized entry point) and multiple **NanoFiles Peers**, which can register files, query available peers, and download files from one another using **UDP** (for directory communication) and **TCP** (for peer-to-peer file transfers).

---

## 📂 Project Structure

The project is organized into several packages, each handling a different responsibility:

* **`es.um.redes.nanoFiles.application`** – main entry points (`NanoFiles`, `Directory`).
* **`es.um.redes.nanoFiles.logic`** – controllers and protocol logic.
* **`es.um.redes.nanoFiles.udp`** – UDP-based directory communication (client/server).
* **`es.um.redes.nanoFiles.tcp`** – TCP-based peer-to-peer file transfer (client/server).
* **`es.um.redes.nanoFiles.shell`** – command-line interface and commands.

---

## 🚀 Features

* Central **Directory Server** for peer registration and discovery (UDP).
* **NanoFiles peers** that can:

  * Perform a **ping** to check directory availability.
  * Register and query available files.
  * Launch a **file server** for sharing files (TCP).
  * Connect to other peers and **download files**.
* Interactive shell for user-friendly commands.

---

## ⚙️ Prerequisites

* **Java Runtime Environment (JRE)** installed (Java 8 or newer).
* The `java -jar` command must be available in your system’s PATH.

  * To check:

    ```bash
    java -version
    ```
  * If not installed, download Java from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use your OS package manager.

---

## ▶️ Running the Project

1. **Clone the repository**:

   ```bash
   git clone https://github.com/Enrikkk/File-Hosting-Server.git
   cd File-Hosting-Server
   ```

2. **Run the Directory Server** (provide IP and port):

   ```bash
   java -jar Directory.jar
   ```

3. **Run a NanoFiles Peer** (provide directory IP and port):

   ```bash
   java -jar NanoFiles.jar 
   ```
   
  **Both Directoy Server and NanoFiles Peer will ask you for the connection data once executed**

4. Use the **shell commands** inside NanoFiles to interact with the directory and other peers.

👉 For extended instructions and demonstrations, see the **[project documentation (PDF)](./docs/)** and the **[demo video](./demo/)** included in the repository.

---

## 💻 Shell Commands

When running a NanoFiles peer, the following commands are available:

| Command               | Description                                                                 |
| --------------------- | --------------------------------------------------------------------------- |
| `ping`                | Sends a ping message to the directory to check availability.                |
| `myfiles`             | Displays the list of files available in the local peer.                     |
| `serve`               | Starts the peer’s TCP file server for sharing files.                        |
| `filelist`            | Requests from the directory the list of all available files in the network. |
| `download <filename>` | Downloads the specified file from another peer.                             |
| `help`                | Displays available commands (more than the ones shown here) and basic usage instructions.                   |
| `quit`                | Disconnects from the directory and exits the peer application.              |

---

## 📖 Documentation

* [📄 PDF Report](./docs/) – detailed description of the system, protocols, and implementation.
* [🎥 Demo Video](./demo/) – short video showing the project in action.

---

## 👩‍🏫 Acknowledgments

This project was developed as part of the **Redes de Comunicaciones course (2024/25)** at the **Universidad de Murcia**.


