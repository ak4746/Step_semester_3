# Week 9: Abstraction & Interfaces - Quiz Answers & Concepts

---

## Part B — Quiz Answers & Explanations

### Q1. Which of the following best describes abstraction in object-oriented programming?
- A. Showing all internal details of an object to the user
- B. Protecting data inside an object from unauthorized access
- **C. Hiding how an object performs its operations and showing only what it does**
- D. Allowing a class to inherit from multiple parent classes

**Answer:** **C. Hiding how an object performs its operations and showing only what it does**  
**Explanation:** Abstraction focuses on exposing essential features and behaviors of an object while hiding internal implementation details and complexity from the outside world.

---

### Q2. Which statement about an abstract class in Java is true?
- A. It must contain at least one abstract method
- B. It can be instantiated if it has no abstract methods
- **C. It cannot be instantiated directly**
- D. It can extend multiple other classes

**Answer:** **C. It cannot be instantiated directly**  
**Explanation:** An abstract class in Java cannot be instantiated with `new`. It is meant to be subclassed. It does not need to have any abstract methods to be declared abstract.

---

### Q3. If a concrete class extends an abstract class but fails to implement an inherited abstract method, what is the consequence?
- A. Java automatically provides an empty implementation for the method
- **B. The class must be declared abstract, or the code will not compile**
- C. A runtime error will occur only when the unimplemented method is called
- D. The compiler will issue a warning but still allow compilation

**Answer:** **B. The class must be declared abstract, or the code will not compile**  
**Explanation:** If a subclass does not implement all inherited abstract methods, it remains abstract itself and must be declared with the `abstract` keyword; otherwise, a compile-time error occurs.

---

### Q4. Which of the following modifiers is NOT allowed for an abstract method in Java?
- A. protected
- B. public
- **C. private**
- D. default (package-private)

**Answer:** **C. private**  
**Explanation:** An abstract method must be overridden by a subclass. A `private` method is not visible to or overridable by subclasses, so declaring an abstract method `private` results in a compilation error.

---

### Q5. Fields declared within a Java interface are implicitly:
- A. private and static
- B. protected and final
- **C. public, static, and final**
- D. public and instance-specific

**Answer:** **C. public, static, and final**  
**Explanation:** Any field defined inside an interface is implicitly `public`, `static`, and `final` (constants). Interfaces cannot hold instance state.

---

### Q6. How many interfaces can a single Java class implement?
- A. Only one interface at a time
- B. At most two interfaces
- **C. Any number of interfaces**
- D. None, if the class already extends another class

**Answer:** **C. Any number of interfaces**  
**Explanation:** Java does not allow multiple class inheritance (`extends`), but allows a class to implement any number of interfaces (`implements InterfaceA, InterfaceB, ...`).

---

### Q7. If a class implements an interface, what access modifier must it use for the implemented methods?
- A. default (package-private)
- B. private
- C. protected
- **D. public**

**Answer:** **D. public**  
**Explanation:** Interface methods are implicitly `public` (or `public abstract`). In Java, an overriding method cannot reduce the visibility of the inherited method, so the implementing class must declare them `public`.

---

### Q8. Why does Java allow a class to implement multiple interfaces but only extend a single class?
- A. Implementing interfaces makes the code run faster
- B. Classes are unable to contain any methods
- **C. Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance**
- D. Interfaces are compiled independently from classes

**Answer:** **C. Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance**  
**Explanation:** Because interfaces cannot define instance fields (instance state), multiple interface implementation avoids ambiguous state inheritance that causes the classic diamond problem with classes.

---

### Q9. What happens if a class implements two interfaces that both provide a default method with the same signature, and the class does not override this method?
- A. The method from the first interface listed in the implements clause is used
- B. The method from the last interface listed in the implements clause is used
- C. A runtime exception occurs when the method is called
- **D. A compile-time error occurs until the class overrides the method**

**Answer:** **D. A compile-time error occurs until the class overrides the method**  
**Explanation:** When two implemented interfaces declare the same default method signature, Java produces a compile-time ambiguity error. The implementing class must explicitly override the method and resolve the conflict.

---

### Q10. Which of the following is true regarding constructors in Java?
- A. Concrete classes cannot have constructors
- **B. Abstract classes can have constructors that run when a subclass object is created**
- C. Interfaces must have at least one constructor
- D. Constructors in abstract classes are used to create objects of the abstract class directly

**Answer:** **B. Abstract classes can have constructors that run when a subclass object is created**  
**Explanation:** Even though abstract classes cannot be directly instantiated with `new`, they can declare constructors to initialize base state. These constructors are called via `super(...)` during subclass object instantiation.
