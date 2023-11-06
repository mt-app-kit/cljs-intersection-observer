
### intersection-observer.api

Functional documentation of the intersection-observer.api ClojureScript namespace

---

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > intersection-observer.api

### Index

- [remove-observer!](#remove-observer)

- [setup-observer!](#setup-observer)

---

### remove-observer!

```
@param (string) element-id
```

```
@usage
(remove-observer! "my-element")
```

```
@return (undefined)
```

<details>
<summary>Source code</summary>

```
(defn remove-observer!
  [element-id]
  (if-let [element (dom/get-element-by-id element-id)]
          (when-let [observer (get @intersection-observer.state/INTERSECTION-OBSERVERS element-id)]
                    (swap! intersection-observer.state/INTERSECTION-OBSERVERS dissoc element-id)
                    (dom/remove-intersection-observer! observer element))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [intersection-observer.api :refer [remove-observer!]]))

(intersection-observer.api/remove-observer! ...)
(remove-observer!                           ...)
```

</details>

---

### setup-observer!

```
@warning
Only use this function when the observed element is already mounted into the DOM-tree!
```

```
@param (string) element-id
@param (function) callback-f
```

```
@usage
(setup-observer! "my-element" (fn [intersecting?] ...))
```

<details>
<summary>Source code</summary>

```
(defn setup-observer!
  [element-id callback-f]
  (if-let [element (dom/get-element-by-id element-id)]
          (let [observer (dom/setup-intersection-observer! element callback-f)]
               (swap! intersection-observer.state/INTERSECTION-OBSERVERS assoc element-id observer))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [intersection-observer.api :refer [setup-observer!]]))

(intersection-observer.api/setup-observer! ...)
(setup-observer!                           ...)
```

</details>

---

<sub>This documentation is generated with the [clj-docs-generator](https://github.com/bithandshake/clj-docs-generator) engine.</sub>

