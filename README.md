
# Java 21 Features 🚀
<p align="center">

<img src="https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=java" />
<img src="https://img.shields.io/badge/JDK-LTS-orange?style=for-the-badge" />
<img src="https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven" />
<img src="https://img.shields.io/github/stars/dinesh-veer/java-21-features?style=for-the-badge" />
<img src="https://img.shields.io/github/forks/dinesh-veer/java-21-features?style=for-the-badge" />
<img src="https://img.shields.io/github/last-commit/dinesh-veer/java-21-features?style=for-the-badge" />
<img src="https://img.shields.io/github/repo-size/dinesh-veer/java-21-features?style=for-the-badge" />
<img src="https://img.shields.io/github/license/dinesh-veer/java-21-features?style=for-the-badge" />

</p>


A curated collection of **Java 21** feature demonstrations and code examples — ideal for learning, experimentation, and reference.

This repository showcases the most important additions and improvements in **Java JDK 21**, the latest Long-Term Support (LTS) release of the Java language. :contentReference[oaicite:0]{index=0}

---

## 🚧 Status

| Feature | Status |
|---------|--------|
| Virtual Threads (Project Loom) | Final |
| Structured Concurrency | Preview |
| Scoped Values | Preview |
| Pattern Matching (instanceof & switch) | Final / Preview |
| Sequenced Collections | Final |
| String Templates | Preview |
| Foreign Function & Memory API | Third Preview |
| Unnamed Patterns & Variables | Preview |

Some features require compiling with **preview flags**. :contentReference[oaicite:1]{index=1}

---

## 📁 Repository Structure

```

java-21-features/
├── src/
│   └── main/
│       └── java/
│           └── com/dinesh/
│               ├── virtualthreads/
│               ├── patternmatching/
│               ├── sequencedcollections/
│               ├── stringtemplates/
│               └── scopedvalues/
├── .gitignore
├── LICENSE
└── README.md

````

Each package contains self-contained examples illustrating the feature in action.

---

## 🧠 Java 21 Highlights
<p align="center">

<img src="https://img.shields.io/badge/Virtual%20Threads-JEP%20444-green?style=flat-square" />
<img src="https://img.shields.io/badge/Sequenced%20Collections-JEP%20431-blue?style=flat-square" />
<img src="https://img.shields.io/badge/String%20Templates-JEP%20430-purple?style=flat-square" />
<img src="https://img.shields.io/badge/Record%20Patterns-JEP%20440-orange?style=flat-square" />

</p>


### 🧵 1. Virtual Threads (JEP 444)
Lightweight concurrency support for massive numbers of threads with minimal resource usage.

Example:
```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> System.out.println("Hello from a virtual thread!"));
}
````

---

### 🔎 2. Pattern Matching Enhancements

Destructure records and types more expressively:

```java
if (obj instanceof Point(int x, int y)) {
    System.out.println(x + y);
}
```

---

### 📦 3. Sequenced Collections (JEP 431)

New interfaces for defining **ordered collections** with first/last element access.

Example:

```java
SequencedCollection<String> seq = new LinkedList<>();
seq.addLast("A");
```

---

### 📜 4. String Templates (JEP 430 — Preview)

Improved safe string interpolation:

```java
String result = STR."Hello \{name}";
```

⚠ Requires preview flags to compile/run. ([Javacody][1])

---

### 🌐 5. Scoped Values

Safer alternative to `ThreadLocal` especially when used with virtual threads.

---

## 🧪 How to Compile / Run with Preview

Some examples use preview language features. To compile & run:

```bash
javac --enable-preview --release 21 $(find . -name "*.java")
java --enable-preview -cp . com.dinesh.Main
```

Or using Maven:

```xml
<configuration>
  <release>21</release>
  <compilerArgs>--enable-preview</compilerArgs>
</configuration>
```

---

## 📝 Notes

* This repository assumes **JDK 21** installed and available on your `PATH`.
* Some features are **preview**; they will not compile/run without enabling preview support. ([Oracle Docs][2])
* Refer to the official OpenJDK JEPs for detailed spec and examples.

---

## 📚 References

* Official Java 21 release notes & feature list. ([Oracle][3])
* Comprehensive breakdown of Java 21 language and library improvements. ([baeldung.com][4])

---

## 🧾 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Contributing

Feel free to fork the repo, add new Java 21 features or examples, and submit pull requests.

If you find this project useful or plan to use it as a reference:

* ⭐ **Star the repository** to show your support
* 🍴 **Fork the repository** to experiment, customize, and extend it

Starring helps others discover the project, and forking allows you to safely modify and learn without affecting the original codebase.

Thank you for your support! 🙌

---

## 🔗 Repository

[github.com/dinesh-veer/java-21-features](https://github.com/dinesh-veer/java-21-features)

---

## 📬 Contact

For questions, feedback, or collaboration:

**Dinesh Veer**

📧 Email: [dveer123@hotmail.com](mailto:dveer123@hotmail.com)

🔗 GitHub: [@dinesh-veer](https://github.com/dinesh-veer)

---