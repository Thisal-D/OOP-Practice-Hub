## 📚 Classes and Their Responsibilities

Design a Java program that demonstrates **bi-directional association** between a **Ward** and its **Staff**, along with basic **inheritance** and **method overriding**.

---

### 1. Staff (Base Class)
- **Attributes:**
  - `int id`
  - `String name`
  - `Ward ward`  
    (reference back to the Ward—“many → one” side of the association)
- **Constructor:**  
  `Staff(int id, String name)`
- **Methods:**
  - `void setWard(Ward w)`  
    → assigns the `ward` field
  - `void displayInfo()`  
    → to be *overridden* by subclasses; should also print the ward’s name if set

---

### 2. Doctor (Subclass of Staff)
- **Adds:**
  - `String specialty`
  - `double consultationFee`
- **Constructor:**  
  `Doctor(int id, String name, String specialty, double consultationFee)`
- **Overrides:**
  - `displayInfo()` → prints `id`, `name`, `specialty`, `consultationFee` **and** the name of the `ward`

---

### 3. Nurse (Subclass of Staff)
- **Adds:**
  - `int shiftHours`
  - `String[] certifications`
- **Constructor:**  
  `Nurse(int id, String name, int shiftHours, String[] certifications)`
- **Overrides:**
  - `displayInfo()` → prints `id`, `name`, `shiftHours`, `certifications` **and** the name of the `ward`

---

### 4. Ward (Independent Class)
- **Attributes:**
  - `int id`
  - `String name`
  - `List<Staff> staffMembers`  
    (holds all `Doctor` and `Nurse` instances—“one → many” side)
- **Constructor:**  
  `Ward(int id, String name)`
- **Methods:**
  - `void addStaff(Staff s)`  
    1. adds `s` to `staffMembers`  
    2. calls `s.setWard(this)`  
    → ensures **bi-directional linkage**  
  - `void displayInfo()`  
    → prints `id`, `name`, then invokes `displayInfo()` on each `Staff`

---

## 🔥 OOP Concepts Used

| Concept                    | How it is used                                                                                         |
|----------------------------|---------------------------------------------------------------------------------------------------------|
| **Bi-Directional Association** | `Ward` holds a list of `Staff`; each `Staff` has a reference back to its `Ward`.                        |
| **Inheritance**            | `Doctor` and `Nurse` extend `Staff`.                                                                    |
| **Override**               | Both subclasses override `displayInfo()` to include specific details and ward name.                     |

---

## public static void main(String[] args)
1. Create a **Ward** (e.g., “Pediatrics”).
2. Create several **Doctor** and **Nurse** objects.
3. Add each `Staff` to the `Ward` via `addStaff(...)`.
4. Call `ward.displayInfo()` to show the ward and its team.
