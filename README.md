# Assignment 3: Bridge Pattern Implementation (Variant A)

**Author:** Dinara Nurzhaubay  
**Group:** SE-2526  
**Topic:** Variant A — Shape (Circle, Square) & Renderer (Vector, Raster, Ascii)

---

## 1. Domain & Variant Details
* **Abstraction Hierarchy:** `Shape` (Abstract) -> `Circle` (A1, radius=2), `Square` (A2, side=3)
* **Implementor Hierarchy:** `Renderer` (Interface) -> `VectorRenderer` (I1), `RasterRenderer` (I2), `AsciiRenderer` (I3)

---

## 2. Base 2x2 Commit Hash
* **BASE_COMMIT:** `719627a9e0c91073cc1a73241c7bfc279b09cd36`

---

## 3. How to Run

### Compilation
```bash
javac --release 17 -d out "@sources.txt"