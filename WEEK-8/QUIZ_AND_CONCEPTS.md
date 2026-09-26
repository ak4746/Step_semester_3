# Week 8: Inheritance & Polymorphism - Quiz & Concept Questions

---

## Part 1: Quiz Questions and Answers

### Question 1
A system processes Document objects. It initially had PDFDocument and WordDocument classes, both inheriting from Document and implementing a render() method. A developer observes repeated if-else if blocks checking the document type before calling render(). What is the most appropriate OOP principle to apply to eliminate this conditional logic?
- A Encapsulation
- B Method overloading
- **C Polymorphism**
- D Abstraction

**Answer:** **C Polymorphism**  
**Explanation:** Polymorphism allows calling `document.render()` on a base-type reference (`Document`), allowing dynamic runtime method dispatch to execute the subclass-specific rendering logic without checking types via `if-else if`.

---

### Question 2
Which of the following scenarios represent a genuine 'is-a' relationship, making inheritance a suitable design choice? (Select all that apply)
- **A A `Car` is a `Vehicle`.**
- **B A `Rectangle` is a `Shape`.**
- **C A `DatabaseConnection` is a `NetworkResource`.**
- D A `HelperUtility` contains a `Calculator`.

**Answer:** **A, B, C**  
**Explanation:** Options A, B, and C describe true specialized subtypes of a general type ('is-a'). Option D represents a composition/containment relationship ('has-a'), where composition should be favored over inheritance.

---

### Question 3
Consider a Vehicle base class with a method startEngine() and two derived classes, Car and Motorcycle, both overriding startEngine() with their specific engine start sounds. If you have a list of Vehicle objects, some being Car instances and some Motorcycle instances, and you iterate through this list calling startEngine() on each object, what mechanism ensures the correct startEngine() implementation is called for each vehicle type?
- A Static method binding
- B Compile-time polymorphism
- **C Runtime method dispatch**
- D Method overloading

**Answer:** **C Runtime method dispatch**  
**Explanation:** In Java, instance method calls are resolved dynamically at runtime based on the actual runtime object type using virtual method tables (runtime method dispatch / dynamic binding).

---

### Question 4
A Shape base class has a method calculateArea(). Circle and Rectangle are derived classes, each with their own implementation of calculateArea(). If a program stores various Shape objects in a list and then calls calculateArea() on each, what concept is being demonstrated?
- A Method hiding
- B Method overloading
- **C Inheritance-based polymorphism**
- D Composition

**Answer:** **C Inheritance-based polymorphism**  
**Explanation:** Using a common base class reference (`Shape`) to execute overridden derived class methods (`calculateArea()`) across various subclasses is classic inheritance-based polymorphism.

---

### Question 5
A software component is designed to manage various LibraryItem types like Book and DVD. Both Book and DVD inherit from LibraryItem. The LibraryItem class has a getLoanPeriod() method. The Book class extends this method by adding a special rule for new releases, while the DVD class sets a fixed loan period. Which of the following statements accurately describe the behavior in this system? (Select all that apply)
- **A `getLoanPeriod()` in `Book` is an example of extending inherited behavior.**
- B `getLoanPeriod()` in `DVD` is an example of shared behavior.
- **C The `LibraryItem` class defines the common behavior for all library items.**
- **D A `DVD` object can be processed as a `LibraryItem` through a common reference.**

**Answer:** **A, C, D**  
**Explanation:** Statement A is true (Book extends the behavior), Statement C is true (`LibraryItem` defines common interface/behavior), and Statement D is true (upcasting enables polymorphic processing). Statement B is false because DVD overrides the method with its own fixed period rather than sharing a single implementation.

---

### Question 6
Consider a base class Animal with a method makeSound() and derived classes Dog and Cat, which override makeSound() to produce 'Woof' and 'Meow' respectively. Which of the following statements about the behavior of these classes are correct? (Select all that apply)
- **A If a `Dog` object is referred to by an `Animal` reference, calling `makeSound()` will execute `Dog`'s `makeSound()`.**
- B The `makeSound()` method in `Animal` is an example of specialized behavior.
- **C The `makeSound()` method in `Dog` is an example of overridden behavior.**
- D New behavior can only be added to derived classes if it is also declared in the base class.

**Answer:** **A, C**  
**Explanation:** Option A illustrates dynamic dispatch. Option C correctly identifies that Dog provides overridden behavior. Option B is incorrect (`Animal` defines general, not specialized behavior). Option D is incorrect because derived classes can introduce new methods unique to themselves.

---

### Question 7
A PaymentProcessor system processes CardPayment and BankTransferPayment objects. Both CardPayment and BankTransferPayment derive from a Payment base class and override a calculateFee() method. If the PaymentProcessor maintains a collection of Payment references, what is the primary benefit of this design when adding a new WalletPayment type?
- A It reduces the need for new data members in the base class.
- B It ensures all payment types use the same fee calculation logic.
- **C It allows adding `WalletPayment` without modifying the existing `PaymentProcessor`'s iteration logic.**
- D It enhances the security of payment transactions.

**Answer:** **C It allows adding `WalletPayment` without modifying the existing `PaymentProcessor`'s iteration logic.**  
**Explanation:** This satisfies the Open/Closed Principle: the payment processor is open for extension (adding new payment types) but closed for modification (the processor loop remains untouched).

---

### Question 8
What is the primary reason why using inheritance solely for superficial code reuse between unrelated classes is generally considered an inappropriate design choice?
- **A It leads to tighter coupling and incorrect 'is-a' relationships, making the design rigid.**
- B It always results in slower program execution due to increased overhead.
- **C It complicates debugging by creating too many small classes.**
- D It prevents the use of interfaces in the system.

**Answer:** **A It leads to tighter coupling and incorrect 'is-a' relationships, making the design rigid.**  
**Explanation:** Misusing inheritance creates tight coupling, exposes internal details of the superclass, violates Liskov Substitution Principle (LSP), and forces subclasses to inherit methods that make no semantic sense. Composition should be used instead for reuse.

---

### Question 9
A Notification base class has a send() method. Derived classes EmailNotification, SMSNotification, and PushNotification each override send() to implement channel-specific delivery logic. What are the advantages of using inheritance and polymorphism in this notification system design? (Select all that apply)
- **A It allows a generic `NotificationSender` to send various types of notifications without knowing their concrete types.**
- B It centralizes all notification logic into a single `Notification` class, reducing code duplication across derived classes.
- **C It simplifies the process of adding a new notification channel, like `InAppNotification`, without altering existing sender logic.**
- D It ensures that all notification types use the exact same `send()` implementation, regardless of the channel.

**Answer:** **A, C**  
**Explanation:** Options A and C highlight polymorphism and extensibility. Option B is false because sending logic is distributed among subclasses. Option D is false because each channel requires a distinct `send()` mechanism.

---

### Question 10
Which of the following are benefits of using polymorphic collections (e.g., a list of base class references holding derived class objects)? (Select all that apply)
- **A It simplifies iterating over diverse but related objects.**
- **B It allows for uniform processing of objects with specialized behavior.**
- **C It reduces the need for explicit type casting in common processing loops.**
- D It makes it harder to add new derived types to the system.

**Answer:** **A, B, C**  
**Explanation:** Polymorphic collections allow diverse derived instances to be stored together and processed through common base contracts without explicit `instanceof` checks or downcasting. Option D is incorrect as it makes adding new derived types much easier.

---

## Part 2: Concept Questions and Answers

### Question 1: Inheritance for Reuse and Extension
**Explanation:**  
Inheritance allows a derived class to inherit existing attributes and concrete methods from a base class, eliminating code duplication. Concurrently, the derived class can:
1. **Extend** the base behavior by adding new fields and methods.
2. **Modify** behavior by overriding inherited methods to implement domain-specific requirements.

**Concrete Business Example:**  
In a banking system, a base class `BankAccount` handles account balance, account number, deposit, and statement generation. A specialized subclass `SavingsAccount` reuses the balance tracking and deposit methods directly from `BankAccount`, but extends it with an `interestRate` field and an `accrueInterest()` method, and overrides `withdraw()` to enforce a minimum daily balance rule.

---

### Question 2: The 'is-a' Relationship in OOP
**Explanation:**  
The 'is-a' relationship signifies that a specialized class is a concrete subtype of a more general class. Every instance of the subclass must be fully substitutable for the base class without breaking the correctness of the program (Liskov Substitution Principle).

**Why Identifying Genuine 'is-a' is Crucial:**  
If inheritance is applied without a genuine 'is-a' relationship (for example, making `Stack` inherit from `ArrayList` just to reuse list methods), the subclass inherits methods that violate its invariants (such as inserting elements in the middle of a stack). This leads to fragile architectures, unexpected side-effects, and high maintenance costs.

---

### Question 3: Method Overriding in Business Systems
**Explanation:**  
Method overriding occurs when a subclass provides its own specific implementation of a method that is already declared in its superclass, using the exact same method signature and return type (or covariant return type).

**Realistic Business Scenario:**  
Consider a base class `Employee` with an abstract or default method `calculateSalary()`.
- `SalariedEmployee` overrides `calculateSalary()` to return `baseMonthlySalary`.
- `HourlyEmployee` overrides `calculateSalary()` using `hoursWorked * hourlyRate + overtimeBonus`.
- `CommissionEmployee` overrides `calculateSalary()` using `baseSalary + (salesVolume * commissionRate)`.

The payroll engine simply calls `employee.calculateSalary()` on a collection of `Employee` instances, and each subclass applies its own distinct calculation.

---

### Question 4: Runtime Polymorphism and Dynamic Dispatch
**Explanation:**  
Runtime polymorphism (dynamic method dispatch) is the mechanism where a call to an overridden method is resolved at runtime rather than compile time.

**How the System Determines the Implementation:**  
When a method is invoked on a base-type reference (e.g., `Vehicle v = new Car(); v.startEngine();`):
1. **Compile Time:** The compiler checks the declared type (`Vehicle`) to ensure that `startEngine()` exists and is accessible.
2. **Runtime:** The Java Virtual Machine (JVM) inspects the actual object on the heap (`Car`).
3. The JVM uses the object's internal virtual method table (vtable) pointer to look up the concrete method implementation corresponding to `Car.startEngine()` and executes it.

---

### Question 5: Polymorphic Collections
**Explanation:**  
A polymorphic collection is a data structure (such as `List<BaseType>`) typed to a superclass or interface that stores heterogeneous instances of any subclass inheriting from that base type.

**Example:**
```java
List<Payment> payments = new ArrayList<>();
payments.add(new CardPayment(1000));
payments.add(new WalletPayment(500));
payments.add(new BankTransferPayment(2000));

for (Payment p : payments) {
    total += p.calculateFinalAmount();
}
```
**Advantages:**
- Uniform processing loop without needing separate lists for each subtype.
- Elimination of conditional logic and casting.
- Clean separation between storage, iteration, and specific business calculation.

---

### Question 6: Polymorphism vs. Type-Based Conditional Logic
**Comparison:**
- **Conditional Logic (`if-else` / `switch`):** Inspects the type of object (e.g., checking `payment.type == "CARD"` or `instanceof`). Every time a new type is added, every switch or if-else block across the entire application must be located and modified, violating the Open/Closed Principle.
- **Polymorphism:** Delegates the varying behavior to the object itself via method overriding.

**Why Polymorphism is Preferred:**
- **Extensibility:** New classes are introduced without touching existing processing logic.
- **Maintainability & Encapsulation:** Business logic for a specific type lives inside that type's class rather than scattered across procedural conditionals.
- **Reduced Error Surface:** Eliminates missed cases in switch statements.

---

### Question 7: Adding New Derived Types with Zero Modifications
**Explanation:**  
Because the central processing logic only depends on the base class contract (the abstraction), adding a new derived class requires no changes to the processing pipeline.

**Example:**  
In our `PaymentProcessor`:
```java
public void process(List<Payment> payments) {
    for (Payment payment : payments) {
        double fee = payment.calculateFinalAmount();
        // ...
    }
}
```
If tomorrow a new `CryptoPayment` or `UpiPayment` method is introduced:
1. Define `class UpiPayment extends Payment`.
2. Implement `calculateFinalAmount()`.
3. Pass `new UpiPayment(...)` into the `payments` list.
The `PaymentProcessor` executes seamlessly without a single line of modification.

---

### Question 8: Inherited Behavior vs. Overridden Behavior
**Distinction:**
- **Inherited Behavior:** A subclass uses the superclass's implementation directly without changes. Used when the behavior is universal and identical across all subtypes.
- **Overridden Behavior:** A subclass replaces the superclass's implementation with its own specialized logic. Used when subtypes share a common concept or contract but require divergent execution logic.

**Examples:**
- **Inherited:** In a `Vehicle` base class, `getRegistrationNumber()` and `getOwnerName()` are inherited as-is by both `Car` and `Truck` because retrieving basic properties is identical.
- **Overridden:** In `Vehicle`, `calculateTollTax()` is overridden because a `Car` pays a flat rate while a `Truck` calculates toll based on weight and number of axles.

---

### Question 9: Dangers of Inheritance Solely for Code Reuse
**Explanation:**  
Inheriting solely to reuse a few utility methods when no semantic 'is-a' relationship exists is an anti-pattern ("implementation inheritance" without subtyping).

**Negative Consequences:**
1. **Liskov Substitution Principle Violation:** The derived class cannot cleanly substitute for the base class.
2. **API Pollution:** The derived class inherits inappropriate methods that expose internal state or allow invalid operations.
3. **Fragile Base Class Problem:** Changes made to the base class can unpredictably break unrelated derived classes.
4. **Tight Coupling:** Subclasses become bound to base class implementation details.

---

### Question 10: VehicleRental Case Study: Common vs. Specialized Behavior
**Domain Analysis:**
In a `VehicleRental` system:
- **Common Behaviors (Defined in Base Class `Rental`):**
  - Tracking rental start date, duration, and customer information.
  - Generating rental receipts and checking availability.
  - Recording deposit and return status.
- **Specialized Behaviors (Overridden in Derived Classes):**
  - **`CarRental`:** Calculates fee based on daily rate with mileage limits; includes optional child seat and GPS add-on charges.
  - **`TruckRental`:** Calculates fee based on cargo weight capacity, hazardous material insurance surcharge, and commercial driver log compliance checks.

**Effective Modeling with Inheritance:**  
Create an abstract base class `Rental` containing shared state (`rentalId`, `durationDays`, `customer`) and concrete common methods (`confirmBooking()`, `getSummary()`). Declare an abstract method `calculateTotalCost()`. `CarRental` and `TruckRental` inherit the common foundation while overriding `calculateTotalCost()` to enforce their respective specialized commercial formulas.
