
# cljs-intersection-observer

### Overview

The <strong>cljs-intersection-observer</strong> is a simple ClojureScript library for DOM intersection observers.

### deps.edn

```
{:deps {bithandshake/cljs-intersection-observer {:git/url "https://github.com/bithandshake/cljs-intersection-observer"
                                                 :sha     "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"}}
```

### Current version

Check out the latest commit on the [release branch](https://github.com/bithandshake/cljs-intersection-observer/tree/release).

### Documentation

The <strong>cljs-intersection-observer</strong> functional documentation is [available here](documentation/COVER.md).

### Changelog

You can track the changes of the <strong>cljs-intersection-observer</strong> library [here](CHANGES.md).

### Index

- [How to setup an intersection observer?](#how-to-setup-an-intersection-observer)
- [How to remove an intersection observer?](#how-to-remove-an-intersection-observer)

# Usage

### How to add an intersection observer?

The [`intersection-observer.api/setup-observer!`](documentation/cljs/intersection-observer/API.md#setup-observer)
function setups an intersection observer.
Only use this function when the observed element is already mounted into the React-tree!

```
(defn my-component []
  [:div {:id :my-element}
        (setup-observer! "my-element" (fn [intersecting?] ...))])

```

### How to remove an intersection observer?

The [`intersection-observer.api/remove-observer!`](documentation/cljs/intersection-observer/API.md#remove-observer)
function removes an existing intersection observer.

```
(remove-observer! "my-element")
```
